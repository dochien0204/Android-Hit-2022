package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateAccountShow extends AppCompatActivity {


    TextView tvFullName, tvEmailPhone, tvPass, tvConfirmPass;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_show);

        findID();

        showCreateData();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccountShow.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void findID()
    {
        tvFullName = findViewById(R.id.fullNameShow);
        tvEmailPhone = findViewById(R.id.userShow);
        tvPass = findViewById(R.id.passShow);
        tvConfirmPass = findViewById(R.id.confirmShow);
        back = findViewById(R.id.back);
    }

    public void showCreateData()
    {
        Intent intent = getIntent();
        String fullNameShow = intent.getStringExtra("fullName");
        String userShow = intent.getStringExtra("emailPhone");
        String passwordShow = intent.getStringExtra("password");
        String confirmShow = intent.getStringExtra("confirm");

        tvFullName.setText("Full Name : " + fullNameShow);
        tvEmailPhone.setText("User : " + userShow);
        tvPass.setText("Password : " + passwordShow);
        tvConfirmPass.setText("Confirm Password : " + confirmShow);
    }
}