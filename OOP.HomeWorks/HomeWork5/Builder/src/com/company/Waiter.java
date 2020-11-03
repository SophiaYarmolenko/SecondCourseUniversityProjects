package com.company;

/** "Director" */
class Waiter
{
    private PizzaBuilder pizzaBuilder;
    public void setPizzaBuilder(PizzaBuilder pb)
    {
        pizzaBuilder = pb;
    }
    public Pizza getPizza()
    {
        return pizzaBuilder.getPizza();
    }
    public void constructPizza()
    {
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}