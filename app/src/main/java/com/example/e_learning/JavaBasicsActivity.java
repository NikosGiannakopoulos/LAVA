package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class JavaBasicsActivity extends AppCompatActivity {

    Button javaBasicsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_basics);

        String java_comments = Html.fromHtml(getString(R.string.java_comments)).toString();

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_comments).findViewById(R.id.expand_text_view_comments);
        expandableTextViewComments.setText(java_comments);

        String java_variables = Html.fromHtml(getString(R.string.java_variables)).toString();

        ExpandableTextView expandableTextViewVariables = findViewById(R.id.expand_text_view_variables).findViewById(R.id.expand_text_view_variables);
        expandableTextViewVariables.setText(java_variables);

        javaBasicsTest = findViewById(R.id.javaBasicsTest);
        javaBasicsTest.setOnClickListener(view -> startActivity(new Intent(JavaBasicsActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_BASICS)));
    }
}