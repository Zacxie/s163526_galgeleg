package com.example.s163526_galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Highscore_actitivty extends AppCompatActivity {

    String[] landeArray = {"Danmark", "Norge", "Sverige", "Island", "Færøerne", "Finland",
            "Tyskland", "Østrig", "Belgien", "Holland", "Italien", "Grækenland",
            "Frankrig", "Spanien", "Portugal", "Nepal", "Indien", "Kina", "Japan", "Thailand"};
    // Vi laver en arrayliste så vi kan fjerne/indsætte elementer
    ArrayList<String> lande = new ArrayList<>(Arrays.asList(landeArray));

    RecyclerView highscore_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        highscore_recyclerView = new RecyclerView(this);

        highscore_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        highscore_recyclerView.setAdapter(adapter);

        setContentView(highscore_recyclerView);

    }
    RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
        @Override
        public int getItemCount()  {
            return lande.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            System.out.println("onCreateViewHolder ");
            View itemView = getLayoutInflater().inflate(R.layout.highscore_listelement2, parent, false);
            return new RecyclerView.ViewHolder(itemView) {};
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder vh, int position) {
            System.out.println("onBindViewHolder "+position);
            TextView overskrift = vh.itemView.findViewById(R.id.dato_listeelem);
            TextView beskrivelse = vh.itemView.findViewById(R.id.score_listeelem);
            ImageView billede = vh.itemView.findViewById(R.id.billede_listeelem);
            overskrift.setText(lande.get(position));

            beskrivelse.setText("score");
            if (position % 3 == 2) {
                billede.setImageResource(android.R.drawable.sym_action_call);
            } else {
                billede.setImageResource(android.R.drawable.sym_action_email);
            }
        }
    };

}