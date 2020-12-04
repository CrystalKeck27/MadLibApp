package com.example.madlibapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class MadLibDisplay extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lib_display);

        textView = (TextView) findViewById(R.id.textView);

        MadLib madLib = (MadLib) getIntent().getSerializableExtra("MadLib");

        if (madLib != null) {
            textView.setText(madLib.getCompleteStory());
        }
    }
}