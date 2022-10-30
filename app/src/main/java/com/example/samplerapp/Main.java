//TODO figure out how to import and save audio
//TODO make the 1-16 buttons play the audio
//TODO implement a way to change BPM and have it affect the recorded playback
//TODO display the audio waveform
// be able to edit said wave form
//TODO add slider
//TODO add pitch difference between buttons


//TODO *****GET AUDIO READING AND RECORD WORKING IN SEPARATE CLASSES*****
package com.example.samplerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends AppCompatActivity implements View.OnTouchListener {

    private ArrayList nOrder;
    private boolean record;
    private boolean play;
    private boolean setSound;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String mediaPath;
    private waveReader soundPlay = new waveReader();
    @SuppressLint({"ClickableViewAccessibility", "MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout theLayout = findViewById(R.id.theLayout);
        theLayout.setBackgroundColor(0xFF151515);


        //***Initializing Stuff***
         nOrder = new ArrayList();
         record = false;
         play =false;
         setSound = false;

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

        if(record){
                nOrder.add(view.getId());
            }
        switch (view.getId()) {


            //***Note Buttons Functionality***
            case R.id.buttonOne:
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view.setBackgroundColor(0xFFE73939);
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(1);
                        text.setText("one");
                    }

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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(2);
                        text.setText("two");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(3);
                        text.setText("three");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(4);
                        text.setText("four");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(5);
                        text.setText("five");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(6);
                        text.setText("six");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(7);
                        text.setText("seven");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(!record && setSound) {
                        soundPlay.setSoundNum(8);
                        text.setText("eight");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(9);
                        text.setText("nine");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(10);
                        text.setText("ten");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(11);
                        text.setText("eleven");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(12);
                        text.setText("twelve");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(13);
                        text.setText("thirteen");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(14);
                        text.setText("fourteen");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(15);
                        text.setText("fifteen");
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
                    try {
                        soundPlay.play();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(!record && setSound) {
                        soundPlay.setSoundNum(16);
                        text.setText("sixteen");
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

        }


        return true;
    }

    }
