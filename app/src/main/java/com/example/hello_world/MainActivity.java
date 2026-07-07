package com.example.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hello_world.Query.EmployeeLogin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);




            EditText login = findViewById(R.id.login);
            EditText password = findViewById(R.id.password);
            Button continueButton = findViewById(R.id.ContinueButton);
            String hashPass =  hashCode(password.getText().toString());

            continueButton.setOnClickListener(view -> {

              boolean isSuccess =   new EmployeeLogin().login(login,hashPass,MainActivity.this);
                if (isSuccess){
                    Toast.makeText(this, "Successfully Login!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(this, "Sorry Try Again", Toast.LENGTH_SHORT).show();
                }
            });


            return insets;
        });
    }




    public String hashCode(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}