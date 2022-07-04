package com.example.e_learning;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class JavaFileHandlingActivity extends AppCompatActivity {

    Button javaFileHandlingTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_file_handling);

        String java_file_handling = Html.fromHtml(getString(R.string.java_file_handling_chapter)).toString();

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_file_handling).findViewById(R.id.expand_text_view_file_handling);
        expandableTextViewComments.setText(java_file_handling);

        javaFileHandlingTest = findViewById(R.id.javaFileHandlingTest);
        javaFileHandlingTest.setOnClickListener(view -> startActivity(new Intent(JavaFileHandlingActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_FILE_HANDLING)));
    }
}