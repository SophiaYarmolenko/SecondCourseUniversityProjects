package com.company;

public class Main
{
    public static void main(String[] args)
    {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
        PizzaBuilder margaritaPizzaBuilder = new MargaritaPizzaBuilder();

        waiter.setPizzaBuilder(margaritaPizzaBuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        pizza.info();
    }
}
