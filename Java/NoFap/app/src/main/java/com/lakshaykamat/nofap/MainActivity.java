package com.lakshaykamat.nofap;


import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{
    TextView textView;
    Time time = new Time();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        FloatingActionButton floatingActionButton = findViewById(R.id.setDateButton);
        floatingActionButton.setOnClickListener(view -> datePicker());
    }
    public void datePicker(){
        int[] currentTime = time.getCurrentTimeArr();//Returns Current Time
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (datePicker, selectedYear, selectedMonth, selectedDate) -> {
            //String usrTime = selectedDate  + "/" + (selectedMonth+1) + "/" + selectedYear + " "+ "20:11:30";
            String usrTime = selectedDate  + "/" + (selectedMonth+1) + "/" + selectedYear + " " + currentTime[3]+":"+currentTime[4]+":"+currentTime[5];
            time.setSelectedTime(usrTime);
            try {
                textView.setText("Difference :" + time.getTimeDifference(time.getCurrentTimeStr(), time.getChosenTime()) + "\nSelected Time : " + usrTime + "\nCurrent Time :" + time.currentTimeStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        },currentTime[2],(currentTime[1]-1),currentTime[0]);
        datePickerDialog.show();
    }
}