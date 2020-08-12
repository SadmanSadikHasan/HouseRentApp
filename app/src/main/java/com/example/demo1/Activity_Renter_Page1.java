package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Renter_Page1 extends AppCompatActivity implements View.OnClickListener {

    private Button searchforhouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_page1);

        searchforhouse = (Button) findViewById(R.id.SearchforHouseid);
        searchforhouse.setOnClickListener( this);

            }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.SearchforHouseid){
            Intent intent = new Intent(Activity_Renter_Page1.this, Activity_Renter_Find_House.class);
            startActivity(intent);
        }
    }
}



