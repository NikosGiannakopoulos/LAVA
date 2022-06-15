package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JavaClassesActivity extends AppCompatActivity {

    Button javaClassesTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_classes);

        javaClassesTest = findViewById(R.id.javaClassesTest);
        javaClassesTest.setOnClickListener(view -> startActivity(new Intent(JavaClassesActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_CLASSES)));
    }
}