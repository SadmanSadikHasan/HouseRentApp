package com.example.demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userdetails.db";
    private static final String TABLE_NAME = "user_details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    public static final int VERSION_NUMBER = 2;
    private Context context;
    String username;


    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) NOT NULL, "+EMAIL+" TEXT NOT NULL, "+USERNAME+" TEXT NOT NULL, "+PASSWORD+" TEXT NOT NULL);";
    public static final String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);

        }catch (Exception e){
            System.out.println(e);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch (Exception e){
            System.out.println(e);

        }

    }

    public long insertData(UserDetails userDetails){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USERNAME,userDetails.getUsername());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowId = db.insert(TABLE_NAME,null, contentValues);
        return rowId;
    }

    public Boolean findpassword(String uname, String pass){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result = false;

        if(cursor.getCount() == 0){
            Toast.makeText(context,"No data is found",Toast.LENGTH_LONG).show();
        }
        else{

            while (cursor.moveToNext()){
                 username = cursor.getString(3);
                String password = cursor.getString(4);

                if(username.equals(uname) && password.equals(pass)){
                    result = true;
                    break;
                }
            }
        }
        return result;

    }

    /*public String myhouse(){
        //SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(Select_All,null);
        //Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        System.out.println(username);
        return username;
    }*/
}
