package com.example.convertmilestokm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer pianoMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        pianoMusic = MediaPlayer.create(this, R.raw.piano);
        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                pianoMusic.setLooping(b);
            }
        });
    }

    public void playMusic(View v) {
        pianoMusic.start();
    }

    public void pauseMusic(View v) {
        if (pianoMusic.isPlaying())
            pianoMusic.pause();
    }

}