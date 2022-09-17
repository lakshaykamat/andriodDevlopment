package com.lakshaykamat.rpsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput;
    private EditText roundsInput;
    public MediaPlayer mediaPlayer;

    public static final String EXTRA_NAME = "com.lakshaykamat.extra.name";
    public static final String EXTRA_ROUNDS_STRING = "com.lakshaykamat.extra.roundsstring";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Elements
        nameInput = findViewById(R.id.nameInput);
        roundsInput = findViewById(R.id.roundInput);
    }
    //When User Clicks Play Button this method loads
    public void playGame(View view){
        //getting name and rounds
        String name = nameInput.getText().toString();
        String roundsString = roundsInput.getText().toString();
        //if user not defined any of these set these
        if(name.equals("")){
            name = "You";
        }
        if(roundsString.equals("")){
            roundsString = "5";
        }
        //create a new intent
        Intent intent = new Intent(this,Game.class);
        //send name and rounds
        intent.putExtra(EXTRA_NAME,name);
        intent.putExtra(EXTRA_ROUNDS_STRING,roundsString);
        //Open the intent
        startActivity(intent);
        //play media when user clicks on play button
        mediaPlayer = MediaPlayer.create(this,R.raw.game_start);
        mediaPlayer.start();
    }
}