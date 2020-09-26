package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    static LinkedList<Group> groups = new LinkedList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String command;
        while(true)
        {
            System.out.println("If you want to add new group - press \"new\" without quotes\nIf you want to see all information about groups - press \"information\"");
            command = scanner.next();
            if(command.equals("information"))
                showGroups();
            else if (command.equals("new"))
                AddGroup();
            else
                System.out.print("Sorry, we don`t know this command. Try again: ");
        }
    }

    private static void AddGroup()
    {
        System.out.println("Give a group name");
        Scanner scanner = new Scanner(System.in);
        Group group = new Group(scanner.next());
        addStudent(group);
        groups.add(group);
    }

    private static void addStudent(Group group)
    {
        String studentStatus;
        String studentName;
        Scanner scanner = new Scanner(System.in);

        System.out.println("If you want to stop adding student to this group press \"stop\"");
        boolean stop = false;

        while (!stop)
        {
            System.out.print("Student name = ");
            studentName = scanner.nextLine();
            if(studentName.equals("stop"))
                break;
            System.out.print("Student status (write \"bad\" or \"good\") = ");
            studentStatus = scanner.nextLine();
            switch(studentStatus)
            {
                case "bad":
                    group.AddStudent(new BadStudent(studentName));
                    break;
                case "good":
                    group.AddStudent(new GoodStudent(studentName));
                    break;
                case "stop":
                    stop = true;
                    break;
                default:
                    System.out.println("Sorry, you made mistake ");
            }
        }
    }

    private static void showGroups()
    {
        for(Group group: groups)
        {
            for(Student student: group.studentList)
                student.Study();
            System.out.println(group.GetFullInfo());
        }
    }
}
