package com.example.onlinebakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

enum UserType {
    CUSTOMER,
    CONFECTIONER,
    ADMIN
}

public class LoginActivity extends AppCompatActivity {

    TextView text_view_create_account;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call Login function

                // check user type
                UserType userType = UserType.CUSTOMER;
                if (userType == UserType.CUSTOMER) {
                    // if user was a customer
                    Intent intent = new Intent(LoginActivity.this, CustomerMainActivity.class);
                    startActivity(intent);
                    finish();
                }

                if (userType == UserType.CONFECTIONER) {
                    // if user was a confectioner
//                    Intent intent = new Intent(LoginActivity.this, BakerMainActivity.class);
//                    startActivity(intent);
//                    finish();
                }

                if (userType == UserType.ADMIN) {
                    // if user was an admin
//                    Intent intent = new Intent(LoginActivity.this, AdminMainActivity.class);
//                    startActivity(intent);
//                    finish();
                }
            }
        });


        text_view_create_account = findViewById(R.id.text_view_create_account);
        text_view_create_account.setClickable(true);
        text_view_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // got to activity register.
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
