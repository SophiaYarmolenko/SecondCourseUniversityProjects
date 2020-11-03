package com.company;

import com.company.bmw.BmwFactory;
import com.company.toyota.ToyotaFactory;

public class Main {

    public static void main(String[] args)
    {
        ICarFactory bmwFactory = new BmwFactory();
        bmwFactory.createEngine();
        bmwFactory.createWheels();
        ICarFactory toyotaFactory = new ToyotaFactory();
        toyotaFactory.createEngine();
        toyotaFactory.createWheels();
    }
}
