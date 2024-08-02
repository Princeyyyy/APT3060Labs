package com.example.apt3060labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Lab2StringBuffer extends AppCompatActivity {

    private TextView tvFinalSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_string_buffer);

        Button lab3 = findViewById(R.id.lab3);

        tvFinalSummary = findViewById(R.id.tvFinalSummary);

        ArrayList<String> summaryList = getIntent().getStringArrayListExtra("summaryList");

        StringBuilder stringBuffer = new StringBuilder();
        assert summaryList != null;

        for (String item : summaryList) {
            stringBuffer.append(item).append("\n\n");
        }

        tvFinalSummary.setText(stringBuffer.toString());

        lab3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Lab3.class);
            startActivity(intent);
        });
    }
}