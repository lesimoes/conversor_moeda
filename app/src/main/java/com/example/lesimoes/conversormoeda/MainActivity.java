package com.example.lesimoes.conversormoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import faranjit.currency.edittext.CurrencyEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ViewHolder mViewHolder = new ViewHolder();
    private NumberFormat mCurrency = new DecimalFormat("R$#,##0.00",
            new DecimalFormatSymbols(new Locale("pt", "BR")));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.btnCalculate = findViewById(R.id.btn_calcular);

        this.mViewHolder.btnCalculate.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_calcular){
            try {
                this.calculateCurrency();
            } catch (ParseException e) {
                this.mViewHolder.editValue.setText("");
                clearValues();
                e.printStackTrace();
            }
        }
    }


    private void clearValues() {
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
    }


    private void calculateCurrency() throws ParseException{

        double value = value = this.mViewHolder.editValue.getCurrencyDouble();
        this.mViewHolder.textDollar.setText(mCurrency.format(value * 3));
        this.mViewHolder.textEuro.setText(mCurrency.format(value * 4));

    }


    private static class ViewHolder  {

        CurrencyEditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button btnCalculate;


    }

}
