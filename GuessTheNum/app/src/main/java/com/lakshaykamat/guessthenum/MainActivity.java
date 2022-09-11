package com.lakshaykamat.guessthenum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultEl = findViewById(R.id.resultEl);
        double randomNum = Math.floor((Math.random() * 100  + 1));
        String R = Double.toString(randomNum);
        resultEl.setText(R);
    }
}