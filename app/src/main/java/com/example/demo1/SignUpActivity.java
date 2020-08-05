package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, emailEditText,usernameEditText,passwordEditText;
    private Button SignUpButton;
    UserDetails userDetails;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.SignUpNameEditText);
        emailEditText = (EditText) findViewById(R.id.SignUpEmailEditText);
        usernameEditText = (EditText) findViewById(R.id.SignUpUsernameEditText);
        passwordEditText = (EditText) findViewById(R.id.SignUpPasswordEditText);

        SignUpButton = (Button) findViewById(R.id.SignUpButtonId1);
        SignUpButton.setOnClickListener(this);

        userDetails = new UserDetails();
        db = new DatabaseHelper(this);

    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = db.insertData(userDetails);

        if(rowId > 0){
            Toast.makeText(getApplicationContext(),"Row"+rowId+"is successfully inserted",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Row insertion failled",Toast.LENGTH_LONG).show();

        }
    }
}
