package sample;

public class Quadrate extends Figure
{
    private double side;

    public Quadrate(double side)
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
        square = side * side;
        return square;
    }

    @Override
    public double countPerimeter()
    {
        perimeter = 4*side;
        return perimeter;
    }
}
