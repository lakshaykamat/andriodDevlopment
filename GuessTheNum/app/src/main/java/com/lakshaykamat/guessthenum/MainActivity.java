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
    public int movesLeft = 7;
    public int movesUsed = 0;
    public Boolean usrWins = false;
    private EditText usrNumEl;
    private TextView textViewMovesLeft;
    private TextView resultEl;
    public static final String EXTRA_MOVES_LEFT = "com.lakshaykamat.guessnum.movesleft";
    public static final String EXTRA_MOVES_USED = "com.lakshaykamat.guessnum.movesused";
    public static final String EXTRA_USER_WINS = "com.lakshaykamat.guessnum.usrwins";
    public static final String EXTRA_RANDOM_NUM = "com.lakshaykamat.guessnum.radomnum";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        resultEl = findViewById(R.id.resultEl);
        usrNumEl = findViewById(R.id.usrNumEl);
        textViewMovesLeft = findViewById(R.id.textViewMoviesLeft);

        //Showing moves left on game loads
        textViewMovesLeft.setText("Total Moves: "+ movesLeft);


        DecimalFormat df = new DecimalFormat("#");
        double randomNum = Math.floor((Math.random() * 100  + 1));

        //formatting decimal places and converting to String
        String randomNumToString = df.format(randomNum);
        //Converting to randomNumToString Integer
        int randomNumToInt = Integer.parseInt(randomNumToString);


        //On click listener event on button
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                    //Converting user entered number to a String
                    String usrNumToString = usrNumEl.getText().toString();

                    //if user didn't enter any number shows this error and return the function
                    if (usrNumToString.equals("")) {
                        usrNumEl.setError("Enter a number");
                        return;
                    }

                    //converting user entered String to integer for comparison
                    int usrNumToInt = Integer.parseInt(usrNumToString);

                    //if user enter more than 100 or less than or equal to 0 show error
                    if (usrNumToInt > 100 || usrNumToInt <= 0) {
                        Toast.makeText(MainActivity.this, "Choose between [1 to 100]", Toast.LENGTH_SHORT).show();
                    }

                    //Checking Conditions or Comparing the numbers
                    if (usrNumToInt == randomNumToInt) {//if usrNum and randomNum is same usrWins = true
                        usrWins = true;
                        movesUsed++;//One move used
                        movesLeft--;//Lost one move
                        usrNumEl.setText("");//removing old number in input filed
                        textViewMovesLeft.setText("Moves: "+ movesLeft);
                        //creating the new activity and passing the arguments
                        creatingNewActivity(Integer.toString(movesLeft),Integer.toString(movesUsed),Boolean.toString(usrWins),randomNumToString);
                    } else if (usrNumToInt > randomNumToInt) {
                        movesLeft--;
                        movesUsed++;
                        resultEl.setText("Choose a Lower number");
                        usrNumEl.setText("");
                        textViewMovesLeft.setText("Moves: "+ movesLeft);
                    } else if (usrNumToInt < randomNumToInt) {
                        movesLeft--;
                        movesUsed++;
                        resultEl.setText("Choose a Higher Number");
                        usrNumEl.setText("");
                        textViewMovesLeft.setText("Moves: " + movesLeft);
                    } else {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    //if user has been used his all moves then end the game
                    zeroMoves(movesLeft, Integer.toString(movesUsed),Boolean.toString(usrWins),randomNumToString);
                }
        });
    }
    public void zeroMoves(int movesLeft, String movesUsed , String usrWins,String randomNum) {
        if(movesLeft == 0){
            Toast.makeText(MainActivity.this, "0 Moves left", Toast.LENGTH_SHORT).show();
            creatingNewActivity(Integer.toString(movesLeft),movesUsed,usrWins,randomNum);
        }
    }
    public void creatingNewActivity(String movesLeft,String moveUsed,String usrWins,String randomNum){
        Intent intent = new Intent(this,GameEnd.class);
        intent.putExtra(EXTRA_MOVES_LEFT,movesLeft);
        intent.putExtra(EXTRA_MOVES_USED,moveUsed);
        intent.putExtra(EXTRA_USER_WINS, usrWins);
        intent.putExtra(EXTRA_RANDOM_NUM, randomNum);
        startActivity(intent);
    }
}