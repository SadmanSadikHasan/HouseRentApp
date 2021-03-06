package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper databaseHelper;
    //activity_house_attributes activity_house_attributes;

    private Button SignInButton, SignUpButton;
    private EditText UsernameEditText;
    private EditText PasswordEditText;
    //public String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignInButton = (Button) findViewById(R.id.SignInButtonId);
        SignUpButton = (Button) findViewById(R.id.SignUpButtonId);

        UsernameEditText = (EditText) findViewById(R.id.SignInUsernameEditTextId);
        PasswordEditText = (EditText) findViewById(R.id.SignInPasswordEditTextId);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db =  databaseHelper.getWritableDatabase();


        SignInButton.setOnClickListener(this);
        SignUpButton.setOnClickListener(this);

        //activity_house_attributes = new activity_house_attributes();
    }


    @Override
    public void onClick(View v) {

        String username = UsernameEditText.getText().toString();
        String password = PasswordEditText.getText().toString();

        //a = UsernameEditText.getText().toString();
        //activity_house_attributes.Username(a);

        if(v.getId() == R.id.SignInButtonId){

            Boolean result = databaseHelper.findpassword(username,password);
            if(result == true){

                Intent intent = new Intent(MainActivity.this,AfterLogInActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);

            }else{
                Toast.makeText(getApplicationContext(),"username and password didn't match",Toast.LENGTH_LONG).show();
            }

        }

        else if(v.getId() == R.id.SignUpButtonId){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

    }
}
