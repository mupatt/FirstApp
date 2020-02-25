package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SocialMedia extends AppCompatActivity {
    MediaPlayer mPlay;
   Button buttonStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        Button mp3 = (Button) findViewById(R.id.mp3sound);
        buttonStop=findViewById(R.id.halt);
        final MediaPlayer play = new MediaPlayer();

        mp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(SocialMedia.this,R.raw.trust);
                mediaPlayer.start();
            }
        });
//        buttonPause = (Button) findViewById(R.id.halt);
//        buttonPause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mPlay != null && mPlay.isPlaying()) {
//                    mPlay.stop();
//
//                }
//            }
//        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaP = MediaPlayer.create(SocialMedia.this,R.raw.trust);
              mediaP.stop();
            }
        });
        }

    }

