package com.example.hello_world.Query;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello_world.R;
import com.example.hello_world.dbconnection.connector;
import com.example.hello_world.models.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.transform.Result;

public class EmployeeLogin {

    private Employee emp = new Employee() ;

    public boolean login(Employee emp, Context context) {

        Connection connector = new connector(context).getConnection();
        ;
        if (connector == null) {

            return false;

        } else {
            try {
                String employeeUsername = emp.getUsername();

//                CallableStatement clst = connector.prepareCall("{call appLoginEmployee(?, ?)}");
                CallableStatement clst = connector.prepareCall("{call GetEmployee_Name(?)}");
                Log.e("Emp ID ", employeeUsername);
//                Log.e("Password ", password);
                clst.setString(1, employeeUsername);
//                clst.setString(2, password);

                ResultSet rs = clst.executeQuery();


                boolean result = rs.next();
                Log.e("Result", String.valueOf(result));
                return result;
            } catch (Exception e) {
                Log.e("SQL Connection Error", Log.getStackTraceString(e)); // full stack trace
            }
        }
        return false;
    }


    public Employee value(String emp, Context context) {

        Employee employee = new Employee();


        Connection connector = new connector(context).getConnection();

        if (connector == null) {
            return null;
        } else {
            try {
                CallableStatement clst = connector.prepareCall("{call sp_appFetchDetails(?) }");
                clst.setString(1, emp);
                ResultSet rs = clst.executeQuery();
                if (rs.next()) {

                    employee.setPosition(rs.getString("JobTitle"));
                    employee.setName(rs.getString("Name"));
                    employee.setImageByte(rs.getBytes("ProfilePicture"));
                    employee.setLeaveNumber(rs.getInt("LeaveCredits"));
                    employee.setIncidentNumber(rs.getInt("IncidentCount"));

                    return employee;
                }

            } catch (Exception e) {
                Log.e("SQL Connection Error", Log.getStackTraceString(e)); // full stack trace
            }

        }



        return null;
    }


public Employee getDetailsFromID (String emp_id, Context context){
        Employee employee = null;

    Connection connector = new connector(context).getConnection();
    if (connector == null) {
        return null;
    } else {
        try {
            CallableStatement clst = connector.prepareCall("{call getEmployeeDetails(?) }");
            clst.setString(1, emp_id);
            ResultSet rs = clst.executeQuery();

            if (rs.next()){
                employee=new Employee();
                employee.setEmpId(rs.getString("Employee_ID"));
                employee.setName(rs.getString("Fullname"));
                employee.setPosition(rs.getString("JobTitle"));
                employee.setDEPARTMENT(rs.getString("Department_Name"));
                employee.setSTATUS(rs.getString("Active"));
                employee.setImageByte(rs.getBytes("PicImages"));

            }
        } catch (Exception e) {
            Log.e("SQL Connection Error", Log.getStackTraceString(e)); // full stack trace
        }
    }
return employee;
}















 public int activeNum (Context context ) {

     try {

         Connection con = new connector(context).getConnection();

         String sql = "Select COUNT(*) as CountActive\n" +
                 " from tblHRDEmployees\n" +
                 " where Active='true'";

         PreparedStatement ps_active = con.prepareStatement(sql);
         ResultSet rs_active_num = ps_active.executeQuery();
         if (rs_active_num.next()) {

          return rs_active_num.getInt("CountActive");

         }
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
    return 0;
 }

    public ArrayList<Employee> getActiveEmployees(Context context) {

        ArrayList<Employee> list = new ArrayList<>();

        try {

            Connection con = new connector(context).getConnection();

            String sql =
                    "SELECT a.Employee_ID, a.Fullname, a.JobTitle, a.Department, a.Active, b.PicImages FROM tblHRDEmployees a LEFT JOIN tblHRDEmployeesPicture b ON b.Employee_ID = a.Employee_ID  WHERE Active = 'true'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee emp = new Employee();   // Create a new object

                emp.setEmpId(rs.getString("Employee_ID"));
                emp.setName(rs.getString("Fullname"));
                emp.setPosition(rs.getString("JobTitle"));
                emp.setDEPARTMENT(rs.getString("Department"));
                emp.setSTATUS(rs.getString("Active"));

                emp.setImageByte(rs.getBytes("PicImages"));

                list.add(emp);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Employee> searchEmployees(Context context, String keyword) {

        ArrayList<Employee> list = new ArrayList<>();



        try {

            Connection con = new connector(context).getConnection();

            String sql =
                    "SELECT a.Employee_ID, a.Fullname, a.JobTitle, a.Department, a.Active, b.PicImages " +
                            "FROM tblHRDEmployees a " +
                            "LEFT JOIN tblHRDEmployeesPicture b ON b.Employee_ID = a.Employee_ID " +
                            "WHERE a.Active = 'true' " +
                            "AND (a.Employee_ID LIKE ? OR a.Fullname LIKE ? )";
            PreparedStatement ps = con.prepareStatement(sql);

            String search = "%" + keyword + "%";

            ps.setString(1, search);
            ps.setString(2, search);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee emp = new Employee();   // Create a new object

                emp.setEmpId(rs.getString("Employee_ID"));
                emp.setName(rs.getString("Fullname"));
                emp.setPosition(rs.getString("JobTitle"));
                emp.setDEPARTMENT(rs.getString("Department"));
                emp.setSTATUS(rs.getString("Active"));
                emp.setImageByte(rs.getBytes("PicImages"));

                list.add(emp);



            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            Log.e("SQL Error", Log.getStackTraceString(e));
        }

        return list;
    }
}




