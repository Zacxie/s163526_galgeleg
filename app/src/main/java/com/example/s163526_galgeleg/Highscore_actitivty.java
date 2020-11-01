package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Highscore_actitivty extends AppCompatActivity {


    private ArrayList<String> scoreArrayList = new ArrayList<>();

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

        int count = prefs.getInt("count",0);
        for(int i=1; i<=count;i++){
            scoreArrayList.add(prefs.getString("Score"+i,""));

        }
            System.out.println(scoreArrayList.toString());
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