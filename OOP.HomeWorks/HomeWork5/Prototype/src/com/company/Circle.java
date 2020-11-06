package com.company;

public class Circle implements IFigure
{
    int radius;
    public Circle(int r)
    {
        radius = r;
    }
    public IFigure clone()
    {
        return new Circle(this.radius);
    }
    public void getInfo()
    {
        System.out.println("Круг радіусом " + radius);
    }
}
