package com.lakshaykamat.rpsgame;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game_end extends AppCompatActivity {
    private MediaPlayer mediaPlayerGameEnd;
    int totalPlayedGames;

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        TextView yourScoreEnd = findViewById(R.id.yourScoreEnd);
        TextView compScore = findViewById(R.id.compScoreEnd);
        ImageView finalImg = findViewById(R.id.finalImg);
        Button button = findViewById(R.id.retryButton);
        int victoryImg = R.drawable.victory;
        int gameOverImg = R.drawable.game_over;


        //Getting name and scores from intent
        //String name = getIntent().getStringExtra(Game.EXTRA_YOUR_NAME);
        String yourScore = getIntent().getStringExtra(Game.EXTRA_YOUR_SCORE);
        String computerScore = getIntent().getStringExtra(Game.EXTRA_COMPUTER_SCORE);

        //Getting string array defined in strings.xml
        String[] buttonText = getResources().getStringArray(R.array.button_win_lost);

            //if computer score and user score are equal display Draw and change the button text to PLAY AGAIN
        if(Integer.parseInt(yourScore) == Integer.parseInt(computerScore)){
            button.setText(buttonText[0]);//Play again

            //if user score is greater than computer score display victory and change the button text to PLAY AGAIN
        }else if(Integer.parseInt(yourScore) > Integer.parseInt(computerScore)){
            finalImg.setImageDrawable(getResources().getDrawable(victoryImg));
            button.setText(buttonText[0]);//Play Again

            //Playing sound effect of win
            mediaPlayerGameEnd = MediaPlayer.create(this,R.raw.you_win);
            mediaPlayerGameEnd.start();

            //if computer score is more than user score display game over and change the button text to RETRY
        }else{
            button.setText(buttonText[1]);//Retry
            finalImg.setImageDrawable(getResources().getDrawable(gameOverImg));
            //Playing sound effect of lost
            mediaPlayerGameEnd = MediaPlayer.create(this,R.raw.you_lose);
            mediaPlayerGameEnd.start();
        }

        totalPlayedGames+=1;
        //setting text
        yourScoreEnd.setText("Your Score: "+yourScore);
        //compScore.setText("Computer Score: "+computerScore);
        compScore.setText("Computer Score: "+totalPlayedGames);
    }

    //when user clicked on PLAY AGAIN OR RETRY button
    public void replay(View view){
        //play media
        mediaPlayerGameEnd = MediaPlayer.create(this,R.raw.game_start);
        mediaPlayerGameEnd.start();
        //getting back to old intent
        startActivity(new Intent(this,Game.class));
    }

    //going to MainActivity.class when user press home button
    public void goHome(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
