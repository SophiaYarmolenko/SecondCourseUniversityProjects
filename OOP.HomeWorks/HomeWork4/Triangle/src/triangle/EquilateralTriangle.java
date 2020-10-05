package triangle;

public class EquilateralTriangle extends Triangle
{
    public EquilateralTriangle( double side )
    {
        super( side, side, side );
    }

    @Override
    public void CountAngles()
    {
        alphaAngle = 60;
        betaAngle = 60;
        gammaAngle = 60;
    }

    @Override
    public void CountSquare()
    {
        square = Math.pow( aSide, 2 ) * Math.sqrt( 3 ) / 4;
    }

    @Override
    public void CountPerimeter()
    {
        perimeter = aSide * 3;
    }
}
