package com.example.babyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startBtn;
    private Button infoBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.btn_start);
        infoBtn = findViewById(R.id.btn_info);

        startBtn.setOnClickListener(v -> {
            intent = new Intent(this, Quiz.class);
            startActivity(intent);
        });

        infoBtn.setOnClickListener(v -> {
            intent = new Intent(this, Information.class);
            startActivity(intent);
        });

    }
}