package com.company;

public abstract class Student
{
    private String name;
    protected StringBuilder state;

    Student(String name)
    {
        this.name = name;
        this.state = new StringBuilder("");
    }

    public String getState()
    {
        return state.toString();
    }

    public String getName()
    {
        return name;
    }

    public void Relax()
    {
        this.state.append("Relax ");
    }

    public void Read()
    {
        this.state.append("Read ");
    }

    public void Write()
    {
        this.state.append("Write ");
    }

    public abstract void Study();
}
