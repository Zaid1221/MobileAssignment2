package com.example.zaidjavaid.currencyconverter;

/**
 * Created by Zaid Javaid on 9/19/2017.
 */

public class Converter {
    private double USD;

    public void CurrencyConverter(double newUSD){
        setUSD(newUSD);
    }

    public double getUSD(){
        return USD;
    }

    public void setUSD(double newUSD){
        USD = newUSD;
    }

    public double calculate(){
        return USD * .74;
    }
}
