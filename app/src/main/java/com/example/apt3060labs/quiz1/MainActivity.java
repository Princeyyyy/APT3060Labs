package com.example.apt3060labs.quiz1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apt3060labs.R;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, contactInput, dobInput;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        dbHelper = new DBHelper(this);
        setButtonListeners();
    }

    private void initializeViews() {
        nameInput = findViewById(R.id.name);
        contactInput = findViewById(R.id.contact);
        dobInput = findViewById(R.id.dob);
    }

    private void setButtonListeners() {
        findViewById(R.id.btnInsert).setOnClickListener(v -> insertData());
        findViewById(R.id.btnUpdate).setOnClickListener(v -> updateData());
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteData());
        findViewById(R.id.btnView).setOnClickListener(v -> viewData());
        findViewById(R.id.btnStudentRegistration).setOnClickListener(v -> openStudentRegistration());
    }

    private void insertData() {
        if (validateInputs()) {
            boolean success = dbHelper.insertUserData(getName(), getContact(), getDob());
            showToast(success ? "New Entry Inserted" : "Failed to Insert Entry");
            clearInputs();
        }
    }

    private void updateData() {
        if (validateInputs()) {
            boolean success = dbHelper.updateUserData(getName(), getContact(), getDob());
            showToast(success ? "Entry Updated" : "Failed to Update Entry");
            clearInputs();
        }
    }

    private void deleteData() {
        String name = getName();
        if (!TextUtils.isEmpty(name)) {
            boolean success = dbHelper.deleteData(name);
            showToast(success ? "Entry Deleted" : "Failed to Delete Entry");
            clearInputs();
        } else {
            showToast("Please enter a name to delete");
        }
    }

    private void viewData() {
        Cursor cursor = dbHelper.getData();
        if (cursor.getCount() == 0) {
            showToast("No Entries Exist");
            return;
        }

        StringBuilder buffer = new StringBuilder();
        while (cursor.moveToNext()) {
            buffer.append("Name: ").append(cursor.getString(0)).append("\n");
            buffer.append("Contact: ").append(cursor.getString(1)).append("\n");
            buffer.append("Date of Birth: ").append(cursor.getString(2)).append("\n\n");
        }
        cursor.close();

        new AlertDialog.Builder(this)
                .setTitle("User Entries")
                .setMessage(buffer.toString())
                .setPositiveButton("OK", null)
                .show();
    }

    private void openStudentRegistration() {
        Intent intent = new Intent(this, StudentRegistrationActivity.class);
        startActivity(intent);
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(getName()) || TextUtils.isEmpty(getContact()) || TextUtils.isEmpty(getDob())) {
            showToast("Please fill all fields");
            return false;
        }
        return true;
    }

    private String getName() {
        return nameInput.getText().toString().trim();
    }

    private String getContact() {
        return contactInput.getText().toString().trim();
    }

    private String getDob() {
        return dobInput.getText().toString().trim();
    }

    private void clearInputs() {
        nameInput.setText("");
        contactInput.setText("");
        dobInput.setText("");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}