package com.company;

//Який принцип S.O.L.I.D. порушено? Виправте!

/*Зверніть увагу на клас EmailSender. Крім того, що за допомогою методу Send, він відправляє повідомлення,
він ще і вирішує як буде вестися лог. В даному прикладі лог ведеться через консоль.
Якщо трапиться так, що нам доведеться міняти спосіб логування, то ми будемо змушені внести правки в клас EmailSender.
Хоча, здавалося б, ці правки не стосуються відправки повідомлень. Очевидно, EmailSender виконує кілька обов'язків і,
щоб клас ні прив'язаний тільки до одного способу вести лог, потрібно винести вибір балки з цього класу.*/
class Email
{
    public String theme;
    public String from;
    public String to;

    public Email(String from, String to, String theme) {
        this.theme = theme;
        this.from = from;
        this.to = to;
    }
}

interface ILogger
{
    void Log( String logMessage );
}

class ConsoleLogger implements ILogger
{
    public void Log( String logMessage )
    {
        System.out.println(logMessage);
    }
}

class EmailSender
{
    private ILogger logger;

    public EmailSender(ILogger logger)
    {
        this.logger = logger;
    }

    public void send(Email email)
    {
        // ... sending...
        System.out.println("Email from '" + email.from + "' to '" + email.to + "' was send");
    }
}

public class SOLID2
{
    public static void Main(String[] args)
    {
        Email e1 = new Email("Me", "Vasya", "Who are you?");
        Email e2 = new Email("Vasya", "Me", "vacuum cleaners!");
        Email e3 = new Email("Kolya", "Vasya", "No! Thanks!" );
        Email e4 = new Email("Vasya", "Me", "washing machines!");
        Email e5 = new Email("Me", "Vasya", "Yes");
        Email e6 = new Email("Vasya", "Petya", "+2");

        EmailSender es = new EmailSender(new ConsoleLogger());
        es.send(e1);
        es.send(e2);
        es.send(e3);
        es.send(e4);
        es.send(e5);
        es.send(e6);
    }
}