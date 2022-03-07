package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginShow extends AppCompatActivity {

    TextView tvUser;
    TextView tvPass;
    Button backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_show);

        findID();
        show();
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backLogin = new Intent(LoginShow.this, MainActivity.class);
                startActivity(backLogin);
            }
        });

    }

    public void show()
    {
        Intent intent = getIntent();
        String userShow = intent.getStringExtra("userSent");
        String passShow = intent.getStringExtra("passSent");


        tvUser.setText("Username : "+ userShow);
        tvPass.setText("Password : " + passShow);
    }
    public void findID()
    {
        tvUser = findViewById(R.id.userShow);
        tvPass = findViewById(R.id.passShow);
        backk = findViewById(R.id.back);
    }
}