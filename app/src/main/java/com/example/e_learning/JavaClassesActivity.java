package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class JavaClassesActivity extends AppCompatActivity {

    Button javaClassesTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_classes);

        String java_classes = Html.fromHtml(getString(R.string.java_classes_chapter)).toString();

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_classes).findViewById(R.id.expand_text_view_classes);
        expandableTextViewComments.setText(java_classes);

        javaClassesTest = findViewById(R.id.javaClassesTest);
        javaClassesTest.setOnClickListener(view -> startActivity(new Intent(JavaClassesActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_CLASSES)));
    }
}