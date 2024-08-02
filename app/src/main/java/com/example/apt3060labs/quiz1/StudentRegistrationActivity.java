package com.example.apt3060labs.quiz1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060labs.R;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistrationActivity extends AppCompatActivity {
    private EditText fullNameInput, idNumberInput, courseMajorInput;
    private RadioGroup genderGroup;
    private CheckBox hobbyReading, hobbyGaming, hobbySports;
    private DBHelper dbHelper;
    private Button viewStudentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        initializeViews();
        dbHelper = new DBHelper(this);

        Button registerButton = findViewById(R.id.btnRegister);
        registerButton.setOnClickListener(v -> registerStudent());

        viewStudentsButton = findViewById(R.id.btnViewStudents);
        viewStudentsButton.setOnClickListener(v -> {
            Intent intent = new Intent(StudentRegistrationActivity.this, ViewStudentsActivity.class);
            startActivity(intent);
        });

        checkStudentData();
    }

    private void initializeViews() {
        fullNameInput = findViewById(R.id.fullName);
        idNumberInput = findViewById(R.id.idNumber);
        courseMajorInput = findViewById(R.id.courseMajor);
        genderGroup = findViewById(R.id.genderGroup);
        hobbyReading = findViewById(R.id.hobbyReading);
        hobbyGaming = findViewById(R.id.hobbyGaming);
        hobbySports = findViewById(R.id.hobbySports);
    }

    private void registerStudent() {
        String fullName = fullNameInput.getText().toString().trim();
        String idNumber = idNumberInput.getText().toString().trim();
        String courseMajor = courseMajorInput.getText().toString().trim();
        String gender = getSelectedGender();
        String hobbies = getSelectedHobbies();

        if (validateInputs(fullName, idNumber, courseMajor, gender)) {
            boolean success = dbHelper.insertStudentData(idNumber, fullName, gender, courseMajor, hobbies);
            if (success) {
                Toast.makeText(this, "Student registered successfully", Toast.LENGTH_SHORT).show();
                clearInputs();
                viewStudentsButton.setEnabled(true);  // Enable the button since a student has been registered
            } else {
                Toast.makeText(this, "Failed to register student", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validateInputs(String fullName, String idNumber, String courseMajor, String gender) {
        if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(idNumber) ||
                TextUtils.isEmpty(courseMajor) || TextUtils.isEmpty(gender)) {
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private String getSelectedGender() {
        int selectedId = genderGroup.getCheckedRadioButtonId();
        if (selectedId == -1) return "";
        RadioButton selectedRadioButton = findViewById(selectedId);
        return selectedRadioButton.getText().toString();
    }

    private String getSelectedHobbies() {
        List<String> selectedHobbies = new ArrayList<>();
        if (hobbyReading.isChecked()) selectedHobbies.add("Reading");
        if (hobbyGaming.isChecked()) selectedHobbies.add("Gaming");
        if (hobbySports.isChecked()) selectedHobbies.add("Sports");
        return TextUtils.join(", ", selectedHobbies);
    }

    private void clearInputs() {
        fullNameInput.setText("");
        idNumberInput.setText("");
        courseMajorInput.setText("");
        genderGroup.clearCheck();
        hobbyReading.setChecked(false);
        hobbyGaming.setChecked(false);
        hobbySports.setChecked(false);
    }

    private void checkStudentData() {
        Cursor cursor = dbHelper.getAllStudentData();
        viewStudentsButton.setEnabled(cursor.getCount() != 0);
        cursor.close();
    }
}
