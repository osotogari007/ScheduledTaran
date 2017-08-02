package com.service;

/**
 * Created by User on 8/2/2017.
 */
public class Cronometer {
private long startTime;
 private  long endTime;
  public  void startTimer(){
         startTime = System.currentTimeMillis();
    }


   public void stopTimer() {
         endTime = System.currentTimeMillis();
    }


   public Long time() {
        return endTime - startTime;
    }
}
