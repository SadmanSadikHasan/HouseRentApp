package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_house_attributes extends AppCompatActivity implements View.OnClickListener {

    private EditText areaET,detailET,sizeET,roomET,bathET,contactET,userET;
    private Button okButton;
    DatabaseAddressAttribute daa;
    HouseInfoDetails houseInfoDetails;
    String username;
    //UserDetails userDetails;
    /*public void Username(String a){
        username = a;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_attributes);

        userET = (EditText)findViewById(R.id.UserName122EditText);
        areaET = (EditText)findViewById(R.id.AreaEditText);
        detailET = (EditText)findViewById(R.id.DetailEditText);
        sizeET = (EditText)findViewById(R.id.SizeEditText);
        roomET = (EditText)findViewById(R.id.RoomEditText);
        bathET = (EditText)findViewById(R.id.BathEditText);
        contactET = (EditText)findViewById(R.id.ContactEditText);

        okButton = (Button)findViewById(R.id.HouseInfoOkButtonId);
        okButton.setOnClickListener(this);



        daa = new DatabaseAddressAttribute(this);
        SQLiteDatabase dAdd  = daa.getWritableDatabase();
        houseInfoDetails = new HouseInfoDetails();
        //userDetails = new UserDetails();
        //mA = new MainActivity();

    }

    @Override
    public void onClick(View v) {

        String username = userET.getText().toString();
        String area = areaET.getText().toString();
        String detail = detailET.getText().toString();
        String size = sizeET.getText().toString();
        String room = roomET.getText().toString();
        String bath = bathET.getText().toString();
        String contact = contactET.getText().toString();


        if(v.getId() == R.id.HouseInfoOkButtonId){
            houseInfoDetails.setUsername(username);
            houseInfoDetails.setArea(area);
        houseInfoDetails.setDetail(detail);
        houseInfoDetails.setSize(size);
        houseInfoDetails.setRoom(room);
        houseInfoDetails.setBath(bath);
        houseInfoDetails.setContact(contact);




        long rowId = daa.insertData(houseInfoDetails);



            if(rowId == -1 ){
                //Toast.makeText(getApplicationContext(),"Row"+rowId+"is successfully inserted",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Row insertion failled",Toast.LENGTH_LONG).show();
            }else{
                //Toast.makeText(getApplicationContext(),"Row insertion failled",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Row"+rowId+"is successfully inserted",Toast.LENGTH_LONG).show();

            }
            Intent intent = new Intent(activity_house_attributes.this, AfterLogInActivity.class);
            startActivity(intent);
        }
    }
}
