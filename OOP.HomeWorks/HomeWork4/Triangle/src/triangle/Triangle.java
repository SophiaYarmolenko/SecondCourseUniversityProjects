package triangle;

public class Triangle
{
    protected double aSide = 0;
    protected double bSide = 0;
    protected double cSide = 0;
    protected double alphaAngle = 0;
    protected double betaAngle = 0;
    protected double gammaAngle = 0;
    public double perimeter = 0;
    public double square = 0;
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
        CountAngles();
        CountPerimeter();
        CountSquare();
        CountSquare();
        CountPerimeter();
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

    public void setAlphaAngle( double alphaAngle )
    {
        this.alphaAngle = alphaAngle;
        countAll();
    }

    public void setGammaAngle( double gammaAngle )
    {
        this.gammaAngle = gammaAngle;
        countAll();
    }

    public double getAlphaAngle()
    {
        return alphaAngle;
    }

    public double getBetaAngle()
    {
        return betaAngle;
    }

    public double getGammaAngle()
    {
        return gammaAngle;
    }

    public void setBetaAngle( double betaAngle )
    {
        this.betaAngle = betaAngle;
        countAll();
    }

    private int countAngle( double oppositeSide, double adjacentSide1, double adjacentSide2 )
    {
        return (int) (Math.acos((Math.pow(oppositeSide, 2) - Math.pow(adjacentSide1, 2) - Math.pow(adjacentSide2, 2))
                        /(2*adjacentSide1*adjacentSide2))*90/PI);
    }

    public void CountAngles()
    {
        alphaAngle = countAngle( aSide, bSide, cSide );
        betaAngle = countAngle( bSide, aSide, cSide );
        gammaAngle = 180 - alphaAngle - betaAngle;
    }

    public void CountPerimeter()
    {
        perimeter = aSide + bSide + cSide;
    }

    public void CountSquare()
    {
        square = Math.sqrt( ( perimeter/2 ) * ( perimeter/2 - aSide ) * ( perimeter/2 - bSide ) * ( perimeter/2 - cSide ));
    }
}
