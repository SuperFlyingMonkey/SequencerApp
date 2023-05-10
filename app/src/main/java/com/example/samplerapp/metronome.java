package com.example.samplerapp;

import java.util.concurrent.atomic.AtomicBoolean;

public class metronome extends Thread {
    private AtomicBoolean keepRunning;
    private int bpm;

    public metronome(int BPM){
     bpm = bpm;
     keepRunning = new AtomicBoolean(true);
 }
    public void end(){
        keepRunning.set(false);
    }

    public void run(){
        while(keepRunning.get()){
            try{
                Thread.sleep((long) (1000*(60.0/bpm)));
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
