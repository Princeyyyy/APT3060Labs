package com.example.apt3060labs.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060labs.R;

public class MenuActivity extends AppCompatActivity {
    private Button depositButton, withdrawButton, balanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        depositButton = findViewById(R.id.depositButton);
        withdrawButton = findViewById(R.id.withdrawButton);
        balanceButton = findViewById(R.id.balanceButton);

        depositButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, DepositActivity.class);
            startActivity(intent);
        });

        withdrawButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, WithdrawalActivity.class);
            startActivity(intent);
        });

        balanceButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, BalanceActivity.class);
            startActivity(intent);
        });
    }
}