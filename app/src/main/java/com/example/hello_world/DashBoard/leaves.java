package com.example.hello_world.DashBoard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hello_world.Query.EmployeeSqlQuery;
import com.example.hello_world.R;
import com.example.hello_world.models.Employee;


public class leaves extends AppCompatActivity {
    private String employeeID;
    private Employee employee;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaves);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.leavesPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

String SlCount= "";
        if (getIntent() !=null && getIntent().hasExtra("SlCount")){
            SlCount= getIntent().getStringExtra("SlCount");


            employee = new EmployeeSqlQuery().getDetailsFromID(SlCount,this);
            Toast.makeText(this, "name: "+employee.getName(), Toast.LENGTH_SHORT).show();

        }




        SharedPreferences prefs = getSharedPreferences("UserSession", MODE_PRIVATE);
        employeeID = prefs.getString("emp_id", null);
        Button backBtn = findViewById(R.id.leavesBackbtn);
        Intent intent = new Intent(leaves.this, HomePage.class);
        backBtn.setOnClickListener(v -> startActivity(intent));

        TextView numLeaves = findViewById(R.id.txtLeaveCount);

        EmployeeSqlQuery employeeLeaves = new EmployeeSqlQuery();






        }



    }

    //for leaves number display




