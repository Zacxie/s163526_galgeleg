package com.example.s163526_galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class HovedMenu extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    Button start_Button, highscore_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hovedmenu);

        start_Button = findViewById(R.id.start_Button);
        highscore_Button = findViewById(R.id.highscore_Button);

        start_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(HovedMenu.this, v);
                popup.setOnMenuItemClickListener(HovedMenu.this);
                popup.inflate(R.menu.popup_menu);
                popup.show();
            }
        });
        highscore_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
          if (v == highscore_Button) {
            Intent i = new Intent(this, Highscore_actitivty.class);
            startActivity(i);
        }
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(this, Spil_activity.class);
        switch (item.getItemId()) {
            case R.id.Nem:
                i.putExtra("mode", 1);
                startActivity(i);
                return true;
            case R.id.Medium:
                i.putExtra("mode", 2);
                startActivity(i);
                return true;
            case R.id.Svær:
                i.putExtra("mode", 3);
                startActivity(i);
                return true;
        }
        return false;
    }
}