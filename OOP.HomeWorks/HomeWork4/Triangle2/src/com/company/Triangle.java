package com.company;

public abstract class Triangle
{
    protected double side1;
    protected double side2;
    protected double side3;
    protected double angleBetweenSide1AndSide2;
    protected double angleBetweenSide1AndSide3;
    protected double angleBetweenSide2AndSide3;

    public Triangle( double side1, double side2, double angleBetweenSide1AndSide2 )
    {
        checkAngle(angleBetweenSide1AndSide2);
        checkSide(side1);
        checkSide(side2);
        this.side1 = side1;
        this.side2 = side2;
        this.angleBetweenSide1AndSide2 = angleBetweenSide1AndSide2;
        this.side3 = Math.sqrt( side1*side1 + side2*side2 - 2*side1*side2*Math.cos( angleBetweenSide1AndSide2 * Math.PI / 180 ) );
    }
    public abstract double countPerimeter();
    public abstract double countSquare();

    private void checkSide( double side )
    {
        if( side <= 0 )
        {
            throw new IllegalArgumentException( "side <= 0" );
        }
    }

    private void checkAngle( double angle )
    {
        if( angle <= 0 || angle >= 180 )
        {
            throw new IllegalArgumentException( "angle is illegal" );
        }
    }
}
