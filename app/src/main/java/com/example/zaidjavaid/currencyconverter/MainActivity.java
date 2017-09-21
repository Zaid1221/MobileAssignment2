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

    private Converter converter;
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

        USD_Amount = (EditText) findViewById(R.id.USD_Amount);
        Pound_Amount = (TextView) findViewById(R.id.Pound_Amount);

        String USDString = USD_Amount.getText().toString();

        double dollars = Double.parseDouble(USDString);

        converter.setUSD(dollars);

        double pounds = converter.calculate();

        NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);

        Pound_Amount.setText(GBP.format(pounds));
    }
}

