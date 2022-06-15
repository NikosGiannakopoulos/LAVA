package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JavaMethodsActivity extends AppCompatActivity {

    Button javaMethodsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_methods);

        javaMethodsTest = findViewById(R.id.javaMethodsTest);
        javaMethodsTest.setOnClickListener(view -> startActivity(new Intent(JavaMethodsActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_METHODS)));
    }
}