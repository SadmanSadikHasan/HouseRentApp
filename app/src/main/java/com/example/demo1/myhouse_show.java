package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class myhouse_show extends AppCompatActivity {
    private ListView listView1;
    String area;
    DatabaseAddressAttribute daa;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhouse_show);

        listView1 = (ListView) findViewById(R.id.listviewid1);
        daa = new DatabaseAddressAttribute(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
        }

        loadData();

    }



    public void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = daa.showAllData();

        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No data is available in database", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                String usernameDB = cursor.getString(0);
                if (usernameDB.equals(username)) {
                    //listData.add(cursor.getString(0)+" \n" +cursor.getString(1) + " \n" +cursor.getString(2)+ " \n" +cursor.getString(3)+ " \n" +cursor.getString(4)+ " \n" +cursor.getString(5)+ " \n" +cursor.getString(6));
                    listData.add("USERNAME : " + cursor.getString(0));
                    listData.add("AREA : " + cursor.getString(1));
                    listData.add("DETAIL_ADD : " + cursor.getString(2));
                    listData.add("SIZE : " + cursor.getString(3));
                    listData.add("ROOM : " + cursor.getString(4));
                    listData.add("BATH : " + cursor.getString(5));
                    listData.add("CONT_NO : " + cursor.getString(6) );
                    listData.add("Rent Amount : " + cursor.getString(7) + "\n\n");
                }

            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textviewid, listData);
        listView1.setAdapter(adapter);
    }
}

