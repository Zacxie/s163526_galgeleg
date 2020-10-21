package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Highscore_actitivty extends AppCompatActivity {


    public static ArrayList<String> scoreArrayList = new ArrayList<>();

    RecyclerView highscore_recyclerView;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        highscore_recyclerView = new RecyclerView(this);

        highscore_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        highscore_recyclerView.setAdapter(adapter);

        setContentView(highscore_recyclerView);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        System.out.println("kdsakdjskajdksajkdsjadjksajdksajdsjakdsjasdj "+ scoreArrayList.size());

    }

    RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
        @Override
        public int getItemCount() {
            return scoreArrayList.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            System.out.println("onCreateViewHolder ");
            View itemView = getLayoutInflater().inflate(R.layout.highscore_listelement, parent, false);
            return new RecyclerView.ViewHolder(itemView) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder vh, int position) {
            TextView overskrift = vh.itemView.findViewById(R.id.dato_listeelem);
            //overskrift.setText(prefs.getString("Score", "Ingen dato tilgængelig"));

            overskrift.setText(scoreArrayList.get(position));
        }
    };
}