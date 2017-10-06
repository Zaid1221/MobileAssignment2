package com.example.zaidjavaid.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Converter converter;     //creating instance of converter class
    public NumberFormat money = NumberFormat.getCurrencyInstance( );
    private EditText USD_Amount;
    private TextView Pound_Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        converter = new Converter();
    }

    public void calculate(View v){

        USD_Amount = (EditText) findViewById(R.id.USD_Amount);          //gets value of USD amount for user
        Pound_Amount = (TextView) findViewById(R.id.Pound_Amount);  //gets empty value of Pounds

        String USDString = USD_Amount.getText().toString();      //makes the amount of USD into a string

        double dollars = Double.parseDouble(USDString);         //parses the string to a double

        converter.setUSD(dollars);      

        double pounds = converter.calculate(); //runs the converting calculation

        NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK); //formatting the answer to pounds 

        Pound_Amount.setText(GBP.format(pounds));    //setting the pound amount to the field 
    }
}

