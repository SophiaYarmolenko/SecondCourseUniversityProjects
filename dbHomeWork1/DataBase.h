//
// Created by Sofiia on 29/01/2021.
//
#pragma once

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ChecksError.h"

#define SLAVE_FL "slave.fl"
#define SLAVE_GARBAGE "slaveGarbage.txt"
#define SLAVE_SIZE sizeof(struct Slave)
#define MASTER_IND "genre.ind"
#define MASTER_FL "genre.fl"
#define MASTER_GARBAGE "masterGarbage.txt"
#define INDEX_TABLE_SIZE sizeof(struct IndexTable)
#define MASTER_SIZE sizeof(struct Master)

int getMaster(struct Master* master, int id, char* error)
{
    FILE* indexTable = fopen(MASTER_IND, "rb");
    FILE* data = fopen(MASTER_FL, "rb");
    if (!checkFileExistence(indexTable, data, error))
    {
        return 0;
    }
    struct IndexTable indexer;
    if (!checkIndexExistence(indexTable, error, id))
    {
        return 0;
    }
    fseek(indexTable, (id - 1) * INDEX_TABLE_SIZE, SEEK_SET);
    fread(&indexer, INDEX_TABLE_SIZE, 1, indexTable);

    if (!checkRecordExistence(indexer, error))
    {
        return 0;
    }

    fseek(data, indexer.address, SEEK_SET);
    fread(master, sizeof(struct Master), 1, data);
    fclose(indexTable);
    fclose(data);

    return 1;
}

void info()
{
    FILE* indexTable = fopen("master.ind", "rb");

    if (indexTable == NULL)
    {
        printf("Error: database files are not created yet\n");
        return;
    }

    int masterCount = 0;
    int slaveCount = 0;

    fseek(indexTable, 0, SEEK_END);
    int indAmount = ftell(indexTable) / sizeof(struct IndexTable);

    struct Master master;

    char dummy[51];

    for (int i = 1; i <= indAmount; i++)
    {
        if ( getMaster(&master, i, dummy) )
        {
            masterCount++;
            slaveCount += master.slavesCount;

            printf("Genre #%d is genre %d film(s)\n", i, master.slavesCount);
        }
    }

    fclose(indexTable);

    printf("Number of genres: %d\n", masterCount);
    printf("Number of films: %d\n", slaveCount);
}

void readMaster(struct Master* master)
{
    char name[16];
    name[0] = '\0';

    printf("Give genre\'s name: ");
    scanf("%s", name);

    strcpy(master->name, name);
}

void printMaster(struct Master master)
{
    printf("Genre\'s name: %s\n", master.name);
}

void overwriteGarbage(int garbageCount, FILE* garbage, struct Master* newMaster)
{
    int* deletedIndexes = malloc(garbageCount * sizeof(int));

    for (int i = 0; i < garbageCount; i++)
    {
        fscanf(garbage, "%d", deletedIndexes + i);
    }

    newMaster->id = deletedIndexes[0];

    fclose(garbage);
    fopen(MASTER_GARBAGE, "wb");
    fprintf(garbage, "%d", garbageCount - 1);

    for (int i = 1; i < garbageCount; i++)
    {
        fprintf(garbage, " %d", deletedIndexes[i]);
    }

    free(deletedIndexes);
    fclose(garbage);
}

void noteDeletedMaster(int id)
{
    FILE* masterGarbage = fopen(MASTER_GARBAGE, "rb");
    int garbageNumber = 0;
    fscanf(masterGarbage, "%d", &garbageNumber);
    int* deletedIndexes = malloc(garbageNumber * sizeof(int));

    for (int i = 0; i < garbageNumber; i++)
    {
        fscanf(masterGarbage, "%d", deletedIndexes + i);
    }
    fclose(masterGarbage);

    masterGarbage = fopen(MASTER_GARBAGE, "wb");
    fprintf(masterGarbage, "%d", garbageNumber + 1);

    for (int i = 0; i < garbageNumber; i++)
    {
        fprintf(masterGarbage, " %d", deletedIndexes[i]);
    }

    fprintf(masterGarbage, " %d", id);
    free(deletedIndexes);
    fclose(masterGarbage);
}

