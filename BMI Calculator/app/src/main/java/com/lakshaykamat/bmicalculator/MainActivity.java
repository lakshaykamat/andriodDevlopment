 package com.lakshaykamat.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.PrintStream;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //onclick event listener when button is clicked
    public void bmicalc(View view){
        //Input Elements
        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);

        //Output Elements
        TextView output = findViewById(R.id.output);
        TextView output2 = findViewById(R.id.output2);

        //converting user input to Double by parsing
        double weightNum = Double.parseDouble(weight.getText().toString());
        double heightNum = Double.parseDouble(height.getText().toString());

        //Converting cm to m
        double cmToM = heightNum/100;
        //BMI Formula
        double bmi = (weightNum/(cmToM * cmToM));
        //Printing BMI and formatting decimal places to 1
        output.setText("Your BMI:" + String.format("%.1f",bmi));

        //Conditions
        if(bmi <= 18.5){
            output2.setText("You are Under Weight 😂");
        }else if (bmi > 18.5 && bmi <= 24.9){
            output2.setText("You are Normal 😎");
        }else if(bmi > 24.9 && bmi <=29.9){
            output2.setText("You are Over Weight 😢");
        }else if(bmi > 29.9 && bmi < 34.9){
            output2.setText("You have Obese 🙀");
        }else {
            output2.setText("You have High Obese 💀");
        }

    }
}