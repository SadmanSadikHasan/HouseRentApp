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
    String area;
    DatabaseAddressAttribute daa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_data);

        listView = (ListView) findViewById(R.id.listviewid);
        daa = new DatabaseAddressAttribute(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            area = bundle.getString("area");
        }

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
                String areaDB = cursor.getString(1);
                if(areaDB.equals(area)){
                    //listData.add(cursor.getString(0)+" \n" +cursor.getString(1) + " \n" +cursor.getString(2)+ " \n" +cursor.getString(3)+ " \n" +cursor.getString(4)+ " \n" +cursor.getString(5)+ " \n" +cursor.getString(6));
                    listData.add("USERNAME : " + cursor.getString(0));
                    listData.add("AREA : " + cursor.getString(1));
                    listData.add("DETAIL_ADD : " + cursor.getString(2));
                    listData.add("SIZE : " + cursor.getString(3));
                    listData.add("ROOM : " + cursor.getString(4));
                    listData.add("BATH : " + cursor.getString(5));
                    listData.add("CONT_NO : " + cursor.getString(6)+ "\n\n");
                }

            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item, R.id.textviewid, listData);
        listView.setAdapter(adapter);


    }
}
