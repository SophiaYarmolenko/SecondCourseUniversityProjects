package com.company;

/*Даний інтерфейс поганий тим, що він включає занадто багато методів.
 А що, якщо наш клас товарів не може мати знижок або промокодом, або для нього немає сенсу встановлювати матеріал з
 якого зроблений (наприклад, для книг). Таким чином, щоб не реалізовувати в кожному класі невикористовувані в ньому методи, краще
розбити інтерфейс на кілька дрібних і кожним конкретним класом реалізовувати потрібні інтерфейси.
Перепишіть, розбивши інтерфейс на декілька інтерфейсів, керуючись принципом розділення інтерфейсу.
Опишіть класи книжки (розмір та колір не потрібні, але потрібна ціна та знижки) та верхній одяг (колір, розмір, ціна знижка),
які реалізують притаманні їм інтерфейси.*/
interface IItemPrice
{
    void setPrice(double price);
}

interface IItemColour
{
    void setColor(byte color);
}

interface IItemSize
{
    void setSize(byte size);
}

interface IItemDiscount
{
    void applyDiscount(String discount);
}

interface IItemPromocode
{
    void applyPromocode(String promocode);
}

class Book implements IItemPrice, IItemDiscount
{
    private double price;
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void applyDiscount(String discount)
    {
        System.out.println(discount);
    }
}

class Coat implements IItemPrice, IItemDiscount,IItemColour,IItemSize
{
    private double price;
    private byte size;
    private byte color;
    public void setPrice(double price)
    {
        this.price = price*2;
    }
    public void applyDiscount(String discount)
    {
        System.out.println(discount);
    }
    public void setSize(byte size)
    {
        this.size = size;
    }
    public void setColor(byte color)
    {
        this.color = color;
    }

}