int insertMaster(struct Master newMaster)
{
    FILE* indexTable = fopen(MASTER_IND, "a+b");
    FILE* database = fopen(MASTER_FL, "a+b");
    FILE* garbage = fopen(MASTER_GARBAGE, "rb");
    struct IndexTable indexer;
    int garbageCount = 0;

    fscanf(garbage, "%d", &garbageCount);

    if (garbageCount)
    {
        overwriteGarbage(garbageCount, garbage, &newMaster);

        fclose(indexTable);
        fclose(database);

        indexTable = fopen(MASTER_IND, "r+b");
        database = fopen(MASTER_FL, "r+b");

        fseek(indexTable, (newMaster.id - 1) * INDEX_TABLE_SIZE, SEEK_SET);
        fread(&indexer, INDEX_TABLE_SIZE, 1, indexTable);
        fseek(database, indexer.address, SEEK_SET);
    }
    else
    {
        long indexerSize = INDEX_TABLE_SIZE;

        fseek(indexTable, 0, SEEK_END);

        if (ftell(indexTable))
        {
            fseek(indexTable, -indexerSize, SEEK_END);
            fread(&indexer, INDEX_TABLE_SIZE, 1, indexTable);
            newMaster.id = indexer.id + 1;
        }
        else
        {
            newMaster.id = 1;
        }
    }

    newMaster.firstSlaveAddress = -1;
    newMaster.slavesCount = 0;

    fwrite(&newMaster, MASTER_SIZE, 1, database);

    indexer.id = newMaster.id;
    indexer.address = (newMaster.id - 1) * MASTER_SIZE;
    indexer.exists = 1;

    printf("Ready! id = %d\n", newMaster.id);

    fseek(indexTable, (newMaster.id - 1) * INDEX_TABLE_SIZE, SEEK_SET);
    fwrite(&indexer, INDEX_TABLE_SIZE, 1, indexTable);
    fclose(indexTable);
    fclose(database);

    return 1;
}
int updateMaster(struct Master master, char* error)
{
    FILE* indexTable = fopen(MASTER_IND, "r+b");
    FILE* database = fopen(MASTER_FL, "r+b");
    if (!checkFileExistence(indexTable, database, error))
    {
        return 0;
    }
    struct IndexTable indexer;
    if (!checkIndexExistence(indexTable, error, master.id))
    {
        return 0;
    }
    fseek(indexTable, (master.id - 1) * INDEX_TABLE_SIZE, SEEK_SET);
    fread(&indexer, INDEX_TABLE_SIZE, 1, indexTable);
    if (!checkRecordExistence(indexer, error))
    {
        return 0;
    }
    fseek(database, indexer.address, SEEK_SET);
    fwrite(&master, MASTER_SIZE, 1, database);
    fclose(indexTable);
    fclose(database);

    return 1;
}

void changeConnectedAddresses(FILE* database, struct Slave previous, struct Slave slave, struct Master* master)
{
    if (slave.selfAddress != master->firstSlaveAddress)
    {
        if (slave.selfAddress == slave.nextAddress)
        {
            previous.nextAddress = previous.selfAddress;
        }
        else
        {
            previous.nextAddress = slave.nextAddress;
        }

        fseek(database, previous.selfAddress, SEEK_SET);
        fwrite(&previous, SLAVE_SIZE, 1, database);
    }
    else
    {
        if (slave.selfAddress == slave.nextAddress)
        {
            master->firstSlaveAddress = -1;
        }
        else
        {
            master->firstSlaveAddress = slave.nextAddress;
        }
    }
}

void noteDeletedSlave(long address)
{
    FILE* garbage = fopen(SLAVE_GARBAGE, "rb");
    int garbageCount = 0;
    fscanf(garbage, "%d", &garbageCount);

    long* deletedAddresses = malloc(garbageCount * sizeof(long));
    for (int i = 0; i < garbageCount; i++)
    {
        fscanf(garbage, "%ld", deletedAddresses + i);
    }
    fclose(garbage);
    garbage = fopen(SLAVE_GARBAGE, "wb");
    fprintf(garbage, "%ld", garbageCount + 1);
    for (int i = 0; i < garbageCount; i++)
    {
        fprintf(garbage, " %ld", deletedAddresses[i]);
    }
    fprintf(garbage, " %d", address);
    free(deletedAddresses);
    fclose(garbage);
}

int deleteSlave(struct Master master, struct Slave slave, int productId, char* error)
{
    FILE* database = fopen(SLAVE_FL, "r+b");
    struct Slave previous;
    fseek(database, master.firstSlaveAddress, SEEK_SET);
    do
    {
        fread(&previous, SLAVE_SIZE, 1, database);
        fseek(database, previous.nextAddress, SEEK_SET);
    }
    while (previous.nextAddress != slave.selfAddress && slave.selfAddress != master.firstSlaveAddress);
    changeConnectedAddresses(database, previous, slave, &master);
    noteDeletedSlave(slave.selfAddress);
    slave.exists = 0;
    fseek(database, slave.selfAddress, SEEK_SET);
    fwrite(&slave, SLAVE_SIZE, 1, database);
    fclose(database);
    master.slavesCount--;
    updateMaster(master, error);
}

