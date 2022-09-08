package com.lakshaykamat.formapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //@SuppressLint("SetTextI18n")
    public void onBtnClick(View view){
        //On Click event
       TextView txtEmail = findViewById(R.id.emailView);
       TextView txtPhone = findViewById(R.id.passView);
       TextView txtPass = findViewById(R.id.phoneView);

       EditText emailInput = findViewById(R.id.usrEmail);
       EditText passInput = findViewById(R.id.usrPassword);
       EditText phoneInput = findViewById(R.id.usrPhone);

        txtEmail.setText(emailInput.getText().toString());
       txtPhone.setText(phoneInput.getText().toString());
       txtPass.setText(passInput.getText().toString());
        Toast.makeText(MainActivity.this,"SUBMITTED!",Toast.LENGTH_SHORT).show();
    }
}