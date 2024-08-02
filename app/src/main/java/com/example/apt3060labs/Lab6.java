package com.example.apt3060labs;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Lab6 extends AppCompatActivity {

    private String[] teamNames = {"Mercedes", "Red Bull Racing", "Ferrari", "McLaren", "Alpine"};
    private String[] teamDetails = {
            "Mercedes: \n" +
                    "Founded: 1954\n" +
                    "Headquarters: Brackley, Northamptonshire, UK\n" +
                    "Championships: Seven-time Constructors' Champion\n" +
                    "Drivers: Lewis Hamilton, George Russell\n" +
                    "Notable Achievements: Dominant in recent years with multiple championships.\n" +
                    "Noteworthy Cars: W11, W12",

            "Red Bull Racing: \n" +
                    "Founded: 2005\n" +
                    "Headquarters: Milton Keynes, Buckinghamshire, UK\n" +
                    "Championships: Four-time Constructors' Champion\n" +
                    "Drivers: Max Verstappen, Sergio Pérez\n" +
                    "Notable Achievements: Known for its innovative designs and recent success.\n" +
                    "Noteworthy Cars: RB7, RB16",

            "Ferrari: \n" +
                    "Founded: 1929\n" +
                    "Headquarters: Maranello, Italy\n" +
                    "Championships: Multiple Constructors' Championships\n" +
                    "Drivers: Charles Leclerc, Carlos Sainz\n" +
                    "Notable Achievements: One of the most historic teams with a long legacy in F1.\n" +
                    "Noteworthy Cars: SF71H, SF1000",

            "McLaren: \n" +
                    "Founded: 1963\n" +
                    "Headquarters: Woking, Surrey, UK\n" +
                    "Championships: Multiple Constructors' Championships\n" +
                    "Drivers: Lando Norris, Oscar Piastri\n" +
                    "Notable Achievements: Known for its competitive edge and strong performances.\n" +
                    "Noteworthy Cars: MP4/4, MCL35M",

            "Alpine: \n" +
                    "Founded: 2021 (rebranding of Renault F1 Team)\n" +
                    "Headquarters: Enstone, Oxfordshire, UK\n" +
                    "Championships: Recent performances have shown promise\n" +
                    "Drivers: Esteban Ocon, Pierre Gasly\n" +
                    "Notable Achievements: Represents a fresh approach with recent successes.\n" +
                    "Noteworthy Cars: A521, A523"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

        GridView gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.team_item, R.id.teamName, teamNames);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> showTeamDetail(position));
    }

    private void showTeamDetail(int position) {
        Fragment teamDetailFragment = Lab6Fragment.newInstance(teamDetails[position]);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, teamDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}