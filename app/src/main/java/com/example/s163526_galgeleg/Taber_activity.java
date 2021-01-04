package com.example.s163526_galgeleg;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Taber_activity extends AppCompatActivity implements View.OnClickListener {

    Button lostExit_button;
    TextView lostWord_textview;
    ImageView lost_imageView;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taber);

        lostExit_button = findViewById(R.id.lostExit_button);
        lostWord_textview = findViewById(R.id.lostWord_textview);
        lost_imageView = findViewById(R.id.lost_imageView);

        lostExit_button.setOnClickListener(this);

        lost_imageView.setImageResource(R.drawable.forkert6);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("KEY");
            lostWord_textview.setText("Ord du skulle have gættet: " + value);
        }

        sound = MediaPlayer.create(this, R.raw.laugh);
        sound.setVolume(1, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int fuldStyrke = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int aktuelStyrke = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (aktuelStyrke < fuldStyrke / 5) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, fuldStyrke / 5, AudioManager.FLAG_SHOW_UI);
        }
        sound.start();

        RotateAnimation r = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        r.setDuration(1500);
        r.setRepeatCount(-1);
        r.setInterpolator(new LinearInterpolator());
        lost_imageView.startAnimation(r);

    }

    @Override
    public void onClick(View v) {
        if (v == lostExit_button) {
            Intent i = new Intent(this, HovedMenu.class);
            startActivity(i);
        }
    }
}