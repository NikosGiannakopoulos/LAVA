package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SubjectsActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        CardView javaBasics = findViewById(R.id.javaBasics);
        CardView javaMethods = findViewById(R.id.javaMethods);
        CardView javaClasses = findViewById(R.id.javaClasses);
        CardView javaFileHandling = findViewById(R.id.javaFileHandling);

        javaBasics.setOnClickListener(view -> startActivity(new Intent(SubjectsActivity.this, JavaBasicsActivity.class)));

        javaMethods.setOnClickListener(view -> startActivity(new Intent(SubjectsActivity.this, JavaMethodsActivity.class)));

        javaClasses.setOnClickListener(view -> startActivity(new Intent(SubjectsActivity.this, JavaClassesActivity.class)));

        javaFileHandling.setOnClickListener(view -> startActivity(new Intent(SubjectsActivity.this, JavaFileHandlingActivity.class)));
    }
}