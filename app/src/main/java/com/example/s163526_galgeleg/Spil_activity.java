package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spil_activity extends AppCompatActivity implements View.OnClickListener{

    Button guess_Button;
    TextView word_textView, bogstav_textView;
    EditText letter_EditText;
    ImageView hangman_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        guess_Button = findViewById(R.id.guess_button);
        word_textView = findViewById(R.id.word_textView);
        bogstav_textView = findViewById(R.id.bogstav_textView);
        letter_EditText = findViewById(R.id.letter_EditText);
        hangman_imageView = findViewById(R.id.hangman_imageView);
    }

    @Override
    public void onClick(View v) {

    }
}