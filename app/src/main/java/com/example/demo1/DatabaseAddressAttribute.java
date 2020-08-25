package com.example.demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseAddressAttribute extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AddressAttribute.db";
    private static final String TABLE_NAME = "address_details";
    private static final String USERNAME = "Username";
    private static final String AREA = "Area";
    private static final String DETAIL_ADD = "Detail_Add";
    private static final String SIZE = "Size";
    private static final String ROOM = "Room";
    private static final String BATH = "Bath";
    private static final String CONT_NO = "Cont_No";
    private static final String RENT_AMOUNT = "Rent";
    public static final int VERSION_NUMBER = 6;

    UserDetails userDetails;

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+USERNAME+" TEXT NOT NULL, "+AREA+" VARCHAR(255) NOT NULL, "+DETAIL_ADD+" VARCHAR(1000) NOT NULL, "+SIZE+" TEXT NOT NULL, "+ROOM+" TEXT NOT NULL,"+BATH+" TEXT NOT NULL, "+CONT_NO+" TEXT NOT NULL, "+RENT_AMOUNT+" TEXT NOT NULL);";
    public static final String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;
    //public static final String Select_All = " SELECT * FROM " + TABLE_NAME;


    private Context context;
    public DatabaseAddressAttribute(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context,"OnCreate ", Toast.LENGTH_LONG).show();
            db.execSQL(CREATE_TABLE);

        }catch (Exception e){
            Toast.makeText(context,"Exception : "+ e, Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context,"OnUpgrade ", Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch (Exception e){
            Toast.makeText(context,"Exception : "+ e, Toast.LENGTH_LONG).show();

        }
    }

    public long insertData(HouseInfoDetails houseInfoDetails){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USERNAME,houseInfoDetails.getUsername());
        contentValues.put(AREA,houseInfoDetails.getArea());
        contentValues.put(DETAIL_ADD,houseInfoDetails.getDetail());
        contentValues.put(SIZE,houseInfoDetails.getSize());
        contentValues.put(ROOM,houseInfoDetails.getRoom());
        contentValues.put(BATH,houseInfoDetails.getBath());
        contentValues.put(CONT_NO,houseInfoDetails.getContact());
        contentValues.put(RENT_AMOUNT,houseInfoDetails.getRent());

        long rowId = db.insert(TABLE_NAME,null, contentValues);
        return rowId;

    }

    public Cursor myhouse(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(Select_All,null);
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        return cursor;
    }
    public Cursor showAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(Select_All,null);
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        return cursor;


    }

}
