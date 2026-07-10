package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello_world.Query.EmployeeLogin;
import com.example.hello_world.adapter.EmployeeAdapter;
import com.example.hello_world.models.forActiveEmployees;

import java.util.ArrayList;

public class ActiveEmployee extends AppCompatActivity {

    private Button btnbackActiveEmployee;
    private EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_active_employee);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            RecyclerView recyclerView = findViewById(R.id.recyclerEmployees);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            EmployeeLogin dao = new EmployeeLogin();

            ArrayList<forActiveEmployees> list = dao.getActiveEmployees(this);

            EmployeeAdapter adapter = new EmployeeAdapter(this, list);

            recyclerView.setAdapter(adapter);

            btnbackActiveEmployee = findViewById(R.id.btnBackUC3);
            btnbackActiveEmployee.setOnClickListener(view -> {
                Intent intent = new Intent(ActiveEmployee.this, HomePage.class);
                startActivity(intent);
            });




            return insets;
        });
    }
}