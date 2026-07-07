package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class incident_report extends AppCompatActivity {

    private Button incidentbackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_incident_report);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.IncidentReport), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);



            Button button = findViewById(R.id.incidentbackbtn);
            button.setOnClickListener(view -> {
                Intent intent = new Intent(incident_report.this, HomePage.class);
                startActivity(intent);

            });

            return insets;
        });
    }
}