package com.example.apt3060labs.lab5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060labs.R;

public class DepositActivity extends AppCompatActivity {
    private EditText amountEditText;
    private Button depositButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        amountEditText = findViewById(R.id.amountEditText);
        depositButton = findViewById(R.id.depositButton);

        depositButton.setOnClickListener(v -> {
            String amountString = amountEditText.getText().toString();
            if (!amountString.isEmpty()) {
                double amount = Double.parseDouble(amountString);
                BankAccount.getInstance().deposit(amount);
                Toast.makeText(DepositActivity.this, "Deposit successful", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(DepositActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            }
        });
    }
}