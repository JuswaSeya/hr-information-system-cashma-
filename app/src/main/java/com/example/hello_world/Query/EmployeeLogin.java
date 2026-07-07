package com.example.hello_world.Query;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.example.hello_world.dbconnection.connector;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class EmployeeLogin {

    public boolean login (EditText username, String password, Context context) {

       Connection connector =new connector(context).getConnection();;
        if (connector == null){

            return false;

        }
        else {
            try {
                String employeeUsername= username.getText().toString();

//                CallableStatement clst = connector.prepareCall("{call appLoginEmployee(?, ?)}");
                CallableStatement clst = connector.prepareCall("{call GetEmployee_Name(?)}");
                Log.e("Emp ID ", employeeUsername);
//                Log.e("Password ", password);
                clst.setString(1, employeeUsername);
//                clst.setString(2, password);

                ResultSet rs = clst.executeQuery();





                    boolean result = rs.next();
                Log.e("Result" , String.valueOf(result) );
                    return result;
            }
            catch(Exception e){
                Log.e("SQL Connection Error", Log.getStackTraceString(e)); // full stack trace
            }
                }
    return false;
    }

}
