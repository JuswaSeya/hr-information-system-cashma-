package com.example.hello_world.DashBoard.ActiveEmployee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello_world.DashBoard.HomePage;
import com.example.hello_world.Query.EmployeeSqlQuery;
import com.example.hello_world.R;
import com.example.hello_world.adapter.EmployeeAdapter;
import com.example.hello_world.models.Employee;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ActiveEmployee extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private EmployeeSqlQuery dao;


    private TextInputEditText etSearch;
    private MaterialButton btnSearch;



                                                                                                            //    private Button btnBackUC3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_employee);
        android.util.Log.d("ACTIVE", "ActiveEmployee opened");
        recyclerView = findViewById(R.id.recyclerEmployees);
        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dao = new EmployeeSqlQuery();
        dao = new EmployeeSqlQuery();
                                                                                                                        // thread to show
        new Thread(() -> {

            ArrayList<Employee> list = dao.getActiveEmployees(ActiveEmployee.this);
            android.util.Log.d("EMPLOYEE", "Size = " + list.size());
            runOnUiThread(() -> {
                adapter = new EmployeeAdapter(ActiveEmployee.this, list);
                recyclerView.setAdapter(adapter);
            });

        }).start();

//for search button
        btnSearch.setOnClickListener(v -> {

            new Thread(() -> {

                String keyword = etSearch.getText().toString().trim();

                ArrayList<Employee> result;

                if (keyword.isEmpty()) {
                    result = dao.getActiveEmployees(ActiveEmployee.this);
                } else {
                    result = dao.searchEmployees(ActiveEmployee.this, keyword);
                }

                runOnUiThread(() -> {
                    adapter.updateList(result);
                });

            }).start();


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