int deleteMaster(int id, char* error)
{
    FILE* indexTable = fopen(MASTER_IND, "r+b");
    if (indexTable == NULL)
    {
        strcpy(error, "database is clean");
        return 0;
    }

    if (!checkIndexExistence(indexTable, error, id))
    {
        return 0;
    }

    struct Master master;
    getMaster(&master, id, error);

    struct IndexTable indexer;

    fseek(indexTable, (id - 1) * INDEX_TABLE_SIZE, SEEK_SET);
    fread(&indexer, INDEX_TABLE_SIZE, 1, indexTable);

    indexer.exists = 0;
    fseek(indexTable, (id - 1) * INDEX_TABLE_SIZE, SEEK_SET);

    fwrite(&indexer, INDEX_TABLE_SIZE, 1, indexTable);
    fclose(indexTable);

    noteDeletedMaster(id);


    if (master.slavesCount)
    {
        FILE* slavesDb = fopen(SLAVE_FL, "r+b");
        struct Slave slave;

        fseek(slavesDb, master.firstSlaveAddress, SEEK_SET);

        for (int i = 0; i < master.slavesCount; i++)
        {
            fread(&slave, SLAVE_SIZE, 1, slavesDb);
            fclose(slavesDb);
            deleteSlave(master, slave, slave.slaveId, error);

            slavesDb = fopen(SLAVE_FL, "r+b");
            fseek(slavesDb, slave.nextAddress, SEEK_SET);
        }

        fclose(slavesDb);
    }
    return 1;
}
void printSlave(struct Slave slave, struct Master master)
{
    printf("Name: %s\n", slave.name);
    printf("Genre: %s\n", master.name);
}

void readSlave(struct Slave* slave)
{
    char name[16];
    name[0] = '\0';

    printf("Give film\'s name: ");
    scanf("%s", name);

    strcpy(slave->name, name);
}

void reopenDatabase(FILE* database)
{
    fclose(database);
    database = fopen(SLAVE_FL, "r+b");
}

void connectAddresses(FILE* database, struct Master master, struct Slave slave)
{
    reopenDatabase(database);
    struct Slave previousSlave;
    fseek(database, master.firstSlaveAddress, SEEK_SET);
    for (int i = 0; i < master.slavesCount; i++)
    {
        fread(&previousSlave, SLAVE_SIZE, 1, database);
        fseek(database, previousSlave.nextAddress, SEEK_SET);
    }
    previousSlave.nextAddress = slave.selfAddress;
    fwrite(&previousSlave, SLAVE_SIZE, 1, database);
}

void overwriteSlaveGarbage(int garbageCount, FILE* garbageZone, struct Slave* record)
{
    long* deletedIndexes = malloc(garbageCount * sizeof(long));

    for (int i = 0; i < garbageCount; i++)
    {
        fscanf(garbageZone, "%d", deletedIndexes + i);
    }
    record->selfAddress = deletedIndexes[0];
    record->nextAddress = deletedIndexes[0];
    fclose(garbageZone);
    fopen(SLAVE_GARBAGE, "wb");
    fprintf(garbageZone, "%d", garbageCount - 1);
    for (int i = 1; i < garbageCount; i++)
    {
        fprintf(garbageZone, " %d", deletedIndexes[i]);
    }
    free(deletedIndexes);
    fclose(garbageZone);
}

int insertSlave(struct Master master, struct Slave slave, char* error)
{
    slave.exists = 1;
    FILE* database = fopen(SLAVE_FL, "a+b");
    FILE* garbageZone = fopen(SLAVE_GARBAGE, "rb");
    int garbageCount = 0;
    fscanf(garbageZone, "%d", &garbageCount);
    if (garbageCount)
    {
        overwriteSlaveGarbage(garbageCount, garbageZone, &slave);
        reopenDatabase(database);
        fseek(database, slave.selfAddress, SEEK_SET);
    }
    else
    {
        fseek(database, 0, SEEK_END);
        int dbSize = ftell(database);
        slave.selfAddress = dbSize;
        slave.nextAddress = dbSize;
    }
    fwrite(&slave, SLAVE_SIZE, 1, database);
    if (!master.slavesCount)
    {
        master.firstSlaveAddress = slave.selfAddress;
    }
    else
    {
        connectAddresses(database, master, slave);
    }
    fclose(database);
    master.slavesCount++;
    updateMaster(master, error);
    return 1;
}

int getSlave(struct Master master, struct Slave* slave, int productId, char* error)
{
    if (!master.slavesCount)
    {
        strcpy(error, "Master has no slaves yet");
        return 0;
    }
    FILE* database = fopen(SLAVE_FL, "rb");
    fseek(database, master.firstSlaveAddress, SEEK_SET);
    fread(slave, SLAVE_SIZE, 1, database);
    for (int i = 0; i < master.slavesCount; i++)
    {
        if (slave->slaveId == productId)
        {
            fclose(database);
            return 1;
        }

        fseek(database, slave->nextAddress, SEEK_SET);
        fread(slave, SLAVE_SIZE, 1, database);
    }
    strcpy(error, "There is this file");
    fclose(database);
    return 1;
}

int updateSlave(struct Slave slave, int productId)
{
    FILE* database = fopen(SLAVE_FL, "r+b");
    fseek(database, slave.selfAddress, SEEK_SET);
    fwrite(&slave, SLAVE_SIZE, 1, database);
    fclose(database);
    return 1;
}

