//
// Created by Sofiia on 29/01/2021.
//
#pragma once

struct Master
{
    int id;
    char name[16];
    long firstSlaveAddress;
    int slavesCount;
};

struct Slave
{
    int masterId;
    int slaveId;
    char name[16];
    int exists;
    long selfAddress;
    long nextAddress;
};

struct IndexTable
{
    int id;
    int address;
    int exists;
};