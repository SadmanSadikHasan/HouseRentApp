package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Renter_Find_House extends AppCompatActivity implements View.OnClickListener {
    private EditText SearchEditText;
    private Button okButton;
    DatabaseAddressAttribute daa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__renter__find__house);

        daa = new DatabaseAddressAttribute(this);
        SQLiteDatabase sqLiteDatabase = daa.getWritableDatabase();

        SearchEditText = (EditText) findViewById(R.id.SearchId);
        okButton = (Button) findViewById(R.id.okbuttonid);

        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String search = SearchEditText.getText().toString();
        if(v.getId() == R.id.okbuttonid){
            Intent intent = new Intent(Activity_Renter_Find_House.this,renter_data_activity.class);
            startActivity(intent);

        }

    }
}
