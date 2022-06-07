package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoresActivity extends AppCompatActivity {

    TextView finalScore;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String correctAnswers, numberOfQuestions, highScore;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        finalScore = findViewById(R.id.finalScore);

        sharedPreferences = getSharedPreferences("HighScore", MODE_PRIVATE);

        if (correctAnswers != null && numberOfQuestions != null) {
            //finalScore.setVisibility(View.VISIBLE);
            correctAnswers = getIntent().getExtras().getString("CorrectAnswers");
            numberOfQuestions = getIntent().getExtras().getString("NumberOfQuestions");
            highScore = correctAnswers + "/" + numberOfQuestions;
            editor = sharedPreferences.edit();
            editor.putString("highScore", highScore);
            editor.apply();
            finalScore.setText(highScore);
        } else {
            //finalScore.setVisibility(View.GONE);
        }
        finalScore.setText(sharedPreferences.getString("highScore", highScore));
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }
}