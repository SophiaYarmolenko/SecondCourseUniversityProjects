package com.company;

public class Main
{
    public static void main(String[] args)
    {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);
        ConcreteColleague3 c3 = new ConcreteColleague3(m);

        m.setColleague1(c1);
        m.setColleague2(c2);
        m.setColleague3(c3);
        m.send("How are you?", c1);
        m.send("Fine, thanks", c2);
        m.send("Hello!", c3);
    }
}
