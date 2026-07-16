package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hello_world.DashBoard.HomePage;

public class Off_Set extends AppCompatActivity {
private Button offsetbackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fab_off_set);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fab_off_set), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        offsetbackbtn=findViewById(R.id.offsetbackbtn);
        offsetbackbtn.setOnClickListener(view -> {
            Intent intent = new Intent (Off_Set.this, HomePage.class);
            startActivity(intent);
        });
    }
}