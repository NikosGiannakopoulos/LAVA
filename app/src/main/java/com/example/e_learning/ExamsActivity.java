package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Collections;
import java.util.List;

public class ExamsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView questionCount, countdown, question;
    AppCompatButton option1, option2, option3, option4;
    List<Question> questionsList;
    int questionCounter;
    int questionCountTotal;
    Question currentQuestion;
    CountDownTimer countDownTimer;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        questionCount = findViewById(R.id.questionCount);
        question = findViewById(R.id.question);
        countdown = findViewById(R.id.countdown);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionsList = dbHelper.getAllQuestions();
        questionCountTotal = questionsList.size();
        Collections.shuffle(questionsList);

        showNextQuestion();
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinish) {
                countdown.setText(String.valueOf(millisUntilFinish / 1000));
            }

            @Override
            public void onFinish() {
                showNextQuestion();
            }
        };
        countDownTimer.start();
    }

    @SuppressLint("SetTextI18n")
    private void showNextQuestion() {
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionsList.get(questionCounter);

            resetButtons();

            question.setText(currentQuestion.getQuestion());
            option1.setText(currentQuestion.getOption1());
            option2.setText(currentQuestion.getOption2());
            option3.setText(currentQuestion.getOption3());
            option4.setText(currentQuestion.getOption4());

            questionCounter++;
            questionCount.setText(questionCounter + "/" + questionCountTotal);

            startCountDown();
        } else {
            finishExam();
        }
    }

    private void finishExam() {
        Intent showExamResults = new Intent(ExamsActivity.this, ScoresActivity.class);
        showExamResults.putExtra("CorrectAnswers", String.valueOf(score));
        showExamResults.putExtra("NumberOfQuestions", String.valueOf(questionCountTotal));
        startActivity(showExamResults);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int userChoice = 0;
        switch (view.getId()) {
            case R.id.option1:
                userChoice = 1;
                break;
            case R.id.option2:
                userChoice = 2;
                break;
            case R.id.option3:
                userChoice = 3;
                break;
            case R.id.option4:
                userChoice = 4;
                break;
            default:
        }
        countDownTimer.cancel();
        checkAnswer(userChoice, view);
    }

    private void checkAnswer(int userChoice, View view) {
        int delay;
        if (userChoice == currentQuestion.getAnswer()) {
            view.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(33, 204, 0)));
            score++;
            delay = 666;
        } else {
            view.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            showSolution();
            delay = 2000;
        }
        new Handler().postDelayed(this::showNextQuestion, delay);
    }

    @SuppressLint("SetTextI18n")
    private void showSolution() {
        switch (currentQuestion.getAnswer()) {
            case 1:
                option1.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(33, 204, 0)));
                break;
            case 2:
                option2.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(33, 204, 0)));
                break;
            case 3:
                option3.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(33, 204, 0)));
                break;
            case 4:
                option4.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(33, 204, 0)));
                break;
        }
    }

    private void resetButtons() {
        option1.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        option2.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        option3.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        option4.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ExamsActivity.this, MainActivity.class));
    }
}