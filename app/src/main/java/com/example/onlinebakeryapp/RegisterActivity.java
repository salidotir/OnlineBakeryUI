package com.example.onlinebakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegisterBaker;
    Button btnRegisterCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Customer
        btnRegisterCustomer = findViewById(R.id.btnRegisterCustomer);
        btnRegisterCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call register function

                // if user was a customer
                Intent intent = new Intent(RegisterActivity.this, CustomerMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Baker
        btnRegisterBaker = findViewById(R.id.btnRegisterBaker);
        btnRegisterBaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(RegisterActivity.this, BakerMainActivity.class);
//                startActivity(intent);
//                finish();
            }
        });

    }
}
