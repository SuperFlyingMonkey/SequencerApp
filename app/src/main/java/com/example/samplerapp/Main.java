//TODO figure out how to import and save audio
//TODO implement a way to change BPM and have it affect the recorded playback
//TODO display the audio waveform
// be able to edit said wave form
//TODO add slider
//TODO add pitch difference between buttons



package com.example.samplerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends AppCompatActivity implements View.OnTouchListener {

    private ArrayList<Integer>noteOrder;
    private boolean record;
    private boolean play;
    private boolean setSound;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String mediaPath;
    private SoundPool soundPool;
    private int soundX;
    private int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16;


    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId", "ResourceType"})


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout theLayout = findViewById(R.id.theLayout);
        theLayout.setBackgroundColor(0xFF151515);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
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


        //***Initializing Stuff***
         noteOrder = new ArrayList<Integer>();
         record = false;
         play =false;
         setSound = false;

        //Load Default sounds
        s1 = soundPool.load(this,R.raw.keysound,1);
        s2 = soundPool.load(this,R.raw.squareish,1);
        s3 = soundPool.load(this,R.raw.wind,1);
        s4 = soundPool.load(this,R.raw.piano,1);
        s5 = soundPool.load(this,R.raw.organ,1);
        s6 = soundPool.load(this,R.raw.saw,1);
        s7 = soundPool.load(this,R.raw.buzz,1);
        s8 = soundPool.load(this,R.raw.guitar,1);
        s9 = soundPool.load(this,R.raw.ukulele,1);
        s10 = soundPool.load(this,R.raw.cable,1);
        s11 = soundPool.load(this,R.raw.glass,1);
        s12 = soundPool.load(this,R.raw.synth1,1);
        s13 = soundPool.load(this,R.raw.synth2,1);
        s14 = soundPool.load(this,R.raw.synth3,1);
        s15 = soundPool.load(this,R.raw.synth4,1);
        s16 = soundPool.load(this,R.raw.beep,1);


         //Buttons buttons buttons!!!
        Button vSlider = findViewById(R.id.volumeSlider);
        Button rBtn = findViewById(R.id.recordBtn);
        Button pBtn = findViewById(R.id.playBtn);
        View box = findViewById(R.id.outerBox);
        Button b1 = findViewById(R.id.buttonOne);
        Button b2 = findViewById(R.id.buttonTwo);
        Button b3 = findViewById(R.id.buttonThree);
        Button b4 = findViewById(R.id.buttonFour);
        Button b5 = findViewById(R.id.buttonFive);
        Button b6 = findViewById(R.id.buttonSix);
        Button b7 = findViewById(R.id.buttonSeven);
        Button b8 = findViewById(R.id.buttonEight);
        Button b9 = findViewById(R.id.buttonNine);
        Button b10 = findViewById(R.id.buttonTen);
        Button b11 = findViewById(R.id.buttonEleven);
        Button b12 = findViewById(R.id.buttonTwelve);
        Button b13 = findViewById(R.id.buttonThirteen);
        Button b14 = findViewById(R.id.buttonFourTeen);
        Button b15 = findViewById(R.id.buttonFifTeen);
        Button b16 = findViewById(R.id.buttonSixteen);

        b1.setBackgroundColor(0xFFECE2BC);
        b2.setBackgroundColor(0xFFECE2BC);
        b3.setBackgroundColor(0xFFECE2BC);
        b4.setBackgroundColor(0xFFECE2BC);
        b5.setBackgroundColor(0xFFECE2BC);
        b6.setBackgroundColor(0xFFECE2BC);
        b7.setBackgroundColor(0xFFECE2BC);
        b8.setBackgroundColor(0xFFECE2BC);
        b9.setBackgroundColor(0xFFECE2BC);
        b10.setBackgroundColor(0xFFECE2BC);
        b11.setBackgroundColor(0xFFECE2BC);
        b12.setBackgroundColor(0xFFECE2BC);
        b13.setBackgroundColor(0xFFECE2BC);
        b14.setBackgroundColor(0xFFECE2BC);
        b15.setBackgroundColor(0xFFECE2BC);
        b16.setBackgroundColor(0xFFECE2BC);
        rBtn.setBackgroundColor(0xFFECE2BC);
        pBtn.setBackgroundColor(0xFFECE2BC);
        box.setBackgroundColor(0XFF0A0A10);
        vSlider.setBackgroundColor(0XFF0A0A10);

        b1.setOnTouchListener(this);
        b2.setOnTouchListener(this);
        b3.setOnTouchListener(this);
        b4.setOnTouchListener(this);
        b5.setOnTouchListener(this);
        b6.setOnTouchListener(this);
        b7.setOnTouchListener(this);
        b8.setOnTouchListener(this);
        b9.setOnTouchListener(this);
        b10.setOnTouchListener(this);
        b11.setOnTouchListener(this);
        b12.setOnTouchListener(this);
        b13.setOnTouchListener(this);
        b14.setOnTouchListener(this);
        b15.setOnTouchListener(this);
        b16.setOnTouchListener(this);
        rBtn.setOnTouchListener(this);
        pBtn.setOnTouchListener(this);
    //TODO make the play button go through all element of the arraylist and loop through their outputs

    }



    //Detection of UI inputs via Buttons and sliders
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})

    public boolean onTouch (View view, MotionEvent motionEvent){
        TextView text = findViewById(R.id.outerBox);

        //**** This should add note from button presses and stores them in the "noteOrder" array
        if(record){
                noteOrder.add(view.getId());
            }

        //***Note-Buttons Functionality***
        switch (view.getId()) {
            case R.id.buttonOne:
                //TODO Make choosing sounds possible
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s1, 1, 1, 0, 0, 0.5F);
                        text.setText("1");

                    }
                    else if(!setSound && motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                        int i=0;
                        while(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                            i++;
                        }
                        if(i>=1000){
                            soundX = s1;
                            setSound =true;
                        }

                    }
                    else{
                        soundPool.play(soundX, 1, 1, 0, 0, 0.5F);
                    }
                    //TODO Give all buttons record functionality


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;




            case R.id.buttonTwo:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                   view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s2, 1, 1, 0, 0, 0.53F);


                    }
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;

            case R.id.buttonThree:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s3, 1, 1, 0, 0, 0.56F);
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;


            case R.id.buttonFour:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s4, 1, 1, 0, 0, 0.59F);
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonFive:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s5, 1, 1, 0, 0, 0.62F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonSix:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s6, 1, 1, 0, 0, 0.65F);
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonSeven:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s7, 1, 1, 0, 0, 0.68F);
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonEight:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s8, 1, 1, 0, 0, 0.71F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonNine:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    if(!setSound) {
                        soundPool.play(s9, 1, 1, 0, 0, 0.74F);
                    }

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonTen:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s10, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonEleven:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s11, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonTwelve:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s12, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonThirteen:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s13, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonFourTeen:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s14, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            case R.id.buttonFifTeen:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s15, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                    }
                break;
            case R.id.buttonSixteen:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN ) {
                    view.setBackgroundColor(0xFFE73939);

                    if(!setSound) {
                        soundPool.play(s16, 1, 1, 0, 0, 0.74F);
                    }


                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.setBackgroundColor(0xFFECE2BC);
                    if(!record) {
                        text.setText("");
                    }
                }
                break;
            //***End of Note Buttons


            //***Record Functionality***
            case R.id.recordBtn:

                if(motionEvent.getAction()== MotionEvent.ACTION_DOWN) {
                    if (!record && !play) {
                        record = true;
                        text.setText("Recording...");
                        //
                        // TODO add recording
                        //

                        view.setBackgroundColor(0xFFE73939);
                    }
                    else if (record) {
                        record = false;
                        text.setText("");
                        //
                        // TODO stop recording and save audio to file
                        //

                        view.setBackgroundColor(0xFFECE2BC);
                    }
                }
                break;

            //***Play button functionality***
            case R.id.playBtn:
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    if(!play && !record){
                        play =true;
                        //
                        // TODO add playback of current track
                        //
                        //


                        view.setBackgroundColor(0xFFE73939);
                    }
                    else if (play){
                        play = false;
                        //
                        //TODO Stop playback of current track
                        //
                        //

                        view.setBackgroundColor(0xFFECE2BC);
                    }
                }
                break;
            //***Volume slider***
            case R.id.volumeSlider:
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    //TODO get current volume and display it
                }

        }


        return true;
    }

    }
