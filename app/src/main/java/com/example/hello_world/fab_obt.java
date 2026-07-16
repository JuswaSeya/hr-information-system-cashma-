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

public class fab_obt extends AppCompatActivity {
private Button ObtBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fab_obt);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.obtScrollView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ObtBtnCancel=findViewById(R.id.ObtBtnCancel);
        ObtBtnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(fab_obt.this, HomePage.class);
            startActivity(intent);
        });

    }
}