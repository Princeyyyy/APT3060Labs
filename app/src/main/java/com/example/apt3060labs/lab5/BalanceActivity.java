package com.example.apt3060labs.lab5;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060labs.R;

public class BalanceActivity extends AppCompatActivity {
    private TextView balanceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        balanceTextView = findViewById(R.id.balanceTextView);
        double balance = BankAccount.getInstance().getBalance();
        balanceTextView.setText(String.format("Current Balance: Kes %.2f", balance));
    }
}