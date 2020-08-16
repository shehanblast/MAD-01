package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DB_NAME="guest";
    private static final String TABLE_NAME ="guest";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String GENDER ="gender" ;
    private static final String TYPE = "type";
    private static final String INVITATION ="invitation" ;
    private static final String TELNO = "telno";
    private static final String EMAIL ="email" ;
    private static final String ADDRESS = "address";
    private static final String FINISHED = "started";
    private static final String STRATED = "finished";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY ="CREATE TABLE  "+TABLE_NAME+""+
                "("
                +ID+"INTEGER PRIMARY KEY,"
                +NAME+"TEXT,"
                +GENDER+"TEXT,"
                +TYPE+"TEXT,"
                +INVITATION+"TEXT,"
                +TELNO+"INTEGER,"
                +EMAIL+"TEXT,"
                +ADDRESS+"TEXT"
                +STRATED+"LONG,"
                +FINISHED+"LONG"+
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE_QUERY ="DROP TABLE IF EXISTS "+ TABLE_NAME;
        //Drop older table if exists
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        //create table again
        onCreate(sqLiteDatabase);

    }
    public void addGuest( guest guest){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ID,guest.getId());
        contentValues.put(NAME,guest.getName());
        contentValues.put(GENDER,guest.getGender());
        contentValues.put(TYPE,guest.getType());
        contentValues.put(INVITATION,guest.getInvitation());
        contentValues.put(TELNO,guest.getTelno());
        contentValues.put(EMAIL,guest.getEmail());
        contentValues.put(ADDRESS,guest.getAddress());
        contentValues.put(STRATED,guest.getStarted());
        contentValues.put(FINISHED,guest.getFinished());

        //save to the table

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //close database
        sqLiteDatabase.close();
    }
    public int countGuest(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query="SELECT * FROM " + TABLE_NAME;

        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();


    }

    //get all guests in to a list
    public List<guest> getAllGuests(){
        List <guest> guests =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query="SELECT * FROM " + TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                //create new Guest object
                guest G=new guest();

                G.setId(cursor.getInt(0));
                G.setName(cursor.getString(1));
                G.setGender(cursor.getString(2));
                G.setType(cursor.getString(3));
                G.setInvitation(cursor.getString(4));
                G.setTelno(cursor.getString(5));
                G.setEmail(cursor.getString(6));
                G.setAddress(cursor.getString(7));
                G.setStarted(cursor.getLong(8));
                G.setFinished(cursor.getLong(9));

                guests.add(G);

            }while(cursor.moveToNext());
        }
        return guests;

    }
}
