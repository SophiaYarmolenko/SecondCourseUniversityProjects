package com.company;

public class ConcreteMediator extends Mediator
{
        private ConcreteColleague1 colleague1;
        private ConcreteColleague2 colleague2;
        private ConcreteColleague3 colleague3;

        public void setColleague1(ConcreteColleague1 colleague1)
        {
                this.colleague1 = colleague1;
        }

        public void setColleague2(ConcreteColleague2 colleague2)
        {
                this.colleague2 = colleague2;
        }

        public void setColleague3(ConcreteColleague3 colleague3)
        {
                this.colleague3 = colleague3;
        }
        @Override
        public void send(String message, Colleague colleague)
        {
                if (colleague == colleague1)
                {
                        colleague2.notify(message);
                        colleague3.notify(message);
                }
                else if(colleague == colleague2)
                {
                        colleague1.notify(message);
                        colleague3.notify(message);
                }
                else
                {
                        colleague1.notify(message);
                        colleague2.notify(message);
                }
        }
}
