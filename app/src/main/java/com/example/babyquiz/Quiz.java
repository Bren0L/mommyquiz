package com.example.babyquiz;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz extends AppCompatActivity {
    private Toolbar tb;
    private TextView asks;
    private TextView secs;
    private TextView counter;
    private Button opt1;
    private Button opt2;
    private Button opt3;
    private Button opt4;
    private FirebaseFirestore firebaseFirestore;
    private byte aksNumber = 0;
    private byte askCounter = 20;
    private Timer timer;
    private byte askNumber = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        firebaseFirestore = FirebaseFirestore.getInstance();

        opt1 = findViewById(R.id.btn_opt1);
        opt2 = findViewById(R.id.btn_opt2);
        opt3 = findViewById(R.id.btn_opt3);
        opt4 = findViewById(R.id.btn_opt4);
        asks = findViewById(R.id.tv_asks);
        counter = findViewById(R.id.tv_ask_counter);
        secs = findViewById(R.id.tv_seconds);
        tb = findViewById(R.id.toolbar);

        secs.setText(""+askCounter);
        counter.setText("Pergunta "+askNumber);


        firebaseFirestore.collection("perguntas").document("1").get().addOnCompleteListener(task -> {
            Map<String, Object> quiz = task.getResult().getData();

            asks.setText(quiz.get("pergunta1").toString());
            opt1.setText(quiz.get("q1").toString());
            opt2.setText(quiz.get("q2").toString());
            opt3.setText(quiz.get("q3").toString());
            opt4.setText(quiz.get("q4").toString());
        });


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (this) {
                    runOnUiThread(() -> {
                        if(askCounter == 0){
                            disableAllButtons();
                            timer.cancel();
                        } else
                            secs.setText("" + --askCounter);
                    });
                }}}, 1000, 1000);


        opt1.setOnClickListener(v -> {
            disableAllButtons();
            timer.cancel();
            verifyAnswer(v, opt1);
        });

        opt2.setOnClickListener(v ->{
            disableAllButtons();
            timer.cancel();
            verifyAnswer(v, opt2);
        });

        opt3.setOnClickListener(v -> {
            disableAllButtons();
            timer.cancel();
            verifyAnswer(v, opt3);
        });

        opt4.setOnClickListener(v -> {
            disableAllButtons();
            timer.cancel();
            Intent intent = new Intent(this, Result.class);
            startActivity(intent);
            finish();
        });

    }



    private void disableAllButtons() {
        opt1.setEnabled(false);
        opt2.setEnabled(false);
        opt3.setEnabled(false);
        opt4.setEnabled(false);
    }

    private void verifyAnswer(View v, Button btn){
        if(v.getId() == R.id.btn_opt1) {
            btn.setTextColor(Color.parseColor("#00FF00"));
            btn.append(" \u2713");
        }else{
            btn.setTextColor(Color.parseColor("#FF0000"));
            btn.append(" \u274C");
        }
    }
}