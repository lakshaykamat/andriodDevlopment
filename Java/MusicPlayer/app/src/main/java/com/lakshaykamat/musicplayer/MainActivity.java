package com.lakshaykamat.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton playButton;
    private ImageButton pauseButton;
    private MediaPlayer media;
    private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //elements
        pauseButton = findViewById(R.id.pausebtn);
        cardView = findViewById(R.id.cardView);
        SeekBar seekbar = findViewById(R.id.seekBar);
        playButton = findViewById(R.id.playbtn);

        cardView.removeView(pauseButton);

        //Creating media instance
        media = MediaPlayer.create(this,R.raw.kes_song);

        seekbar.setMax(media.getDuration());

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    media.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.start();
                cardView.removeView(playButton);
                cardView.addView(pauseButton);
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.pause();
                cardView.removeView(pauseButton);
                cardView.addView(playButton);
            }
        });
    }
}