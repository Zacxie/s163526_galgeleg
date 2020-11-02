package com.example.s163526_galgeleg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Vinder_activity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences prefs;
    Button wonExit_button;
    TextView tries_textview;
    String tries;
    String ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinder);

        wonExit_button = findViewById(R.id.wonExit_Button);
        tries_textview = findViewById(R.id.tries_textview);

        wonExit_button.setOnClickListener(this);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tries = extras.getString("KEY");
            tries_textview.setText("Antal forsøg: " + tries);
            ord = extras.getString("Ord");
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        if (v == wonExit_button) {

            int count = prefs.getInt("count", 0);
            count++;
            prefs.edit().putString("Score" + count, "Ord: " + ord + ". Forsøg: " + tries + ".").apply();
            prefs.edit().putInt("count", count).apply();

            Intent i = new Intent(this, HovedMenu.class);
            startActivity(i);
        }
    }
}