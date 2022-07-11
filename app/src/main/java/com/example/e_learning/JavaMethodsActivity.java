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

public class JavaMethodsActivity extends AppCompatActivity {

    Button javaMethodsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_methods);

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_methods).findViewById(R.id.expand_text_view_methods);
        expandableTextViewComments.setText(Html.fromHtml(getString(R.string.java_methods_chapter)));

        VideoView videoView = findViewById(R.id.video_java_methods);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.java_methods;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        javaMethodsTest = findViewById(R.id.javaMethodsTest);
        javaMethodsTest.setOnClickListener(view -> startActivity(new Intent(JavaMethodsActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_METHODS)));
    }
}