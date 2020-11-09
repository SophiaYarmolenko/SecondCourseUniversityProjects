package com.company;

public class ConcreteColleague3 extends Colleague
{
    public ConcreteColleague3(Mediator mediator)
    {
        super(mediator);
    }

    public void send(String message)
    {
        mediator.send(message, this);
    }
    public void notify(String message)
    {
        System.out.println("Colleague3 gets message: " + message);
    }
}
