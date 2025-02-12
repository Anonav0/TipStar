package com.swarnavo.tipstart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText billAmount, tipPercentage;

    private Button btnCalculate;

    private TextView tipAmount, totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Initialize all the components
         billAmount = findViewById(R.id.billAmount);
         tipPercentage = findViewById(R.id.tipPercentage);
         btnCalculate = findViewById(R.id.btnCal);
         tipAmount = findViewById(R.id.tipAmount);
         totalAmount = findViewById(R.id.totalAmount);



         //make button clickable
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();

            }
        });

    }

    private void calculateTip(){

        //Get user inputs
        String billAmountStr, tipPercentageStr;

        billAmountStr = billAmount.getText().toString();
        tipPercentageStr = tipPercentage.getText().toString();

        // FOR TESTING PURPOSE ONLY
//                Toast.makeText(getApplicationContext(), "Bill Amount = "+ billAmountStr + "Tip Percentage = " + tipPercentageStr, Toast.LENGTH_SHORT).show();

        double billAmountDouble = Double.parseDouble(billAmountStr);
        double tipPercentageDouble = Double.parseDouble(tipPercentageStr);

        //Calculate tip
        double tip = (billAmountDouble * tipPercentageDouble) /100;
        double totAmount = billAmountDouble + tip;


        //Display results
        tipAmount.setText(String.format("Tip Amount : %.2f", tip));
        totalAmount.setText(String.format("Total Amount : %.2f", totAmount));
    }

}