package com.example.hello_world.DashBoard.ActiveEmployee;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
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

public class employee_details extends AppCompatActivity {
private Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //set content view name ng layout
        setContentView(R.layout.active_employee_details);
        //id layout yung view compat
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.employeeDetailsLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);





            return insets;
        });
        TextView empid = findViewById(R.id.txtEmpID);                                                   //TextView nameYouWant = findViewById(R.id.idngkungsaangusto mo lagyan ng data


        TextView name = findViewById(R.id.txtName);
        TextView position = findViewById(R.id.txtPosition);
        TextView department = findViewById(R.id.txtDepartment);
        TextView status = findViewById(R.id.txtStatus);
        ImageView profilePic = findViewById(R.id.imgEmployee);
        String EMP_ID="";

        if (getIntent() !=null && getIntent().hasExtra("EMP_ID")){
            EMP_ID= getIntent().getStringExtra("EMP_ID");


         employee = new EmployeeSqlQuery().getDetailsFromID(EMP_ID,this);
            Toast.makeText(this, "name: "+employee.getName(), Toast.LENGTH_SHORT).show();

        }



        empid.setText(EMP_ID);                                                                              //you need to call the name of that textview
        name.setText(employee.getName());
        position.setText(employee.getPosition());
        department.setText((employee.getDEPARTMENT()));
        status.setText(employee.getSTATUS());


        if (employee.getImageByte() != null && employee.getImageByte().length > 0) {

            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    employee.getImageByte(),
                    0,
                    employee.getImageByte().length
            );

            profilePic.setImageBitmap(bitmap);

        } else {

            profilePic.setImageResource(R.drawable.profile);

        }




    }

}