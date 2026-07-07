package com.example.hello_world;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class fab_leave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fab_leave); // Make sure this matches your XML filename

        // Initialize your views here
        // Remove any ViewCompat.setOnApplyWindowInsetsListener calls
        // or ensure the view exists before using it

        // Example of safely initializing a view:
        TextView tvDaysTotal = findViewById(R.id.tvDaysTotal);
        if (tvDaysTotal != null) {
            tvDaysTotal.setText("3");
        }


    }
}