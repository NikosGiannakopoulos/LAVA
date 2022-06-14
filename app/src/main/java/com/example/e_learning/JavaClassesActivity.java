package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaClassesActivity extends AppCompatActivity {

    Button javaClassesTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_classes);

        javaClassesTest = findViewById(R.id.javaClassesTest);
        javaClassesTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JavaClassesActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_CLASSES));
            }
        });
    }
}