package com.company;

public class BadStudent extends Student
{
    BadStudent(String name)
    {
        super(name);
        super.state.append( "bad ");
    }

    @Override
    public void Study()
    {
        for(int i = 0; i < 4; i++)
        {
            Relax();
        }
        Read();
    }
}
