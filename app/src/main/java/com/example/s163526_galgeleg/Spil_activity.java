package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spil_activity extends AppCompatActivity implements View.OnClickListener {

    Button guess_button;
    TextView word_textView, bogstav_textView, usedLetters_textview;
    EditText letter_EditText;
    ImageView hangman_imageView;
    GalgeLogik galgeLogik = new GalgeLogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        guess_button = findViewById(R.id.guess_button);
        word_textView = findViewById(R.id.word_textView);
        bogstav_textView = findViewById(R.id.bogstav_textView);
        usedLetters_textview = findViewById(R.id.usedLetters_textview);
        letter_EditText = findViewById(R.id.letter_EditText);
        hangman_imageView = findViewById(R.id.hangman_imageView);

        guess_button.setOnClickListener(this);

        hangman_imageView.setImageResource(R.drawable.galge);
        word_textView.setText(galgeLogik.getSynligtOrd());

    }

    @Override
    public void onClick(View v) {
        galgeLogik.gætBogstav(letter_EditText.getText().toString()); // gæt bogstav

        if (galgeLogik.erSidsteBogstavKorrekt()) { //hvis bogstav var korrekt
            word_textView.setText(galgeLogik.getSynligtOrd());
            usedLetters_textview.setText(galgeLogik.getBrugteBogstaver().toString());
            letter_EditText.setText("");

        } else if (!galgeLogik.erSidsteBogstavKorrekt()) { //hvis bogstav var forkert
            usedLetters_textview.setText(galgeLogik.getBrugteBogstaver().toString());
            letter_EditText.setText("");
            hangman_imageView.setImageResource(R.drawable.forkert1);
        }

        //TODO Hvis ord er gættet, tilføj til score og skift skærmbillede til vinder

        //TODO Hvis ord ikke blev gættet, tilføj score og skift skræmbillede til taber



    }
}