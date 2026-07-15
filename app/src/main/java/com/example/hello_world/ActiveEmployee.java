package com.example.hello_world;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello_world.Query.EmployeeLogin;
import com.example.hello_world.adapter.EmployeeAdapter;
import com.example.hello_world.models.Employee;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ActiveEmployee extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private EmployeeLogin dao;


    private TextInputEditText etSearch;
    private MaterialButton btnSearch;



//    private Button btnBackUC3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_employee);

        recyclerView = findViewById(R.id.recyclerEmployees);
        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dao = new EmployeeLogin();

        ArrayList<Employee> list = dao.getActiveEmployees(this);

        adapter = new EmployeeAdapter(this, list);

        recyclerView.setAdapter(adapter);

        btnSearch.setOnClickListener(v -> {

            String keyword = etSearch.getText().toString().trim();

            ArrayList<Employee> result;

            if (keyword.isEmpty()) {
                result = dao.getActiveEmployees(this);
            } else {
                result = dao.searchEmployees(this, keyword);
            }

            adapter.updateList(result);





        });
//findViewById(R.id.NameNgIdNgButton)
                Button backBtn = findViewById(R.id.btnBackUC3);
        Intent intent = new Intent(ActiveEmployee.this, HomePage.class);
        backBtn.setOnClickListener(v -> {
            startActivity(intent);
        });




//            employee= new EmployeeLogin().value(employeeID, requireContext());
//
//            LinearLayout empDetails= view.findViewById(R.id.employee_layout);
//            empDetails.setOnClickListener(v -> {
//                startActivity(ActiveEmployee.this , employee_details.class));
//            });

            return ;


}


}