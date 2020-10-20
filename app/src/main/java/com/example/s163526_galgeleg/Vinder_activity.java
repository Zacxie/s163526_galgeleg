package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vinder_activity extends AppCompatActivity implements View.OnClickListener {

    Button wonExit_button;
    TextView tries_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinder);

        wonExit_button = findViewById(R.id.wonExit_Button);
        tries_textview = findViewById(R.id.tries_textview);

        wonExit_button.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            String value = extras.getString("KEY");
            tries_textview.setText(value);
        }


    }

    @Override
    public void onClick(View v) {
        if (v == wonExit_button) {
            Intent i = new Intent(this, HovedMenu.class);
            startActivity(i);
        }

    }
}