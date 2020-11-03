package com.company.ferary;

import com.company.ICarFactory;
import com.company.IEngine;
import com.company.IWheels;

public class FeraryFactory implements ICarFactory
{

    @Override
    public IEngine createEngine()
    {
        return new FeraryEngine();
    }

    @Override
    public IWheels createWheels()
    {
        return new FeraryWheels();
    }
}
