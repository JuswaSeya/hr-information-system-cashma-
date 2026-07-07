
package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class UnderCapacity extends AppCompatActivity {

    private Button btnBackUC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_under_capacity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.underCapacityLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            return insets;
        });

        btnBackUC = findViewById(R.id.btnBackUC);
        btnBackUC.setOnClickListener(view -> {
            Intent intent = new Intent(UnderCapacity.this, HomePage.class);
            startActivity(intent);


        });



    }
}

