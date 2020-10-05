package sample;

public class Rectangle extends Figure
{
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2)
    {
        this.side1 = side1;
        this.side2 = side2;
        countPerimeter();
        countSquare();
    }

    public void setSide1(double side1)
    {
        this.side1 = side1;
        countPerimeter();
        countSquare();
    }

    public void setSide2(double side2)
    {
        this.side2 = side2;
        countPerimeter();
        countSquare();
    }

    @Override
    public double countSquare()
    {
        square = side1 * side2;
        return square;
    }

    @Override
    public double countPerimeter()
    {
        perimeter = side1*2 + side2*2;
        return perimeter;
    }
}
