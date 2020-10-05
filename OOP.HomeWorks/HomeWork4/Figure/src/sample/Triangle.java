package sample;

public class Triangle extends Figure
{
    protected double aSide ;
    protected double bSide ;
    protected double cSide ;
    private final double PI = Math.PI;

    public Triangle( double aSide, double bSide, double cSide )
    {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
        countAll();
    }
    private void countAll()
    {
        countSquare();
        countPerimeter();
    }
    public void setASide( double aSide )
    {
        this.aSide = aSide;
        countAll();
    }

    public void setBSide( double bSide )
    {
        this.bSide = bSide;
        countAll();
    }

    public void setCSide( double cSide )
    {
        this.cSide = cSide;
        countAll();
    }

    @Override
    public double countSquare()
    {
        square = Math.sqrt( ( perimeter/2 ) * ( perimeter/2 - aSide ) * ( perimeter/2 - bSide ) * ( perimeter/2 - cSide ));
        return square;
    }

    @Override
    public double countPerimeter()
    {
        perimeter = aSide + bSide + cSide;
        return perimeter;
    }
}
