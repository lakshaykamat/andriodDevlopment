package com.lakshaykamat.guessthenum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);
        Intent intent = getIntent();
        Button retry = findViewById(R.id.retry);
        TextView gameEndHeading = findViewById(R.id.gameEndHeading);
        TextView movesLeft = findViewById(R.id.movesLeft);
        TextView moveUsed = findViewById(R.id.movesUsed);
        TextView randomNum = findViewById(R.id.randomNum);

        String endHeading = intent.getStringExtra(MainActivity.EXTRA_USER_WINS);
        String left = intent.getStringExtra(MainActivity.EXTRA_MOVES_LEFT);
        String used = intent.getStringExtra(MainActivity.EXTRA_MOVES_USED);
        String Num = intent.getStringExtra(MainActivity.EXTRA_RANDOM_NUM);

        if (endHeading.equals("true")){
            gameEndHeading.setText("YOU WIN");
        }else{
            gameEndHeading.setText("YOU LOSE");
        }

        randomNum.setText("The Number was: " + Num);
        movesLeft.setText("Moves Left: " + left);
        moveUsed.setText("Move Used: " + used);
    }
    public void retryGame(){
        Intent intent = new Intent(this,MainActivity.class);
    }
}