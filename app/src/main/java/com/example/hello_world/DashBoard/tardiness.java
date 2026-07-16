package com.example.hello_world.DashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hello_world.R;

public class tardiness extends AppCompatActivity {

    private Button btnTardinessBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tardiness);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tardinessLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);




             Button button=findViewById(R.id.btnTardinessBack);
            button.setOnClickListener(view -> {
                Intent intent = new Intent(tardiness.this, HomePage.class);
                startActivity(intent);
            });
            return insets;
        });
    }
}