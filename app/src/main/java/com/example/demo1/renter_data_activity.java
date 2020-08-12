package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class renter_data_activity extends AppCompatActivity {
    private ListView listView;
    DatabaseAddressAttribute daa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_data);

        listView = (ListView) findViewById(R.id.listviewid);
        daa = new DatabaseAddressAttribute(this);

        loadData();
    }

    public void loadData(){
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = daa.showAllData();

        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No data is available in database", Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()) {
                listData.add(cursor.getString(0)+" \n" +cursor.getString(1) + " \n" +cursor.getString(2)+ " \n" +cursor.getString(3)+ " \n" +cursor.getString(4)+ " \n" +cursor.getString(5)+ " \n" +cursor.getString(6));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, R.id.textviewid, listData);
        listView.setAdapter(adapter);


    }
}
