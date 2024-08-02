package com.example.apt3060labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Lab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        // Buttons
        Button btn_bread = findViewById(R.id.btn_bread);
        Button btn_pen = findViewById(R.id.btn_pen);
        Button btn_watch = findViewById(R.id.btn_watch);
        Button btn_milk = findViewById(R.id.btn_milk);

        Button btn_grand_total = findViewById(R.id.btn_grand_total);
        Button btn_discount = findViewById(R.id.btn_discount);
        Button btn_net_pay = findViewById(R.id.btn_net_pay);

        // Edit-texts
        EditText edt_bread_price = findViewById(R.id.edt_bread_price);
        EditText edt_pen_price = findViewById(R.id.edt_pen_price);
        EditText edt_watch_price = findViewById(R.id.edt_watch_price);
        EditText edt_milk_price = findViewById(R.id.edt_milk_price);

        EditText edt_bread_qty = findViewById(R.id.edt_bread_qty);
        EditText edt_pen_qty = findViewById(R.id.edt_pen_qty);
        EditText edt_watch_qty = findViewById(R.id.edt_watch_qty);
        EditText edt_milk_qty = findViewById(R.id.edt_milk_qty);

        EditText edt_bread_total = findViewById(R.id.edt_bread_total);
        EditText edt_pen_total = findViewById(R.id.edt_pen_total);
        EditText edt_watch_total = findViewById(R.id.edt_watch_total);
        EditText edt_milk_total = findViewById(R.id.edt_milk_total);

        EditText edt_discount = findViewById(R.id.edt_discount);
        EditText edt_grand_total = findViewById(R.id.edt_grand_total);
        EditText edt_net_pay = findViewById(R.id.edt_net_pay);

        Button lab2 = findViewById(R.id.lab2);

        btn_bread.setOnClickListener(v -> {
            int bread_price = Integer.parseInt(edt_bread_price.getText().toString());
            int bread_quantity = Integer.parseInt(edt_bread_qty.getText().toString());

            int total = bread_price * bread_quantity;

            edt_bread_total.setText(String.valueOf(total));
        });

        btn_pen.setOnClickListener(v -> {
            int pen_price = Integer.parseInt(edt_pen_price.getText().toString());
            int pen_quantity = Integer.parseInt(edt_pen_qty.getText().toString());

            int total = pen_price * pen_quantity;

            edt_pen_total.setText(String.valueOf(total));
        });

        btn_watch.setOnClickListener(v -> {
            int watch_price = Integer.parseInt(edt_watch_price.getText().toString());
            int watch_quantity = Integer.parseInt(edt_watch_qty.getText().toString());

            int total = watch_price * watch_quantity;

            edt_watch_total.setText(String.valueOf(total));
        });

        btn_milk.setOnClickListener(v -> {
            int milk_price = Integer.parseInt(edt_milk_price.getText().toString());
            int milk_quantity = Integer.parseInt(edt_milk_qty.getText().toString());

            int total = milk_price * milk_quantity;

            edt_milk_total.setText(String.valueOf(total));
        });

        btn_grand_total.setOnClickListener(v -> {
            int bread_total = Integer.parseInt(edt_bread_total.getText().toString());
            int pen_total = Integer.parseInt(edt_pen_total.getText().toString());
            int watch_total = Integer.parseInt(edt_watch_total.getText().toString());
            int milk_total = Integer.parseInt(edt_milk_total.getText().toString());

            int total = bread_total + pen_total + watch_total + milk_total;

            edt_grand_total.setText(String.valueOf(total));
        });

        btn_discount.setOnClickListener(v -> {
            double total = Double.parseDouble(edt_grand_total.getText().toString());
            double discounted = total * 0.15;

            edt_discount.setText(String.valueOf(discounted));
        });

        btn_net_pay.setOnClickListener(v -> {
            double total = Double.parseDouble(edt_grand_total.getText().toString());
            double discount = Double.parseDouble(edt_discount.getText().toString());
            double net_pay = total - discount;

            edt_net_pay.setText(String.valueOf(net_pay));
        });

        lab2.setOnClickListener(view -> {
            ArrayList<String> summaryList = new ArrayList<>();

            summaryList.add("Bread - Price: " + edt_bread_price.getText() + ", Qty: " + edt_bread_qty.getText() + ", Total: " + edt_bread_total.getText());
            summaryList.add("Pen - Price: " + edt_pen_price.getText() + ", Qty: " + edt_pen_qty.getText() + ", Total: " + edt_pen_total.getText());
            summaryList.add("Watch - Price: " + edt_watch_price.getText() + ", Qty: " + edt_watch_qty.getText() + ", Total: " + edt_watch_total.getText());
            summaryList.add("Milk - Price: " + edt_milk_price.getText() + ", Qty: " + edt_milk_qty.getText() + ", Total: " + edt_milk_total.getText());
            summaryList.add("Grand Total: " + edt_grand_total.getText());
            summaryList.add("Discount: " + edt_discount.getText());
            summaryList.add("Net Pay: " + edt_net_pay.getText());

            Intent intent = new Intent(getApplicationContext(), Lab2ListView.class);
            intent.putStringArrayListExtra("summaryList", summaryList);
            startActivity(intent);
        });
    }
}