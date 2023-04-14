package com.example.babyquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Information extends AppCompatActivity {
    private FloatingActionButton fabReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        fabReturn = findViewById(R.id.fab_return);

        fabReturn.setOnClickListener(v -> finish());
    }
}