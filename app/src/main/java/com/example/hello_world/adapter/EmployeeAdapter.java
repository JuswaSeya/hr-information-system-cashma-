package com.example.hello_world.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello_world.ActiveEmployee;
import com.example.hello_world.R;
import com.example.hello_world.employee_details;
import com.example.hello_world.models.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private Context context;
    private ArrayList<Employee> employeeList;


    private employee_details employeeDetails;

//    private final OnItemActionListener listener;

    // Interface for click events
    public interface OnItemActionListener {
        void onItemClick(Employee employee);
    }

    public EmployeeAdapter(Context context,
                           ArrayList<Employee> employeeList
                     ) {

        this.context = context;
        this.employeeList = employeeList;

    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_employee, parent, false);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        Employee employee = employeeList.get(position);

        holder.txtEmpID.setText(employee.getEmpId());
        holder.txtName.setText(employee.getName());
        holder.txtDepartment.setText(employee.getDEPARTMENT());
        holder.txtPosition.setText(employee.getPosition());
        holder.txtStatus.setText(employee.getSTATUS());

holder.empDetailsdashboard.setOnClickListener(v ->
{
            Intent intent = new Intent(context, employee_details.class);


    intent.putExtra("EMP_ID", employee.getEmpId());


        context.startActivity(intent);

});



        if (employee.getImageByte() != null && employee.getImageByte().length > 0) {

            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    employee.getImageByte(),
                    0,
                    employee.getImageByte().length
            );

            holder.imgProfile.setImageBitmap(bitmap);

        } else {

            holder.imgProfile.setImageResource(R.drawable.profile);

        }

        // Click event
//        holder.itemView.setOnClickListener(v -> {
//            if (listener != null) {
//                listener.onItemClick(employee);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void updateList(ArrayList<Employee> newList) {
        employeeList.clear();
        employeeList.addAll(newList);
        notifyDataSetChanged();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView txtEmpID;
        TextView txtName;
        TextView txtDepartment;
        TextView txtPosition;
        TextView txtStatus;

LinearLayout empDetailsdashboard;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            txtEmpID = itemView.findViewById(R.id.txtEmpID);
            txtName = itemView.findViewById(R.id.txtName);
            txtDepartment = itemView.findViewById(R.id.txtDepartment);
            txtPosition = itemView.findViewById(R.id.txtPosition);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            empDetailsdashboard=itemView.findViewById(R.id.empDetailsdashboard);
        }

//        LinearLayout employeeDetails = findViewById(R.id.empDetailscard);
//        employeeDetails.setOnClickListener( v->{
//            Intent intent = new Intent (EmployeeAdapter.this, employee_details.class);
//            startActivity(intent);
//        });

    }
}