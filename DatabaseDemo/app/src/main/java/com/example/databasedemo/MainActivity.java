package com.example.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //create a database
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            //create a table in the database
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3), id INTEGER PRIMARY key)");

            //insert two users
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Tommy', 4)");
            //myDatabase.execSQL("DELETE FROM users WHERE name = 'Kirsten' LIMIT 1");
            //myDatabase.execSQL("DELETE FROM users WHERE id = 1");
            //myDatabase.execSQL("UPDATE users SET age = 2 WHERE name = 'Tommy'");

            //select all the users
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age < 18", null);
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name = 'Rob' AND age = 34", null);
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'R%' LIMIT 1", null);

            //got the index of columns
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            //int idIndex = c.getColumnIndex("id");
            c.moveToFirst();
            //loop through to print
            while (c != null){
                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));
                //Log.i("id", Integer.toBinaryString(c.getInt(idIndex)));
                c.moveToNext();
            }
        }catch (Exception e) {

        }
    }
}
