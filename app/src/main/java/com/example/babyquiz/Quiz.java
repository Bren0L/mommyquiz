package com.example.babyquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz extends AppCompatActivity {
    private Toolbar tb;
    private TextView asksTv;
    private TextView secsTv;
    private TextView counterTv;
    private Button a1Btn;
    private Button a2Btn;
    private Button a3Btn;
    private Button a4Btn;
    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        firebaseFirestore = FirebaseFirestore.getInstance();

        a1Btn = findViewById(R.id.btn_a1);
        a2Btn = findViewById(R.id.btn_a2);
        a3Btn = findViewById(R.id.btn_a3);
        a4Btn = findViewById(R.id.btn_a4);
        asksTv = findViewById(R.id.tv_asks);
        counterTv = findViewById(R.id.tv_ask_counter);
        secsTv = findViewById(R.id.tv_seconds);
        tb = findViewById(R.id.toolbar);
        Map<String, Object> users = new HashMap<>();
        users.put("firstName", "Breno");
        users.put("lastName", "Macedo");
        users.put("age", 20);

        firebaseFirestore.collection("users").add(users).addOnSuccessListener(l -> Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(l -> Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show());


        a4Btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Resoult.class);
            startActivity(intent);
        });

    }
}