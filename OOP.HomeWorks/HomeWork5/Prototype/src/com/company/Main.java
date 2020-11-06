package com.company;

public class Main
{
    public static void main(String[] args)
    {
        IFigure figure = new Rectangle(10, 20);
        IFigure clonedFigure = figure.clone();
        figure.getInfo();
        clonedFigure.getInfo();
        figure = new Circle(15);
        clonedFigure = figure.clone();
        figure.getInfo();
        clonedFigure.getInfo();
        figure = new Triangle(15, 10, 6);
        clonedFigure = figure.clone();
        figure.getInfo();
        clonedFigure.getInfo();
    }
}

