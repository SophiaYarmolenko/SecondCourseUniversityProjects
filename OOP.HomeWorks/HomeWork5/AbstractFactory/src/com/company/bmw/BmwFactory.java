package com.company.bmw;

import com.company.ICarFactory;
import com.company.IEngine;
import com.company.IWheels;

public class BmwFactory implements ICarFactory
{

    @Override
    public IEngine createEngine()
    {
        return new BmwEngine();
    }

    @Override
    public IWheels createWheels()
    {
        return new BmwWheels();
    }
}
