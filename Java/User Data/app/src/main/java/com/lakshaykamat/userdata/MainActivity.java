package com.lakshaykamat.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usrName;
    private EditText usrPassword;
    private EditText usrEmail;
    private EditText usrPhone;
    private RadioGroup radioSexGroup;

    //key for intent (key for accessing all values)
    public static final String EXTRA_NAME = "com.lakshaykamat.extra.name";
    public static final String EXTRA_PASSWORD = "com.lakshaykamat.extra.password";
    public static final String EXTRA_EMAIL = "com.lakshaykamat.extra.email";
    public static final String EXTRA_PHONE = "com.lakshaykamat.extra.phone";
    public static final String EXTRA_SEX = "com.lakshaykamat.extra.sex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usrName = findViewById(R.id.usrName);
        usrPassword = findViewById(R.id.usrPassword);
        usrEmail = findViewById(R.id.usrEmail);
        usrPhone = findViewById(R.id.usrPhone);
        //Radio Button Group
       radioSexGroup = findViewById(R.id.radioSex);
    }
    public void openingSecondActivity(View view){
        //storing the id of every chosen radio button
        int selectedSex = radioSexGroup.getCheckedRadioButtonId();
        //creating the button instance by his id for getting his text
        RadioButton radioSexButton = (RadioButton) findViewById(selectedSex);

        //grabbing the text from all inputs
        String name = usrName.getText().toString();
        String password = usrPassword.getText().toString();
        String email = usrEmail.getText().toString();
        String phone = usrPhone.getText().toString();

        //if user didn't fill any data in input filed show error
        if(name.equals("")){
            usrName.setError("Please Enter your name");
            return;
        }else if(password.equals("")){
            usrPassword.setError("Please enter your password");
            return;
        }else if(email.equals("")){
            usrEmail.setError("Please enter your email");
            return;
        }else if(phone.equals("")){
            usrPhone.setError("Please Enter your phone number");
            return;
        }else if(selectedSex <=0){
            Toast.makeText(this, "Choose any one", Toast.LENGTH_SHORT).show();
            return;
        }

        //A Toast
        Toast.makeText(MainActivity.this, "Your Data has been Submitted", Toast.LENGTH_SHORT).show();


        //creating a intent
        //needs two arguments one (this) current location and destination
        Intent intent = new Intent(this,StoredData.class);
        //passing some values and keys to intent so we can see on next screen
        //needs two arguments key and value
        intent.putExtra(EXTRA_NAME,name);
        intent.putExtra(EXTRA_PASSWORD,password);
        intent.putExtra(EXTRA_EMAIL,email);
        intent.putExtra(EXTRA_PHONE,phone);
        intent.putExtra(EXTRA_SEX,radioSexButton.getText());
        //starting new activity or new screen
        startActivity(intent);
    }

}