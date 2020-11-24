package com.company;
//Порушено принцип Лісков
public class SOLID3
{
    public static void main(String[] args)
    {
        Square square = new ConcreteSquare();
        square.setSide(10);
        Area area = new SquareArea((ConcreteSquare) square);
        System.out.println(area.calculateArea());
    }
}
interface Area
{
    int calculateArea();
}

class RectangleArea implements Area
{
    private Rectangle rectangle;

    public RectangleArea(ConcreteRectangle concreteRectangle)
    {
        this.rectangle = concreteRectangle;
    }

    @Override
    public int calculateArea()
    {
        return rectangle.getHeight() * rectangle.getWidth();
    }
}

class SquareArea implements Area
{
    private Square square;
    public SquareArea(ConcreteSquare concreteSquare)
    {
        this.square = concreteSquare;
    }
    @Override
    public int calculateArea()
    {
        return square.getSide() * square.getSide();
    }
}

interface Rectangle
{
    int getWidth();
    void setWidth(int width);
    int getHeight();
    void setHeight(int height);

}
class ConcreteRectangle implements Rectangle
{
    private int width;
    private int height;

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setHeight(int height) {

    }
}

interface Square
{
    int getSide();
    void setSide(int side);
}

class ConcreteSquare implements Square
{
    private int side;
    public int getSide()
    {
        return side;
    }
    public void setSide(int side)
    {
        this.side = side;
    }
}