package com.lakshaykamat.rpsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game_end extends AppCompatActivity {
    private MediaPlayer mediaPlayerGameEnd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        TextView yourScoreEnd = findViewById(R.id.yourScoreEnd);
        TextView compScore = findViewById(R.id.compScoreEnd);
        TextView finalWin = findViewById(R.id.finalWin);
        Button button = findViewById(R.id.button);


        Intent intent = getIntent();

        //getting name and scores
        String name = intent.getStringExtra(Game.EXTRA_YOUR_NAME);
        String yourScore = intent.getStringExtra(Game.EXTRA_YOUR_SCORE);
        String computerScore = intent.getStringExtra(Game.EXTRA_COMPUTER_SCORE);

        //getting string array defined in strings.xml
        String[] gameEnd = getResources().getStringArray(R.array.finalWin);
        String[] buttonText = getResources().getStringArray(R.array.button_win_lost);

        //if score is equal
        if(Integer.parseInt(yourScore) == Integer.parseInt(computerScore)){
            finalWin.setText(gameEnd[2]);//Draw
            button.setText(buttonText[0]);//Play again
        //if usr score is greater than comp score
        }else if(Integer.parseInt(yourScore) > Integer.parseInt(computerScore)){
            finalWin.setText(name +" "+ gameEnd[0]); //You Win
            button.setText(buttonText[0]);//Play Again
            //Playing media
            mediaPlayerGameEnd = MediaPlayer.create(this,R.raw.you_win);
            mediaPlayerGameEnd.start();
        }else{
            finalWin.setText(name +" "+ gameEnd[1]); //You lost
            button.setText(buttonText[1]);//Retry
            //Playing media
            mediaPlayerGameEnd = MediaPlayer.create(this,R.raw.you_lose);
            mediaPlayerGameEnd.start();
        }

        //setting text
        yourScoreEnd.setText("Your Score: "+yourScore);
        compScore.setText("Computer Score: "+computerScore);
    }
    //when user clicked on replay button
    public void replay(View view){
        //getting back to old intent
        Intent intent  = new Intent(Game_end.this,Game.class);
        //play media
        mediaPlayerGameEnd = MediaPlayer.create(this,R.raw.game_start);
        mediaPlayerGameEnd.start();
        startActivity(intent);
    }
}