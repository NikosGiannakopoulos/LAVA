package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaMethodsActivity extends AppCompatActivity {

    Button javaMethodsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_methods);

        javaMethodsTest = findViewById(R.id.javaMethodsTest);
        javaMethodsTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JavaMethodsActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_METHODS));
            }
        });
    }
}