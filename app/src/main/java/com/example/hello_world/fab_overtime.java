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

public class fab_overtime extends AppCompatActivity {


    private Button OvertimeBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fab_overtime);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.overtimepage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        OvertimeBtnCancel = findViewById(R.id.OvertimeBtnCancel);
        OvertimeBtnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(fab_overtime.this, HomePage.class);
            startActivity(intent);
        });
    }
}