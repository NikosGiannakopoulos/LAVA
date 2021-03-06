package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView subjects = findViewById(R.id.subjects);
        CardView scores = findViewById(R.id.scores);
        CardView exams = findViewById(R.id.exams);

        subjects.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SubjectsActivity.class)));

        scores.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ScoresActivity.class)));

        exams.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, StartExamActivity.class)));
    }
}