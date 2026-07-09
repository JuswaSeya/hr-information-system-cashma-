package com.example.hello_world.Query;

import android.content.Context;
import android.util.Log;

import com.example.hello_world.dbconnection.connector;
import com.example.hello_world.models.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class EmployeeLogin {

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

 public Employee value (String emp,Context context){

        Employee employee = new Employee();


        Connection connector = new connector(context).getConnection();

        if(connector == null ){
            return null;
        }
        else {
            try {
                CallableStatement clst = connector.prepareCall("{call sp_appFetchDetails(?) }");
                clst.setString(1, emp);
                ResultSet rs = clst.executeQuery();
                if (rs.next()){

                    employee.setPosition(rs.getString("JobTitle"));
                    employee.setName( rs.getString("Name"));
                    employee.setImageByte(rs.getBytes("ProfilePicture"));
                    return employee;
                }

            }catch (Exception e) {
                Log.e("SQL Connection Error", Log.getStackTraceString(e)); // full stack trace
            }

        }



        return null;
 }

}




