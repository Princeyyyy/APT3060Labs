package com.example.apt3060labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Lab2ListView extends AppCompatActivity {
    private ListView listViewSummary;
    private ArrayList<String> summaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_list_view);

        listViewSummary = findViewById(R.id.listViewSummary);
        Button btnNextPage = findViewById(R.id.btnNextPage);

        summaryList = getIntent().getStringArrayListExtra("summaryList");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, summaryList);
        listViewSummary.setAdapter(adapter);

        btnNextPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Lab2RecyclerView.class);
            intent.putStringArrayListExtra("summaryList", summaryList);
            startActivity(intent);
        });
    }
}