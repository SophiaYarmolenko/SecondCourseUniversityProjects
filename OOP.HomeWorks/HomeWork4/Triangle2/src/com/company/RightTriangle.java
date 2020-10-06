package com.company;

public class RightTriangle extends Triangle
{
    public RightTriangle( double side1, double side2, double angleBetweenSide1AndSide2 )
    {
        super(side1, side2, angleBetweenSide1AndSide2);
    }

    @Override
    public double countPerimeter()
    {
        return side1 + side2 + side3;
    }

    @Override
    public double countSquare()
    {
        return (1.0/2.0) * side1 * side2;
    }
}
