package com.example.apt3060labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class Lab4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

        Button send = findViewById(R.id.sendSms);

        send.setOnClickListener(view -> {
            String number = "0742127157";
            String text = "Hey";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("smsto:"+number));
            intent.putExtra("sms_body",text);

            startActivity(intent);
        });
    }
}