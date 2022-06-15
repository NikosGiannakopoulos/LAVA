package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JavaBasicsActivity extends AppCompatActivity {

    Button javaBasicsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_basics);

        javaBasicsTest = findViewById(R.id.javaBasicsTest);
        javaBasicsTest.setOnClickListener(view -> startActivity(new Intent(JavaBasicsActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_BASICS)));
    }
}