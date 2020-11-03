package com.company;

class Pizza
{
    String dough;
    String sauce;
    String topping;
    public Pizza()
    {}
    public void setDough(String d)
    {
        this.dough = d;
    }
    public void setSauce(String s)
    {
        this.sauce = s;
    }
    public void setTopping(String t)
    {
        topping = t;
    }
    public void info()
    {
       System.out.println("dough = " + dough + "\n" + "sauce = " + sauce +"\n" + "topping = " + topping);
    }
}