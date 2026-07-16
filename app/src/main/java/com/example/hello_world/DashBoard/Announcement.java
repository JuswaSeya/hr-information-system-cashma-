package com.example.hello_world.DashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hello_world.R;

public class Announcement extends AppCompatActivity {
 private Button backbuttonannouncement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);


        Button button = findViewById(R.id.backbuttonannouncement);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(Announcement.this, HomePage.class);
            startActivity(intent);
            // Remove any ViewCompat.setOnApplyWindowInsetsListener calls
            // or if you have them, make sure they're removed
        });

    }




}