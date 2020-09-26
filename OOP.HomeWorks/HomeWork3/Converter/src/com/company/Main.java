package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String command;
        int number;
        while(true)
        {
            System.out.println("Please, give a number you want to convert:");
            number = Integer.parseInt(scanner.nextLine());
            System.out.println("Choose operation:\n \"euro -> uah\", \"uah -> euro\", \"usd -> uah\", \"uah -> usd\"");
            command = scanner.nextLine();
            if(number == 0)
            {
                System.out.println("resalt = 0");
                continue;
            }
            convert(command, number);
        }
    }
    private static void convert(String command, int number)
    {
        Converter converter = new Converter(33.46,27.91);
        switch (command)
        {
            case "euro -> uah":
                System.out.println("Uah: " + converter.EurUah(number));
                break;
            case "uah -> euro":
                System.out.println("Euro: " + converter.UahEur(number));
                break;
            case "usd -> uah":
                System.out.println("Uah: " + converter.UsdUah(number));
                break;
            case "uah -> usd":
                System.out.println("Usd: " + converter.UahUsd(number));
                break;
            default:
                System.out.println("Check your command");
        }
    }
}
