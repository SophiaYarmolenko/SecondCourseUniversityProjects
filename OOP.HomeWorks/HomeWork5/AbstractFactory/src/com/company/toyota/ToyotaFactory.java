package com.company.toyota;

import com.company.ICarFactory;
import com.company.IEngine;
import com.company.IWheels;

public class ToyotaFactory implements ICarFactory
{

    @Override
    public IEngine createEngine()
    {
        return new ToyotaEngine();
    }

    @Override
    public IWheels createWheels()
    {
        return new ToyotaWheels();
    }
}