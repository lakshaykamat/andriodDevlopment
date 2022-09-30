package com.lakshaykamat.nofap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    String currentTimeStr;
    int[] currentTimeArr;
    String chosenTime;
    String difference;

    public void CurrentTime(){
        Calendar calendar = Calendar.getInstance();
        int HOURS = calendar.get(Calendar.HOUR);
        int MINUTES = calendar.get(Calendar.MINUTE);
        int SECONDS = calendar.get(Calendar.SECOND);
        int DATE = calendar.get(Calendar.DATE);
        int MONTH = calendar.get(Calendar.MONTH) + 1;
        int YEAR = calendar.get(Calendar.YEAR);
        this.currentTimeArr = new int[]{DATE, MONTH, YEAR, HOURS, MINUTES, SECONDS};
        this.currentTimeStr = this.currentTimeArr[0]+"/"+this.currentTimeArr[1]+"/"+this.currentTimeArr[2] + " " + HOURS + ":" + MINUTES + ":" + SECONDS;
    }
    public void timeDifference(String currentTime, String chosenTime) throws ParseException {
        String dateFormat = "dd/MM/yyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date now = simpleDateFormat.parse(currentTime);
        Date selectedTime = simpleDateFormat.parse(chosenTime);

        assert now != null;
        assert selectedTime != null;
        long difference = now.getTime() - selectedTime.getTime();

        int second = 1000;//1 second has 1000 milliseconds
        int minute = second * 60;// converting minute to milliseconds
        int hour = minute * 60;//converting hour to milliseconds
        int day = hour * 24; //converting day to milliseconds

        String daysTxt = String.valueOf(difference/day);
        String hoursTxt = String.valueOf((difference % day)/hour);
        String minutesTxt = String.valueOf((difference % hour)/minute);
        String secondTxt = String.valueOf((difference % minute)/second);
        this.difference = daysTxt + "Days " + hoursTxt + "Hours " + minutesTxt + "Minutes " + secondTxt + "Seconds ";
    }

    //Getters
    public int[] getCurrentTimeArr(){
        CurrentTime();
        return  currentTimeArr;
    }
    public String getCurrentTimeStr(){
        return currentTimeStr;
    }
    public String getTimeDifference(String currentTime, String chosenTime) throws ParseException {
        timeDifference(currentTime,chosenTime);
        return this.difference;
    }
    public String getChosenTime(){
        return chosenTime;
    }
    //Setters
    public void setSelectedTime(String chosenTime){
        this.chosenTime = chosenTime;
    }
}
