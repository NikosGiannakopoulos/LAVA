package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoresActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "HighScore";

    TextView finalScore;
    String correctAnswers, numberOfQuestions, highScore, bestScore;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        finalScore = findViewById(R.id.finalScore);

        sharedPreferences = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        highScore = sharedPreferences.getString("highScore", "");
        finalScore.setText(highScore);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            correctAnswers = extras.getString("CorrectAnswers");
            numberOfQuestions = extras.getString("NumberOfQuestions");

            String fs = String.valueOf(finalScore.getText());

            if (!fs.equals("")) {
                String[] parts = fs.split("/");
                if (Integer.parseInt(parts[0]) > Integer.parseInt(correctAnswers)) {
                    bestScore = parts[0];
                } else {
                    bestScore = correctAnswers;
                }
            } else {
                bestScore = correctAnswers;
            }

            highScore = bestScore + "/" + numberOfQuestions;
            finalScore.setText(highScore);
        }
        editor.putString("highScore", String.valueOf(finalScore.getText()));
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ScoresActivity.this, MainActivity.class));
    }
}