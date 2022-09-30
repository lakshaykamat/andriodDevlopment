package com.lakshaykamat.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usrInput;
    private TextView output;
    private  TextView heading;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        heading = findViewById(R.id.heading);
        //Onclick event listener on Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //Overriding the method on button
            public void onClick(View view) {
                //Input element
                usrInput = findViewById(R.id.usrInput);
                //Text element
                output = findViewById(R.id.output);

                //Usr entered number stored as string
                String usrString = usrInput.getText().toString();

                //if user didn't enter a number and clicking the submit button
                if(usrString.equals("")){
                    //setting error to input field
                    usrInput.setError("You haven't entered a number :(");
                //else condition that means user entered a number and then clicking the submit
                }else{
                    heading.setText("Multiplication Table of " + usrString);
                    //Converting input String to an Integer to calculate
                    int usrNum = Integer.parseInt(usrString);

                    //setting empty text to output so, if user again entered a number to Edit text so last multiplication has to be cleared
                    output.setText("");

                    //loop for multiplication table
                    for (int i = 1; i <= 10; i++) {
                        //appending all loop result to output
                        //if i is less than 10 so entering the 0 before using for formatting
                        if (i < 10) {
                            output.append(usrNum + " × " + "0" + i + " = " + usrNum * i + "\n");
                        } else {
                            output.append(usrNum + " × " + i + " = " + usrNum * i + "\n");
                        }
                    }
                }
            }
        });
    }
}