package com.lakshaykamat.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //onclick event listner on button
    public void multi(View view){
        //Input element
        EditText usrInput = findViewById(R.id.usrInput);
        //Text element
        TextView output = findViewById(R.id.output);
        //Converting input String to an Integer
        int usrNum = Integer.parseInt(usrInput.getText().toString());
        //setting empty text to output
        output.setText("");
        //loop for multiplication table
        for (int i = 1;i<=10;i++){
            //appending all loop result to output
            output.append(usrNum + " × " + i + " = " +  usrNum*i + "\n");
        }
    }
}