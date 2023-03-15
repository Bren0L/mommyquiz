package com.example.babyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;
import java.util.Arrays;
import java.util.List;

public class Quiz extends AppCompatActivity {
    private Toolbar tb;
    private TextView asksTv;
    private TextView secsTv;
    private TextView counterTv;
    private Button a1Btn;
    private Button a2Btn;
    private Button a3Btn;
    private Button a4Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        a1Btn = findViewById(R.id.btn_a1);
        a2Btn = findViewById(R.id.btn_a2);
        a3Btn = findViewById(R.id.btn_a3);
        a4Btn = findViewById(R.id.btn_a4);
        asksTv = findViewById(R.id.tv_asks);
        counterTv = findViewById(R.id.tv_ask_counter);
        secsTv = findViewById(R.id.tv_seconds);
        tb = findViewById(R.id.toolbar);
        List<String> asks = Arrays.asList("QUANTO TEMPO NORMALMENTE LEVA PRO BEBÊ NASCER?");

        a4Btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Resoult.class);
            startActivity(intent);
        });

    }
}