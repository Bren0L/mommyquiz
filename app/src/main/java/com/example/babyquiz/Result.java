package com.example.babyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private Button closeBtn;
    private TextView numberMistakes;
    private TextView mistakeText;
    private TextView numberHits;
    private TextView hitsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        closeBtn = findViewById(R.id.btn_close);
        mistakeText = findViewById(R.id.tv_mistakes_text);
        numberHits = findViewById(R.id.tv_hits);
        hitsText = findViewById(R.id.tv_hits_text);
        numberMistakes = findViewById(R.id.tv_mistakes);

        closeBtn.setOnClickListener(v -> finish());

    }
}