package com.example.demo1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OwnerPage1 extends AppCompatActivity implements View.OnClickListener {
    private EditText areaET, detailET, sizeET, roomET, bathET, contactET, userET;
    private Button AddNewHouse;
    private Button MyHouse;
    DatabaseAddressAttribute daa;
    DatabaseHelper databaseHelper;
    HouseInfoDetails houseInfoDetails;
    String username;
    //String abcd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_page1);

        /*userET = (EditText)findViewById(R.id.UserName122EditText);
        areaET = (EditText)findViewById(R.id.AreaEditText);
        detailET = (EditText)findViewById(R.id.DetailEditText);
        sizeET = (EditText)findViewById(R.id.SizeEditText);
        roomET = (EditText)findViewById(R.id.RoomEditText);
        bathET = (EditText)findViewById(R.id.BathEditText);
        contactET = (EditText)findViewById(R.id.ContactEditText);*/

        daa = new DatabaseAddressAttribute(this);
        SQLiteDatabase sqLiteDatabase = daa.getWritableDatabase();
        houseInfoDetails = new HouseInfoDetails();

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase1 = databaseHelper.getWritableDatabase();

        AddNewHouse = (Button) findViewById(R.id.AddNewHouseButtonId);
        AddNewHouse.setOnClickListener(this);

        MyHouse = (Button) findViewById(R.id.MyHousesButtonId);
        MyHouse.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
        }
    }

    @Override
    public void onClick(View v) {

        /*String username = userET.getText().toString();
        String area = areaET.getText().toString();
        String detail = detailET.getText().toString();
        String size = sizeET.getText().toString();
        String room = roomET.getText().toString();
        String bath = bathET.getText().toString();
        String contact = contactET.getText().toString();*/

        if (v.getId() == R.id.AddNewHouseButtonId) {
            Intent intent = new Intent(OwnerPage1.this, activity_house_attributes.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.MyHousesButtonId) {
            Intent intent = new Intent(OwnerPage1.this,myhouse_show.class);
            startActivity(intent);
            //Cursor cursor = daa.myhouse();
            //Cursor cursor1 = databaseHelper.myhouse();
            //String usernameDB1 = databaseHelper.myhouse();

            //if(cursor.getCount() ==0){
            //there is no data
            //showData("Error", "No data Found");

            //return;
            //}
            /*StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext() /*&& cursor1.moveToNext()) {*/
            //String usernameDB1 = cursor1.getString(3);
                /*String usernameDB2 = cursor.getString(0);

                if (usernameDB2.equals(username)) {
                    stringBuffer.append("USERNAME : " + cursor.getString(0) + "\n");
                    stringBuffer.append("AREA : " + cursor.getString(1) + "\n");
                    stringBuffer.append("DETAIL_ADD : " + cursor.getString(2) + "\n");
                    stringBuffer.append("SIZE : " + cursor.getString(3) + "\n");
                    stringBuffer.append("ROOM : " + cursor.getString(4) + "\n");
                    stringBuffer.append("BATH : " + cursor.getString(5) + "\n");
                    stringBuffer.append("CONT_NO : " + cursor.getString(6) + "\n");
                    stringBuffer.append("Rent Amount : " + cursor.getString(7) + "\n\n");
                }
                showData("ResultSet", stringBuffer.toString());
            }*/

        }

    }
}

    /*public void showData(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();

    }
}*/
