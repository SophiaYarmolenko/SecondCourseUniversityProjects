package sample;

public class Rhombus extends Figure
{
    private double side;

    public Rhombus(double side)
    {
        this.side = side;
        countPerimeter();
        countSquare();
    }

    public void setSide(double side)
    {
        this.side = side;
        countPerimeter();
        countSquare();
    }

    @Override
    public double countSquare()
    {
        square = 0;
        return square;
    }

    @Override
    public double countPerimeter()
    {
        perimeter = 4*side;
        return perimeter;
    }
}
