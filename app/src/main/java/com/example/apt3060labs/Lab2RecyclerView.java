package com.example.apt3060labs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class Lab2RecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> summaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        Button btnNextPage = findViewById(R.id.btnNextPage);

        summaryList = getIntent().getStringArrayListExtra("summaryList");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(summaryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnNextPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Lab2StringBuffer.class);
            intent.putStringArrayListExtra("summaryList", summaryList);
            startActivity(intent);
        });
    }
}