package com.company;

public class ComputerFacade
{
    Power power = new Power();
    Mouse mouse = new Mouse();

    public void showWorking()
    {
        power.showWorking();
        mouse.showWorking();
    }
}
