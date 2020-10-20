package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Highscore_actitivty extends AppCompatActivity implements View.OnClickListener {

    Button tilbage_Button;
    RecyclerView highscore_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        tilbage_Button = findViewById(R.id.tilbage_Button);

        tilbage_Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == tilbage_Button) {
            Intent i = new Intent(this, HovedMenu.class);
            startActivity(i);
        }

    }
}