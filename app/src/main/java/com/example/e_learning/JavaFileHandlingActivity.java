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

public class JavaFileHandlingActivity extends AppCompatActivity {

    Button javaFileHandlingTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_file_handling);

        ExpandableTextView expandableTextViewComments = findViewById(R.id.expand_text_view_file_handling).findViewById(R.id.expand_text_view_file_handling);
        expandableTextViewComments.setText(Html.fromHtml(getString(R.string.java_file_handling_chapter)));

        VideoView videoView = findViewById(R.id.video_java_files);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.java_files;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        javaFileHandlingTest = findViewById(R.id.javaFileHandlingTest);
        javaFileHandlingTest.setOnClickListener(view -> startActivity(new Intent(JavaFileHandlingActivity.this, ExamsActivity.class).putExtra("PickedSubject", Question.SUBJECT_JAVA_FILE_HANDLING)));
    }
}