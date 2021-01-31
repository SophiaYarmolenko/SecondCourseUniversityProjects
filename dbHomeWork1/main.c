//
// Created by Sofiia on 29/01/2021.
//
#include <stdio.h>
#include "Structures.h"
#include "DataBase.h"

int main()
{
    struct Master master;
    struct Slave slave;
    while (1)
    {
        int choice;
        int id;
        char error[51];

        printf("Hi! Please, choose the command: \n0 - help\n1 - add genre (insert_m)\n2 - get genre(get_m)\n3 - update genre (update_m) \n4 - delete genre (del_m)\n5 - add film (insert_s) \n6 - get film(get_s)\n7 - update film(update_s)\n8 - delete film(del_s)\n9 - exit\n");
        scanf("%d", &choice);

        switch (choice)
        {
            case 0:
                info();
                break;
            case 1:
                readMaster(&master);
                insertMaster(master);
                break;

            case 2:
                printf("Please, give id: ");
                scanf("%d", &id);
                getMaster(&master, id, error) ? printMaster(master) : printf("Error: %s\n", error);
                break;

            case 3:
                printf("Please, give id: ");
                scanf("%d", &id);

                master.id = id;
                readMaster(&master);
                updateMaster(master, error) ? printf("Ready!\n") : printf("Error: %s\n", error);
                break;

            case 4:
                printf("Enter genre\'s id: ");
                scanf("%d", &id);
                deleteMaster(id, error) ? printf("Ready!\n") : printf("Error: %s\n", error);
                break;

            case 5:
                printf("Enter genre\'s id: ");
                scanf("%d", &id);

                if (getMaster(&master, id, error))
                {
                    slave.masterId = id;
                    printf("Enter film\'s id: ");
                    scanf("%d", &id);
                    slave.slaveId = id;
                    readSlave(&slave);
                    insertSlave(master, slave, error);
                }
                else
                {
                    printf("Error: %s\n", error);
                }
                printf("\nReady!\n");
                break;

            case 6:
                printf("Enter genre\'s id: ");
                scanf("%d", &id);

                if (getMaster(&master, id, error))
                {
                    printf("Enter film\'s id: ");
                    scanf("%d", &id);
                    getSlave(master, &slave, id, error) ? printSlave(slave, master) : printf("Error: %s\n", error);
                }
                else
                {
                    printf("Error: %s\n", error);
                }
                break;

            case 7:
                printf("Enter genre\'s id: ");
                scanf("%d", &id);

                if (getMaster(&master, id, error))
                {
                    printf("Enter film id: ");
                    scanf("%d", &id);

                    if (getSlave(master, &slave, id, error))
                    {
                        readSlave(&slave);
                        updateSlave(slave, id);
                        printf("Ready!\n");
                    }
                    else
                    {
                        printf("Error: %s\n", error);
                    }
                }
                else
                {
                    printf("Error: %s\n", error);
                }
                break;

            case 8:
                printf("Enter genre\'s id: ");
                scanf("%d", &id);

                if (getMaster(&master, id, error))
                {
                    printf("Enter film id: ");
                    scanf("%d", &id);

                    if (getSlave(master, &slave, id, error))
                    {
                        deleteSlave(master, slave, id, error);
                        printf("Ready!\n");
                    }
                    else
                    {
                        printf("Error: %s\n", error);
                    }
                }
                else
                {
                    printf("Error: %s\n", error);
                }
                break;

            case 9:
                return 0;
            default:
                printf("Sorry, we don't know this command. Please, try again: \n");
        }
    }

    return 0;
}