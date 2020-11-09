package com.company;

public class RealProject implements Project
{
    private String url;

    public RealProject(String url)
    {
        this.url = url;
        load();
    }

    public void load()
    {
        System.out.println("Project "+url+"is loading"+"\n");
    }

    @Override
    public void run()
    {
        System.out.println("Project "+url+"is running"+"\n");
    }
}
