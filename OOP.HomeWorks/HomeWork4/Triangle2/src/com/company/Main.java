package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Triangle triangle = new IsoscelesTriangle(1, 1, 60);
        while (true)
        {
            String kind = "1";
            System.out.println("Choose the kind of triangle (1 - isosceles; 2 - right):");
            Scanner scanner = new Scanner(System.in);
            kind = scanner.nextLine();
            if( kind.equals("1") )
            {
                double side;
                double angle;
                System.out.print("side = ");
                side = Double.parseDouble( scanner.nextLine() );
                System.out.print("angle = ");
                angle = Double.parseDouble( scanner.nextLine() );
                try
                {
                    triangle = new IsoscelesTriangle(side, side, angle);
                }
                catch ( IllegalArgumentException i)
                {
                    System.out.println("Illegal arguments, sorry");
                    continue;
                }
            }
            else if ( kind.equals("2") )
            {
                double catet1;
                double catet2;
                System.out.print("catet1 = ");
                catet1 = Double.parseDouble( scanner.nextLine() );
                System.out.print("catet2 = ");
                catet2 = Double.parseDouble( scanner.nextLine() );
                try
                {
                    triangle = new IsoscelesTriangle(catet1, catet2, 90);
                }
                catch ( IllegalArgumentException i)
                {
                    System.out.println("Illegal arguments, sorry");
                    continue;
                }
            }
            else
                {
                    System.out.println("Invalid argument");
                }
            if( kind.equals("2") || kind.equals("1") )
            {
                System.out.println( "P = " + triangle.countPerimeter() );
                System.out.println( "S = " + triangle.countSquare() );
            }
        }
    }
}
