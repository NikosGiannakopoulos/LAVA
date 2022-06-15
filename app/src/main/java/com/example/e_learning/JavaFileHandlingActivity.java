package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JavaFileHandlingActivity extends AppCompatActivity {

    Button javaFileHandlingTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_file_handling);

        javaFileHandlingTest = findViewById(R.id.javaFileHandlingTest);
        javaFileHandlingTest.setOnClickListener(view -> startActivity(new Intent(JavaFileHandlingActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_FILE_HANDLING)));
    }
}