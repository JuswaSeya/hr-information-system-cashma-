package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class info extends AppCompatActivity {

    private Button infobtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fab_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.infopage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        infobtnBack = findViewById(R.id.infobtnBack);
        infobtnBack.setOnClickListener(view -> {
            Intent intent = new Intent(info.this, HomePage.class);
            startActivity(intent);
        });
    }
}