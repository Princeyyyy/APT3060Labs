package com.example.apt3060labs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        Button lab4 = findViewById(R.id.lab4);

        button1.setOnClickListener(view -> button2.setBackgroundColor(Color.RED));

        button2.setOnClickListener(view -> button3.setBackgroundColor(Color.BLUE));

        button3.setOnClickListener(view -> button4.setBackgroundColor(Color.GREEN));

        button4.setOnClickListener(view -> button1.setBackgroundColor(Color.YELLOW));

        lab4.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Lab4.class);
            startActivity(intent);
        });
    }
}