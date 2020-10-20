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
        System.out.println(galgeLogik.getAntalForkerteBogstaver());
        System.out.println(galgeLogik.erSpilletTabt());

        if (galgeLogik.erSpilletVundet()) {
            Intent i = new Intent(this, Vinder_activity.class);
            i.putExtra("KEY",  galgeLogik.getBrugteBogstaver().size()+"");
            startActivity(i);

        }  else if (galgeLogik.erSidsteBogstavKorrekt()) { //hvis bogstav var korrekt
            word_textView.setText(galgeLogik.getSynligtOrd());
            usedLetters_textview.setText(galgeLogik.getBrugteBogstaver().toString());
            letter_EditText.setText("");

        } else if (!galgeLogik.erSidsteBogstavKorrekt()) { //hvis bogstav var forkert
            usedLetters_textview.setText(galgeLogik.getBrugteBogstaver().toString());
            letter_EditText.setText("");
            switch (galgeLogik.getAntalForkerteBogstaver()) {
                case 1:
                    hangman_imageView.setImageResource(R.drawable.forkert1);
                    break;
                case 2:
                    hangman_imageView.setImageResource(R.drawable.forkert2);
                    break;
                case 3:
                    hangman_imageView.setImageResource(R.drawable.forkert3);
                    break;
                case 4:
                    hangman_imageView.setImageResource(R.drawable.forkert4);
                    break;
                case 5:
                    hangman_imageView.setImageResource(R.drawable.forkert5);
                    break;
                case 6:
                    Intent i = new Intent(this, Taber_activity.class);
                    i.putExtra("KEY", galgeLogik.getOrdet());
                    startActivity(i);
            }
        }

        //TODO Hvis ord er gættet, tilføj til score og skift skærmbillede til vinder

        //TODO Hvis ord ikke blev gættet, skift skræmbillede til taber



    }
}