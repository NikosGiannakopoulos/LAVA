package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class StartExamActivity extends AppCompatActivity {

    Button startExam;
    Spinner subjectSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_start_exam);

        subjectSpinner = findViewById(R.id.subjectSpinner);
        String[] subjectOptions = Question.getAllSubjects();
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjectOptions);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);

        startExam = findViewById(R.id.startExam);
        startExam.setOnClickListener(view -> {
            String pickedSubject = subjectSpinner.getSelectedItem().toString();
            startActivity(new Intent(StartExamActivity.this, ExamsActivity.class).putExtra("PickedSubject", pickedSubject));
        });
    }
}