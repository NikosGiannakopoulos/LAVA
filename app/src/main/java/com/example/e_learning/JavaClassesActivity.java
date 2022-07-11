package com.example.e_learning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class JavaClassesActivity extends AppCompatActivity {

    Button javaClassesTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_classes);

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_classes).findViewById(R.id.expand_text_view_classes);
        expandableTextViewComments.setText(Html.fromHtml(getString(R.string.java_classes_chapter)));

        VideoView videoView = findViewById(R.id.video_java_classes);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.java_classes;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        javaClassesTest = findViewById(R.id.javaClassesTest);
        javaClassesTest.setOnClickListener(view -> startActivity(new Intent(JavaClassesActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_CLASSES)));
    }
}