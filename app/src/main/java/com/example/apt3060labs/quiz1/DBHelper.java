package com.example.apt3060labs.quiz1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Userdata.db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_USER = "Userdetails";
    private static final String TABLE_STUDENT = "Studentdetails";
    public static final String COL_NAME = "name";
    private static final String COL_CONTACT = "contact";
    private static final String COL_DOB = "dob";
    public static final String COL_ID_NUMBER = "id_number";
    public static final String COL_GENDER = "gender";
    public static final String COL_COURSE_MAJOR = "course_major";
    public static final String COL_HOBBIES = "hobbies";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createUserTable(db);
        createStudentTable(db);
    }

    private void createUserTable(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + TABLE_USER + " (" +
                COL_NAME + " TEXT PRIMARY KEY, " +
                COL_CONTACT + " TEXT, " +
                COL_DOB + " TEXT)";
        db.execSQL(createUserTable);
    }

    private void createStudentTable(SQLiteDatabase db) {
        String createStudentTable = "CREATE TABLE " + TABLE_STUDENT + " (" +
                COL_ID_NUMBER + " TEXT PRIMARY KEY, " +
                COL_NAME + " TEXT, " +
                COL_GENDER + " TEXT, " +
                COL_COURSE_MAJOR + " TEXT, " +
                COL_HOBBIES + " TEXT)";
        db.execSQL(createStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

    public boolean insertStudentData(String idNumber, String fullName, String gender, String courseMajor, String hobbies) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID_NUMBER, idNumber);
        contentValues.put(COL_NAME, fullName);
        contentValues.put(COL_GENDER, gender);
        contentValues.put(COL_COURSE_MAJOR, courseMajor);
        contentValues.put(COL_HOBBIES, hobbies);
        long result = db.insert(TABLE_STUDENT, null, contentValues);
        return result != -1;
    }

    public Cursor getAllStudentData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_STUDENT, null, null, null, null, null, null);
    }

    public boolean insertUserData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_CONTACT, contact);
        contentValues.put(COL_DOB, dob);
        long result = db.insert(TABLE_USER, null, contentValues);
        return result != -1;
    }

    public boolean updateUserData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CONTACT, contact);
        contentValues.put(COL_DOB, dob);
        int result = db.update(TABLE_USER, contentValues, COL_NAME + " = ?", new String[]{name});
        return result > 0;
    }

    public boolean deleteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_USER, COL_NAME + " = ?", new String[]{name});
        return result > 0;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_USER, null, null, null, null, null, null);
    }
}