package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    TextView error;
    Button login;
    Button create;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userSent = user.getText().toString();
                String passSent = password.getText().toString();

                if(userSent.compareTo("") == 0 || passSent.compareTo("")== 0)
                {
                    error.setText("Invalid Login");
                }
                else {
                    byExtras(userSent,passSent);
                }

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });
    }



    public void findId()
    {
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        create = findViewById(R.id.create);
        error = findViewById(R.id.error);
    }

    public void byExtras(String user, String password)
    {
        Intent intent = new Intent(MainActivity.this, LoginShow.class);
        intent.putExtra("userSent", user);
        intent.putExtra("passSent", password);
        startActivity(intent);
    }

    public void CreateAccount()
    {
        Intent intent = new Intent(MainActivity.this, CreateForm.class);
        startActivity(intent);
    }
}