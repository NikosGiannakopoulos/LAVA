package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoresActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "HighScore";

    TextView finalScore, basicsScore, methodsScore, classesScore, fileHandlingScore;
    String correctAnswers, numberOfQuestions, pickedSubject, bestScore, sp_finalScore, sp_basicsScore, sp_methodsScore, sp_classesScore, sp_fileHandlingScore;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        finalScore = findViewById(R.id.finalScore);
        basicsScore = findViewById(R.id.basicsScore);
        methodsScore = findViewById(R.id.methodsScore);
        classesScore = findViewById(R.id.classesScore);
        fileHandlingScore = findViewById(R.id.fileHandlingScore);

        sharedPreferences = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        sp_finalScore = sharedPreferences.getString("finalScore", "-");
        sp_basicsScore = sharedPreferences.getString("basicsScore", "-");
        sp_methodsScore = sharedPreferences.getString("methodsScore", "-");
        sp_classesScore = sharedPreferences.getString("classesScore", "-");
        sp_fileHandlingScore = sharedPreferences.getString("fileHandlingScore", "-");

        finalScore.setText(sp_finalScore);
        basicsScore.setText(sp_basicsScore);
        methodsScore.setText(sp_methodsScore);
        classesScore.setText(sp_classesScore);
        fileHandlingScore.setText(sp_fileHandlingScore);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            correctAnswers = extras.getString("CorrectAnswers");
            numberOfQuestions = extras.getString("NumberOfQuestions");
            pickedSubject = extras.getString("PickedSubject");

            setScore(correctAnswers, numberOfQuestions, pickedSubject);
        }
        editor.putString("finalScore", String.valueOf(finalScore.getText()));
        editor.putString("basicsScore", String.valueOf(basicsScore.getText()));
        editor.putString("methodsScore", String.valueOf(methodsScore.getText()));
        editor.putString("classesScore", String.valueOf(classesScore.getText()));
        editor.putString("fileHandlingScore", String.valueOf(fileHandlingScore.getText()));
        editor.apply();
    }

    private void setScore(String correctAnswers, String numberOfQuestions, String pickedSubject) {
        String s, highScore;
        switch (pickedSubject) {
            case Question.SUBJECT_EVERYTHING:
                s = String.valueOf(finalScore.getText());
                break;
            case Question.SUBJECT_JAVA_BASICS:
                s = String.valueOf(basicsScore.getText());
                break;
            case Question.SUBJECT_JAVA_METHODS:
                s = String.valueOf(methodsScore.getText());
                break;
            case Question.SUBJECT_JAVA_CLASSES:
                s = String.valueOf(classesScore.getText());
                break;
            default:
                s = String.valueOf(fileHandlingScore.getText());
                break;
        }
        if (!s.equals("-")) {
            String[] parts = s.split("/");
            if (Integer.parseInt(parts[0]) > Integer.parseInt(correctAnswers)) {
                bestScore = parts[0];
            } else {
                bestScore = correctAnswers;
            }
        } else {
            bestScore = correctAnswers;
        }
        highScore = bestScore + "/" + numberOfQuestions;
        switch (pickedSubject) {
            case Question.SUBJECT_EVERYTHING:
                finalScore.setText(highScore);
                break;
            case Question.SUBJECT_JAVA_BASICS:
                basicsScore.setText(highScore);
                break;
            case Question.SUBJECT_JAVA_METHODS:
                methodsScore.setText(highScore);
                break;
            case Question.SUBJECT_JAVA_CLASSES:
                classesScore.setText(highScore);
                break;
            default:
                fileHandlingScore.setText(highScore);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ScoresActivity.this, MainActivity.class));
    }
}