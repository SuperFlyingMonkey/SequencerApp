package com.example.samplerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
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


public class waveReader extends AppCompatActivity {
    private String file;
    private SoundPool soundPool;
    private int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;

    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(16)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else{
            soundPool = new SoundPool(16, AudioManager.STREAM_MUSIC,0);
        }

        s1 = soundPool.load(this,R.raw.keySound,1);
        s2 = soundPool.load(this,R.raw.keySound,1);
        s3 = soundPool.load(this,R.raw.keySound,1);
        s4 = soundPool.load(this,R.raw.keySound,1);
        s5 = soundPool.load(this,R.raw.keySound,1);
        s6 = soundPool.load(this,R.raw.keySound,1);
        s7 = soundPool.load(this,R.raw.keySound,1);
        s8 = soundPool.load(this,R.raw.keySound,1);
        s9 = soundPool.load(this,R.raw.keySound,1);
        s10 = soundPool.load(this,R.raw.keySound,1);
        s11 = soundPool.load(this,R.raw.keySound,1);
        s12 = soundPool.load(this,R.raw.keySound,1);
        s13 = soundPool.load(this,R.raw.keySound,1);
        s14 = soundPool.load(this,R.raw.keySound,1);
        s15 = soundPool.load(this,R.raw.keySound,1);
        s16 = soundPool.load(this,R.raw.keySound,1);




    }

}


//TODO figure out how to read .wav files and play the audio



