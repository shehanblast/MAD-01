package com.example.vendors;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "vendor";
    private static final String TABLE_NAME = "vendor";

    //column names
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CATEGORY = "category";
    private static final String NOTE = "note";
    private static final String ESTIMATEDAMOUNT = "estimated_amount";
    private static final String NUMBER = "number";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT, "
                + CATEGORY + " TEXT, "
                + NOTE + " TEXT, "
                + ESTIMATEDAMOUNT + " TEXT, "
                + NUMBER + " TEXT, "
                + EMAIL + " TEXT, "
                + ADDRESS + " TEXT " +
                ");";


        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_TABLE_QUERY = " DROP TABLE IF EXISTS " + TABLE_NAME;
        //DROP OLDER TABLE IF EXISTED
        db.execSQL(DROP_TABLE_QUERY);
        //create again
        onCreate(db);

}

   public void addVendor(Vendor vendor){


        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, vendor.getName());
        contentValues.put(CATEGORY, vendor.getCategory());
        contentValues.put(NOTE, vendor.getNote());
        contentValues.put(ESTIMATEDAMOUNT, vendor.getEstimated_amount());
        contentValues.put(NUMBER, vendor.getNumber());
        contentValues.put(EMAIL, vendor.getEmail());
        contentValues.put(ADDRESS, vendor.getAddress());


        //save to table
       sqLiteDatabase.insert(TABLE_NAME,null, contentValues);
       sqLiteDatabase.close();

    }
}
