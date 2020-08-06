package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterLogInActivity extends AppCompatActivity implements View.OnClickListener {

    private Button LogOutButton;
    private Button OwnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log_in);

        LogOutButton = (Button) findViewById(R.id.LogOutButtonId);
        LogOutButton.setOnClickListener(this);

        OwnerButton = (Button) findViewById(R.id.OwnerButtonId);
        OwnerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.LogOutButtonId){
            Intent intent = new Intent(AfterLogInActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.OwnerButtonId){
            Intent intent = new Intent(AfterLogInActivity.this,OwnerPage1.class);
            startActivity(intent);
        }
    }
}
