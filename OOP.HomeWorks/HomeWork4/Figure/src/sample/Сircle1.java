package sample;

public class Сircle1 extends Figure
{
    private double R;
    public Сircle1( double r )
    {
        this.R = r;
    }
    public void setR( double r )
    {
        R = r;
        countPerimeter();
        countSquare();
    }


    @Override
    public double countSquare()
    {
        square = Math.PI*Math.pow( R, 2 );
        return square;
    }

    @Override
    public double countPerimeter()
    {
        perimeter = 2*Math.PI*R;
        return perimeter;
    }
}
