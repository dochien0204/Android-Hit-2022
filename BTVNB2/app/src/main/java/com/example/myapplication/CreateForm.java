package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateForm extends AppCompatActivity {

    EditText fullName, emailPhone, password, confirmPass;
    Button confirm, back;
    TextView tvErrorConfirm;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);

        findID();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullNameSent = fullName.getText().toString();
                String emailPhoneSent = emailPhone.getText().toString();
                String passwordSent = password.getText().toString();
                String confirmSent = confirmPass.getText().toString();

                if(fullNameSent.compareTo("") == 0 || emailPhoneSent.compareTo("") == 0 || passwordSent.compareTo("") == 0 || confirmSent.compareTo("") == 0)
                {
                    tvError.setText("Invalid Sign up");
                }
                else if (passwordSent.compareTo(confirmSent) != 0)
                {
                    tvErrorConfirm.setText("Confirm password is not same as your password");
                    tvError.setText("");
                }
                else {
                    sendData(fullNameSent, emailPhoneSent, passwordSent, confirmSent);
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateForm.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void findID() {
        fullName = findViewById(R.id.fullName);
        emailPhone = findViewById(R.id.emailPhone);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPass);
        confirm = findViewById(R.id.confirm);
        back = findViewById(R.id.back);
        tvErrorConfirm = findViewById(R.id.errorConfirm);
        tvError = findViewById(R.id.error);
    }

    public void sendData(String fullName, String emailPhone, String password, String confirmPass)
    {
        Intent intent = new Intent(CreateForm.this, CreateAccountShow.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("emailPhone", emailPhone);
        intent.putExtra("password", password);
        intent.putExtra("confirm", confirmPass);

        startActivity(intent);
    }
}

