package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Taber_activity extends AppCompatActivity implements View.OnClickListener {

    Button lostExit_button;
    TextView lostWord_textview;
    ImageView lost_imageView;

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
        if(extras !=null) {
            String value = extras.getString("KEY");
            lostWord_textview.setText("Ord du skulle have gættet: "+value);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == lostExit_button) {
            Intent i = new Intent(this, HovedMenu.class);
            startActivity(i);
        }
    }
}