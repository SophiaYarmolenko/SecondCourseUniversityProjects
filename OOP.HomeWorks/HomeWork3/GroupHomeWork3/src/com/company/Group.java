package com.company;

import java.util.LinkedList;

public class Group
{
    String groupName;
    LinkedList<Student> studentList;

    Group(String groupName)
    {
        this.groupName = groupName;
        studentList = new LinkedList<>();
    }

    public void AddStudent(Student st)
    {
        studentList.add(st);
    }

    public String GetInfo()
    {
        int number = 0;
        StringBuilder info = new StringBuilder(groupName);
        info.append(":\n");

        for(Student student : studentList)
        {
            info.append(number + " " + student.getName() + "\n");
            number++;
        }
        return info.toString();
    }

    public String GetFullInfo()
    {
        int number = 0;
        StringBuilder info = new StringBuilder(groupName);
        info.append(":\n");

        for(Student student : studentList)
        {
            info.append(number + " "+student.getName() +" "+ student.getState() + "\n");
            number++;
        }
        return info.toString();
    }
}


