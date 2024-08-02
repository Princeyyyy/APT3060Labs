package com.example.apt3060labs.quiz1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apt3060labs.R;

public class ViewStudentsActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private TextView studentsListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        dbHelper = new DBHelper(this);
        studentsListTextView = findViewById(R.id.studentsListTextView);

        displayAllStudents();
    }

    private void displayAllStudents() {
        Cursor cursor = dbHelper.getAllStudentData();
        StringBuilder stringBuilder = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                String idNumber = cursor.getString(cursor.getColumnIndex(DBHelper.COL_ID_NUMBER));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.COL_NAME));
                String gender = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GENDER));
                String courseMajor = cursor.getString(cursor.getColumnIndex(DBHelper.COL_COURSE_MAJOR));
                String hobbies = cursor.getString(cursor.getColumnIndex(DBHelper.COL_HOBBIES));

                stringBuilder.append("ID: ").append(idNumber).append("\n");
                stringBuilder.append("Name: ").append(name).append("\n");
                stringBuilder.append("Gender: ").append(gender).append("\n");
                stringBuilder.append("Course Major: ").append(courseMajor).append("\n");
                stringBuilder.append("Hobbies: ").append(hobbies).append("\n\n");
            } while (cursor.moveToNext());
        } else {
            stringBuilder.append("No students found.");
        }

        cursor.close();
        studentsListTextView.setText(stringBuilder.toString());
    }
}