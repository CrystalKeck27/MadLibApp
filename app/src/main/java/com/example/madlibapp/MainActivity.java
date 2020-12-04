package com.example.madlibapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MadLib madLib;
    TextInputLayout[] textFields;
    LinearLayout layout;
    Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateButton = (Button) findViewById(R.id.generateButton);
        layout = (LinearLayout) findViewById(R.id.layout);
        generateButton.setOnClickListener(v -> onGenerate());
        setTemplate(MadLibTemplate.DATING_BIO);
        setupFields();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int tinderBioId = R.id.tinderBio;
        final int dinnertimeId = R.id.dinnertime;
        switch (item.getItemId()) {
            case tinderBioId:
                loadTemplate(MadLibTemplate.DATING_BIO);
                break;
            case dinnertimeId:
                loadTemplate(MadLibTemplate.DINNERTIME);
                break;
            default:
                loadTemplate(MadLibTemplate.BLEH);
        }
        return super.onOptionsItemSelected(item);
    }

    void loadTemplate(MadLibTemplate template) {
        setTemplate(template);
        setupFields();
    }

    void onGenerate() {
        Intent intent = new Intent(MainActivity.this, MadLibDisplay.class);
        intent.putExtra("MadLib", madLib);
        startActivity(intent);
    }

    void setTemplate(MadLibTemplate template) {
        this.madLib = new MadLib(template);
    }

    void setupFields() {
        layout.removeAllViewsInLayout();
        ArrayList<TextInputLayout> editTexts = new ArrayList<>();
        String[] partsOfSpeech = madLib.template.partsOfSpeech;
        for (int i = 0; i < partsOfSpeech.length; i++) {
            String partOfSpeech = partsOfSpeech[i];
            TextInputLayout inputLayout = new TextInputLayout(layout.getContext());
            inputLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            TextInputEditText editText = new TextInputEditText(inputLayout.getContext());
            int finalI = i;
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    madLib.blanks[finalI] = s.toString().trim();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            editText.setInputType(TextInputEditText.AUTOFILL_TYPE_TEXT);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            inputLayout.addView(editText, params);
            inputLayout.setHint(partOfSpeech);
            layout.addView(inputLayout);
            editTexts.add(inputLayout);
        }
        this.textFields = editTexts.toArray(new TextInputLayout[0]);
    }
}