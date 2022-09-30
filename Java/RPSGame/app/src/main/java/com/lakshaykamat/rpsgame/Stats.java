package com.lakshaykamat.rpsgame;

public class Stats {
    public static int totalPlayedGame;
    Stats(){
        totalPlayedGame+=1;
    }
    static int inc(){
        return totalPlayedGame+=1;
    }
}
