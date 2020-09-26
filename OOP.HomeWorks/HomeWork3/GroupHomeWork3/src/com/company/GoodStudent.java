package com.company;

public class GoodStudent extends Student
{
    GoodStudent(String name)
    {
        super(name);
    }

    @Override
    public void Study()
    {
        super.state.append( "good ");
        for(int i = 0; i < 2; i++)
        {
            Read();
            Write();
        }
        Relax();
    }
}
