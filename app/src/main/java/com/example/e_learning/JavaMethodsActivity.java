package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class JavaMethodsActivity extends AppCompatActivity {

    Button javaMethodsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_methods);

        String java_methods = Html.fromHtml(getString(R.string.java_methods_chapter)).toString();

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_methods).findViewById(R.id.expand_text_view_methods);
        expandableTextViewComments.setText(java_methods);

        javaMethodsTest = findViewById(R.id.javaMethodsTest);
        javaMethodsTest.setOnClickListener(view -> startActivity(new Intent(JavaMethodsActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_METHODS)));
    }
}