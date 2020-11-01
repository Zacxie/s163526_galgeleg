package com.example.s163526_galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Spil_activity extends AppCompatActivity implements View.OnClickListener {

    Button guess_button;
    TextView word_textview, bogstav_textview, usedLetters_textview;
    EditText letter_edittext;
    ImageView hangman_imageview;

    private GalgeLogik_Interface galgeLogik = GalgelegFactory.getInstance().getSession("Standard");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        galgeLogik.startNytSpil();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);

        guess_button = findViewById(R.id.guess_button);
        word_textview = findViewById(R.id.word_textView);
        bogstav_textview = findViewById(R.id.bogstav_textView);
        usedLetters_textview = findViewById(R.id.usedLetters_textview);
        letter_edittext = findViewById(R.id.letter_EditText);
        hangman_imageview = findViewById(R.id.hangman_imageView);

        guess_button.setOnClickListener(this);

        hangman_imageview.setImageResource(R.drawable.galge);
        word_textview.setText(galgeLogik.getSynligtOrd());

    }

    @Override
    public void onClick(View v) {
        galgeLogik.gætBogstav(letter_edittext.getText().toString()); // gæt bogstav
        System.out.println(galgeLogik.getAntalForkerteBogstaver());
        System.out.println(galgeLogik.erSpilletTabt());

        if (galgeLogik.erSpilletVundet()) {
            Intent i = new Intent(this, Vinder_activity.class);
            i.putExtra("KEY", galgeLogik.getBrugteBogstaver().size() + "");
            i.putExtra("Ord", galgeLogik.getOrdet());
            startActivity(i);

        } else if (galgeLogik.erSidsteBogstavKorrekt()) { //hvis bogstav var korrekt
            word_textview.setText(galgeLogik.getSynligtOrd());
            usedLetters_textview.setText(galgeLogik.getBrugteBogstaver().toString());
            letter_edittext.setText("");

        } else if (!galgeLogik.erSidsteBogstavKorrekt()) { //hvis bogstav var forkert
            usedLetters_textview.setText(galgeLogik.getBrugteBogstaver().toString());
            letter_edittext.setText("");
            switch (galgeLogik.getAntalForkerteBogstaver()) {
                case 1:
                    hangman_imageview.setImageResource(R.drawable.forkert1);
                    break;
                case 2:
                    hangman_imageview.setImageResource(R.drawable.forkert2);
                    break;
                case 3:
                    hangman_imageview.setImageResource(R.drawable.forkert3);
                    break;
                case 4:
                    hangman_imageview.setImageResource(R.drawable.forkert4);
                    break;
                case 5:
                    hangman_imageview.setImageResource(R.drawable.forkert5);
                    break;
                case 6:
                    Intent i = new Intent(this, Taber_activity.class);
                    i.putExtra("KEY", galgeLogik.getOrdet());
                    startActivity(i);
            }
        }
    }
}