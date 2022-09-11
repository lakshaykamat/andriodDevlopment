package com.lakshaykamat.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StoredData extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stored_data);

        //Grabbing elements from their id's
        TextView showName = findViewById(R.id.showName);
        TextView showPass = findViewById(R.id.showPass);
        TextView showEmail = findViewById(R.id.showEmail);
        TextView showPhone = findViewById(R.id.showPhone);
        TextView showSex = findViewById(R.id.showSex);
        //getting intent value
        Intent intent = getIntent();
        //storing  value to variable
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String password = intent.getStringExtra(MainActivity.EXTRA_PASSWORD);
        String email = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        String phone = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        String sex = intent.getStringExtra(MainActivity.EXTRA_SEX);
        //setting value to text
        showName.setText("Name: " + name);
        showPass.setText("Password: " + password);
        showEmail.setText("Email: " + email);
        showPhone.setText("Phone: " + phone);
        showSex.setText("Sex: " + sex);
    }
}