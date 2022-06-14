package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaFileHandlingActivity extends AppCompatActivity {

    Button javaFileHandlingTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_file_handling);

        javaFileHandlingTest = findViewById(R.id.javaFileHandlingTest);
        javaFileHandlingTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JavaFileHandlingActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_FILE_HANDLING));
            }
        });
    }
}