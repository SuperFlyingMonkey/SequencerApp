package com.example.samplerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaRecorder;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class waveReader {
    private String file;




    public void play() throws IOException {
        MediaPlayer mp = new MediaPlayer();

        try{

            String path = "SequencerApp/app/src/main/assets/dSounds";
            mp.setDataSource(path + File.separator+file);
            mp.prepare();
            mp.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void setSoundNum(int soundN){
        switch (soundN){
            case 0: file="Pluck.wav";
            break;
            case 1: file ="sOne.wav";
            break;
            case 2: file ="sTwo.wav";
                break;
            case 3: file ="sThree.wav";
                break;
            case 4: file ="sFour.wav";
                break;
            case 5: file ="sFive.wav";
                break;
            case 6: file ="sSix.wav";
                break;
            case 7: file ="sSeven.wav";
                break;
            case 8: file ="sEight.wav";
                break;
            case 9: file ="sNine.wav";
                break;
            case 10: file ="sTen.wav";
                break;
            case 11: file ="sEleven.wav";
                break;
            case 12: file ="sTwelve.wav";
                break;
            case 13: file ="sThirteen.wav";
                break;
            case 14: file ="sFourteen.wav";
                break;
            case 15: file ="sFifteen.wav";
                break;
            case 16: file ="sSixteen.wav";
                break;
            }

    }
}


//TODO figure out how to read .wav files and play the audio



