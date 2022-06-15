package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class ExamsActivity extends AppCompatActivity {

    TextView questionCount, countdown, question;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    List<Question> questionsList;
    int questionCounter;
    int questionCountTotal;
    Question currentQuestion;
    CountDownTimer countDownTimer;
    int score;
    String pickedSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        questionCount = findViewById(R.id.questionCount);
        question = findViewById(R.id.question);
        countdown = findViewById(R.id.countdown);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        pickedSubject = getIntent().getExtras().getString("PickedSubject");
        if (pickedSubject.equals(Question.SUBJECT_EVERYTHING)) {
            questionsList = dbHelper.getAllQuestions();
        } else {
            questionsList = dbHelper.getQuestions(pickedSubject);
        }
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

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
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
            delay = 1332;
        }
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            (radioGroup.getChildAt(i)).setEnabled(false);
        }
        new Handler().postDelayed(() -> {
            showNextQuestion();
            resetRadioButtons();
        }, delay);
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

    @SuppressLint("SetTextI18n")
    private void showNextQuestion() {
        resetRadioButtons();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionsList.get(questionCounter);

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
        startActivity(new Intent(ExamsActivity.this, ScoresActivity.class).
                putExtra("CorrectAnswers", String.valueOf(score)).
                putExtra("NumberOfQuestions", String.valueOf(questionCountTotal)).
                putExtra("PickedSubject", pickedSubject));
    }

    private void resetRadioButtons() {
        radioGroup.clearCheck();
        option1.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        option2.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        option3.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        option4.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            (radioGroup.getChildAt(i)).setEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ExamsActivity.this, MainActivity.class));
    }
}