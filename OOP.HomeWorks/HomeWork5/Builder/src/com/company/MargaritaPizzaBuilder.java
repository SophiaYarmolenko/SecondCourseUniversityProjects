package com.company;

public class MargaritaPizzaBuilder extends PizzaBuilder
{
    @Override
    public void buildDough()
    {
        pizza.setDough("margarita dough");
    }

    @Override
    public void buildSauce()
    {
        pizza.setSauce("margarita sauce");
    }

    @Override
    public void buildTopping()
    {
        pizza.setTopping("margarita topping");
    }
}
