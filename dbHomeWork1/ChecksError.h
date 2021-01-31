//
// Created by Sofiia on 29/01/2021.
//
#pragma once

#include <stdio.h>
#include <stdlib.h>

int checkFileExistence(FILE* indexTable, FILE* database, char* error)
{
    if (indexTable == NULL || database == NULL)
    {
        strcpy(error, "database files are not created yet");
        return 0;
    }
    return 1;
}

int checkIndexExistence(FILE* indexTable, char* error, int id)
{
    fseek(indexTable, 0, SEEK_END);
    long indexTableSize = ftell(indexTable);
    if (indexTableSize == 0 || id * sizeof(struct IndexTable) > indexTableSize)
    {
        strcpy(error, "no such id in table");
        return 0;
    }
    return 1;
}

int checkRecordExistence(struct IndexTable indexer, char* error)
{
    if (!indexer.exists)
    {
        strcpy(error, "the record has been removed");
        return 0;
    }

    return 1;
}

