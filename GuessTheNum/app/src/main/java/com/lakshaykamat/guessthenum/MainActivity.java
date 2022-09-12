package com.lakshaykamat.guessthenum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Variables
    public int movesLeft = 3;
    public int movesUsed = 0;
    public Boolean usrWins = false;
    private EditText usrNumEl;
    public static final String EXTRA_MOVES_LEFT = "com.lakshaykamat.guessnum.movesleft";
    public static final String EXTRA_MOVES_USED = "com.lakshaykamat.guessnum.movesused";
    public static final String EXTRA_USER_WINS = "com.lakshaykamat.guessnum.usrwins";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView resultEl = findViewById(R.id.resultEl);
        usrNumEl = findViewById(R.id.usrNumEl);

        DecimalFormat df = new DecimalFormat("#");
        double randomNum = Math.floor((Math.random() * 100  + 1));

        //formatting decimal places and converting to String
        String randomNumToString = df.format(randomNum);
        //resultEl.setText(randomNumToString);
        //Converting to Random Num Integer
        int randomNumToInt = Integer.parseInt(randomNumToString);


        //On click listener on button
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                    //Converting user entered number to a String
                    String usrNumToString = usrNumEl.getText().toString();

                    //if user didn't enter any number shows this error
                    if (usrNumToString.equals("")) {
                        usrNumEl.setError("Enter a number");
                        return;
                    }

                    //converting String to integer for comparison
                    int usrNumToInt = Integer.parseInt(usrNumToString);

                    //if user enter more than 100 or less than or equal to 0 show error
                    if (usrNumToInt > 100 || usrNumToInt <= 0) {
                        Toast.makeText(MainActivity.this, "Choose between [1 to 100]", Toast.LENGTH_SHORT).show();
                    }

                    //Checking Conditions
                    if (usrNumToInt == randomNumToInt) {
                        resultEl.setText("You wins");
                        usrNumEl.setText("");
                        usrWins = true;
                        movesUsed++;
                        creatingNewActivity(intToString(movesLeft),intToString(movesUsed), Boolean.toString(usrWins));
                    } else if (usrNumToInt > randomNumToInt) {
                        resultEl.setText("Choose a Lower number");
                        usrNumEl.setText("");
                       movesLeft--;
                       movesUsed++;
                    } else if (usrNumToInt < randomNumToInt) {
                        resultEl.setText("Choose a Higher Number");
                        usrNumEl.setText("");
                        movesLeft--;
                        movesUsed++;
                    } else {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    zeroMoves(movesLeft, intToString(movesUsed),Boolean.toString(usrWins));
                }
        });
    }
    public void zeroMoves(int movesLeft, String movesUsed , String usrWins) {
        if(movesLeft == 0){
            Toast.makeText(MainActivity.this, "0 Moves left", Toast.LENGTH_SHORT).show();
            String LEFT = intToString(movesLeft);
            creatingNewActivity(LEFT,movesUsed,usrWins);
            //return;
        }
        //Toast.makeText(MainActivity.this, "END", Toast.LENGTH_SHORT).show();
    }
    public void creatingNewActivity(String movesLeft,String moveUsed,String usrWins){
        Intent intent = new Intent(this,GameEnd.class);
        intent.putExtra(EXTRA_MOVES_LEFT,movesLeft);
        intent.putExtra(EXTRA_MOVES_USED,moveUsed);
        intent.putExtra(EXTRA_USER_WINS, usrWins);
        startActivity(intent);
    }
    public String intToString(int integer){
        return Integer.toString(integer);
    }

}