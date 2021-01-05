package com.example.s163526_galgeleg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Vinder_activity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences prefs;
    Button wonExit_button;
    TextView tries_textview, won_textview;
    String tries;
    String ord;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinder);

        wonExit_button = findViewById(R.id.wonExit_Button);
        tries_textview = findViewById(R.id.tries_textview);
        won_textview = findViewById(R.id.textView);
        wonExit_button.setOnClickListener(this);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tries = extras.getString("KEY");
            tries_textview.setText("Antal forsøg: " + tries);
            ord = extras.getString("Ord");
        }





        sound = MediaPlayer.create(this, R.raw.cheer);
        sound.setVolume(1, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int fuldStyrke = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int aktuelStyrke = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (aktuelStyrke < fuldStyrke / 5) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, fuldStyrke / 5,
                    AudioManager.FLAG_SHOW_UI);
        }
        sound.start();

        AnimationSet animationSet = new AnimationSet(true);

        TranslateAnimation t = new TranslateAnimation(0, 0, 0,
                200);
        t.setDuration(500);
        t.setFillAfter(true);
        t.setRepeatCount(-1);
        t.setRepeatMode(TranslateAnimation.REVERSE);
        animationSet.addAnimation(t);

        RotateAnimation r = new RotateAnimation(0f, 15f, 0, 0);
        //r.setStartOffset(1000);
        r.setDuration(300);
        r.setRepeatCount(-1);
        r.setRepeatMode(RotateAnimation.REVERSE);
        animationSet.addAnimation(r);
        won_textview.startAnimation(animationSet);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        if (v == wonExit_button) {

            int count = prefs.getInt("count", 0);
            count++;
            prefs.edit().putInt("count", count).apply();
            prefs.edit().putString("Score" + count, "Forsøg: " + tries + ".").apply();
            prefs.edit().putString("Ord"+count, "Ord: "+ord).apply();


            Intent i = new Intent(this, HovedMenu.class);
            startActivity(i);
        }
    }

    @Override
    public void onDestroy() {
        sound.stop();
        sound.release();
        super.onDestroy();
    }
}