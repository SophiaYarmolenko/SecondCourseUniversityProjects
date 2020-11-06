package com.company;

public class Triangle implements IFigure
{
    int aSide;
    int bSide;
    int cSide;
    public Triangle(int a, int b, int c)
    {
        this.aSide = a;
        this.bSide = b;
        this.cSide = c;
    }
    public IFigure clone()
    {
        return new Triangle(this.aSide, this.bSide, this.cSide);
    }
    public void getInfo()
    {
        System.out.println("Трикутник з сторонами " + aSide + ", " + bSide + ", "+ cSide);
    }
}
