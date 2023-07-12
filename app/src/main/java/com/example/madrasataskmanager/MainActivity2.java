package com.example.madrasataskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextClass;
    private Button buttonSubmit;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextClass = findViewById(R.id.editTextClass);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        db = new DatabaseHelper(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success = addStudent();
                if (success) {
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                } else {
                    Toast.makeText(MainActivity2.this, "Failed to add student", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        //add student id, name and age
    public boolean addStudent() {
        String name = editTextName.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        int className = Integer.parseInt(editTextClass.getText().toString());

        Student obj = new Student(age, className, 1, 1, 0, 10, 0, 0, name);
        long result = db.insertStudent(obj);

        if (result != -1) {
            Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show();
            db.close();
            return true;
        } else {
            return false;
        }
    }
}
