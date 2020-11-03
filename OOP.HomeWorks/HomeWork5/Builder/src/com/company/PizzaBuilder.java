package com.company;

abstract class PizzaBuilder
{
    protected Pizza pizza;
    public PizzaBuilder() {}

    public Pizza getPizza()
    {
        return pizza;
    }
    public void createNewPizza()
    {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}