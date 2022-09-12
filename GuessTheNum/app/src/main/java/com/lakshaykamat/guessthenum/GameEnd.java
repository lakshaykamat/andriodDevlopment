package com.lakshaykamat.guessthenum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        String endHeading = intent.getStringExtra(MainActivity.EXTRA_USER_WINS);
        String left = intent.getStringExtra(MainActivity.EXTRA_MOVES_LEFT);
        String used = intent.getStringExtra(MainActivity.EXTRA_MOVES_USED);

        if (endHeading.equals("true")){
            gameEndHeading.setText("YOU WIN");
        }else{
            gameEndHeading.setText("YOU LOSE");
        }

        movesLeft.setText("Moves Left: " + left);
        moveUsed.setText("Move Used: " + used);
    }
}