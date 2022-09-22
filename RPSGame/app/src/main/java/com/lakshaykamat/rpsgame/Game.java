package com.lakshaykamat.rpsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    String userChoice;
   String computerChoice;
   TextView yourScoreEl;
   TextView compScoreEl;
   TextView gameStatus;
   TextView versus;
   TextView roundsEl;
   MediaPlayer mediaPlayer;
   ImageView compChosenImg;
   ImageView userChosenImg;
    int userScore = 0;
    int compScore = 0;
    int rounds;
    int iteration = 0;
    String rock = "Rock";
    String paper = "Paper";
    String scissor = "Scissor";
    String usrName;
    public static final String EXTRA_YOUR_NAME = "com.lakshaykamat.extra.yourname";
    public static final String EXTRA_YOUR_SCORE = "com.lakshaykamat.extra.yourscore";
    public static final String EXTRA_COMPUTER_SCORE = "com.lakshaykamat.extra.computerscore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Elements
        roundsEl = findViewById(R.id.roundsEl);
        versus = findViewById(R.id.versus);
        ImageButton rockButton = findViewById(R.id.rockButton);
        ImageButton paperButton = findViewById(R.id.paperButton);
        ImageButton scissorButton = findViewById(R.id.scissorButton);
        userChosenImg = findViewById(R.id.userChoiceImg);
        compChosenImg = findViewById(R.id.compChoiceImg);
        gameStatus = findViewById(R.id.gameStatus);
        yourScoreEl = findViewById(R.id.yourScore);
        compScoreEl = findViewById(R.id.compScore);


        //getting name and rounds
       usrName = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
       String roundString = getIntent().getStringExtra(MainActivity.EXTRA_ROUNDS_STRING);
       //converting rounds to int and assigning
       rounds = Integer.parseInt(roundString);
       roundsEl.setText(getString(R.string.set_iteration,iteration));

        //Click listener on Image Button
        rockButton.setOnClickListener(view -> {
            userChoice = rock;
            buttonClicked(userScore,compScore);
        });
        paperButton.setOnClickListener(view -> {
            userChoice = paper;
            buttonClicked(userScore,compScore);
        });
        scissorButton.setOnClickListener(view -> {
            userChoice = scissor;
            buttonClicked(userScore,compScore);
        });
    }
    //Game Starts here
    public void playGame(String userChoice, String computerChoice,int userScore,int compScore){
        String usrWin = "You win";
        String compWin = "You Lose";
        String noWin = "Draw";
         if (userChoice.equals(computerChoice)){
             drawMethod(noWin,userScore,compScore);
         }else if(userChoice.equals(rock) && computerChoice.equals(paper)){
             compWinMethod(compWin,userScore,compScore);
         }else if(userChoice.equals(rock) && computerChoice.equals(scissor)){
             userWinMethod(usrWin,userScore,compScore);
         }else if(userChoice.equals(paper) && computerChoice.equals(rock)){
             userWinMethod(usrWin,userScore,compScore);
         }else if(userChoice.equals(paper) && computerChoice.equals(scissor)){
             compWinMethod(compWin,userScore,compScore);
         }else if(userChoice.equals(scissor) && computerChoice.equals(rock)){
             compWinMethod(compWin,userScore,compScore);
         }else if(userChoice.equals(scissor) && computerChoice.equals(paper)){
             userWinMethod(usrWin,userScore,compScore);
         }
         setButtonImage();
    }
    public void setButtonImage(){
        int rockImg = R.drawable.rock;
        int paperImg = R.drawable.paper;
        int scissorImg = R.drawable.scissor;
        //if user choice is set rock img
        if(userChoice.equals(rock)){
            setUsrImage(rockImg);
        }else if(userChoice.equals(paper)){
            setUsrImage(paperImg);
        }else if(userChoice.equals(scissor)){
            setUsrImage(scissorImg);
        }

        //if computer choice is set rock
        if (computerChoice.equals(rock)){
            setCompImage(rockImg);
        }else if(computerChoice.equals(paper)){
            setCompImage(paperImg);
        }else if(computerChoice.equals(scissor)){
            setCompImage(scissorImg);
        }
    }
    //Generates random number from 0 to 3 and assign computer choice
    public String setComputerChoice(){
        double randomNum = Math.floor(Math.random() * 3);
        if (randomNum == 0){
            computerChoice = "Rock";
        }else if(randomNum == 1){
            computerChoice = "Paper";
        }else{
            computerChoice = "Scissor";
        }
        return computerChoice;
    }
    //This method opens new Activity
    public void openNewActivity(int yourScore, int compScore,String name){
        if(rounds == iteration) {
            Intent intent = new Intent(this, Game_end.class);
            intent.putExtra(EXTRA_YOUR_NAME, name);
            intent.putExtra(EXTRA_YOUR_SCORE, Integer.toString(yourScore));
            intent.putExtra(EXTRA_COMPUTER_SCORE, Integer.toString(compScore));
            startActivity(intent);
        }
    }
    //When User wins
    public void userWinMethod(String usrWin,int userScore,int compScore){
        this.userScore = userScore+=5; //increment by 5
        //set win or lose
        gameStatus.setText(usrWin);
        //set scores
        yourScoreEl.setText(getString(R.string.setting_user_score,userScore));
        compScoreEl.setText(getString(R.string.setting_comp_score,compScore));
        //play media
        mediaPlayer = MediaPlayer.create(this,R.raw.small_win);
        mediaPlayer.start();
        openNewActivity(userScore,compScore,usrName);
    }
    //When Computer wins
    public void compWinMethod(String compWin,int userScore,int compScore){
       this.compScore = compScore+=5;
        gameStatus.setText(compWin);
        yourScoreEl.setText(getString(R.string.setting_user_score,userScore));
        compScoreEl.setText(getString(R.string.setting_comp_score,compScore));
        mediaPlayer = MediaPlayer.create(this,R.raw.small_lose);
        mediaPlayer.start();
        openNewActivity(userScore,compScore,usrName);
    }
    //When Math Draw
    public void drawMethod(String noWin,int userScore,int compScore){
        this.userScore =  userScore+=3;
        this.compScore = compScore+=3;
        yourScoreEl.setText(getString(R.string.setting_user_score,userScore));
        compScoreEl.setText(getString(R.string.setting_comp_score,compScore));
        gameStatus.setText(noWin);
        mediaPlayer = MediaPlayer.create(this,R.raw.small_lose);
        mediaPlayer.start();
        openNewActivity(userScore,compScore,usrName);
    }
    //When user Clicked any Button
    public void buttonClicked(int userScore,int compScore){
        ++iteration;//increment iteration
        //sets text to VS
        versus.setText(getString(R.string.set_versus));
        //Sets rounds
        roundsEl.setText(getString(R.string.set_iteration,iteration));
        //Generates computer choice
        computerChoice = setComputerChoice();
        //here all possibilities occurs of game
        playGame(userChoice,computerChoice,userScore,compScore);
    }
    public void setCompImage(int img){
        compChosenImg.setImageDrawable(getResources().getDrawable(img));
    }

    public void setUsrImage(int img){
        userChosenImg.setImageDrawable(getResources().getDrawable(img));
    }
    public static void inc(){

    }
}