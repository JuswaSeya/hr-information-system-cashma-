package com.example.hello_world.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello_world.R;
import com.example.hello_world.models.Employee;
import com.example.hello_world.models.forActiveEmployees;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private Context context;
    private ArrayList<forActiveEmployees> employeeList;

    public EmployeeAdapter(Context context, ArrayList<forActiveEmployees> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_employee, parent, false);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        forActiveEmployees employee = employeeList.get(position);

        holder.txtEmpID.setText(employee.getEMP_ID());
        holder.txtName.setText(employee.getEMP_NAME());
        holder.txtDepartment.setText(employee.getDEPARTMENT());
        holder.txtPosition.setText(employee.getPOSITION());
        holder.txtStatus.setText(employee.getSTATUS());

        // Default profile picture
        holder.imgProfile.setImageResource(R.drawable.profile);

        // If your Employee model has a photo path or URL,
        // you can load it here using Glide or Picasso.
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;

        TextView txtEmpID;
        TextView txtName;
        TextView txtDepartment;
        TextView txtPosition;
        TextView txtStatus;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);

            txtEmpID = itemView.findViewById(R.id.txtEmpID);
            txtName = itemView.findViewById(R.id.txtName);
            txtDepartment = itemView.findViewById(R.id.txtDepartment);
            txtPosition = itemView.findViewById(R.id.txtPosition);
            txtStatus = itemView.findViewById(R.id.txtStatus);
        }
    }
}