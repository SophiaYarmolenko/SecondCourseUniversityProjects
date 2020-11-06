package com.company;

class Rectangle implements IFigure
{
    int width;
    int height;
    public Rectangle(int w, int h)
    {
        width = w;
        height = h;
    }
    public IFigure clone()
    {
        return new Rectangle(this.width, this.height);
    }
    public void getInfo()
    {
        System.out.println("Прямокутник довжиною " + height + ", шириною " + width);
    }
}