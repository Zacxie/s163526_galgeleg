package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HovedMenu extends AppCompatActivity implements View.OnClickListener {

    Button start_Button, highscore_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hovedmenu);

        start_Button = findViewById(R.id.start_Button);
        highscore_Button = findViewById(R.id.highscore_Button);

        start_Button.setOnClickListener(this);
        highscore_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == start_Button) {
            Intent i = new Intent(this, Spil_activity.class);
            startActivity(i);
        }else if (v == highscore_Button) {
            Intent i = new Intent(this, Highscore_actitivty.class);
            startActivity(i);
        }
    }
}