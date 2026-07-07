package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class obtfiledtoday extends AppCompatActivity {
private Button obtbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obtfiledtoday);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.obtfiledtodaypage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        obtbtnBack=findViewById(R.id.obtbtnBack);
        obtbtnBack.setOnClickListener(view -> {
            Intent intent = new Intent(obtfiledtoday.this, HomePage.class);
            startActivity(intent);
        });
    }
    }