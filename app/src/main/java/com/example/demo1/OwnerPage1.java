package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OwnerPage1 extends AppCompatActivity implements View.OnClickListener {
    private Button AddNewHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_page1);

        AddNewHouse = (Button) findViewById(R.id.AddNewHouseButtonId);
        AddNewHouse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.AddNewHouseButtonId){
            Intent intent = new Intent(OwnerPage1.this , activity_house_attributes.class);
            startActivity(intent);
        }

    }
}
