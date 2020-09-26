package com.company;

public class Converter
{
    private double eur;
    private double usd;

    public Converter(double eur, double usd)
    {
        check(eur);
        check(usd);
        this.eur = eur;
        this.usd = usd;
    }
    private double convert(double first, double second)
    {
        return first*second;
    }

    public double UsdUah(double usd)
    {
        check(usd);
        return convert(usd,this.usd);
    }

    public double EurUah(double eur)
    {
        check(eur);
        return convert(eur,this.eur);
    }

    public double UahEur(double uah)
    {
        check(uah);
        return convert(uah, 1/this.eur);
    }

    public double UahUsd(double uah)
    {
        check(uah);
        return convert(uah, 1/this.usd);
    }


    private void check(double money)
    {
        if(money <= 0)
            throw new IllegalArgumentException();
    }
}
