package com.example.apt3060labs.lab5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060labs.R;

public class WithdrawalActivity extends AppCompatActivity {
    private EditText amountEditText;
    private Button withdrawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawal);

        amountEditText = findViewById(R.id.amountEditText);
        withdrawButton = findViewById(R.id.withdrawButton);

        withdrawButton.setOnClickListener(v -> {
            String amountString = amountEditText.getText().toString();
            if (!amountString.isEmpty()) {
                double amount = Double.parseDouble(amountString);
                if (BankAccount.getInstance().withdraw(amount)) {
                    Toast.makeText(getApplicationContext(), "Withdrawal successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Insufficient funds", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
            }
        });
    }
}