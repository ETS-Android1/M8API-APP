package com.example.m8api_app.CLASSES.db;

import static com.example.m8api_app.CLASSES.db.PlayerContract.ContactsEntry.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.m8api_app.CLASSES.Player;

import java.util.ArrayList;

public class PlayerDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + "("
            + PlayerContract.ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PlayerContract.ContactsEntry.COLUMN_NAME_NAME + " TEXT, "
            + PlayerContract.ContactsEntry.COLUMN_NAME_AGE + " INTEGER, "
            + PlayerContract.ContactsEntry.COLUMN_NAME_POSITION + " TEXT,"
            + PlayerContract.ContactsEntry.COLUMN_NAME_SHIRTNO + " INTEGER, "
            + PlayerContract.ContactsEntry.COLUMN_NAME_GOAL + " INTEGER )";


    public PlayerDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE " + TABLE_NAME);
    }

    public void delete(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertContact(SQLiteDatabase db, Player c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(PlayerContract.ContactsEntry.COLUMN_NAME_NAME, c.getPlayerName());
            values.put(PlayerContract.ContactsEntry.COLUMN_NAME_AGE, c.getAge());
            values.put(PlayerContract.ContactsEntry.COLUMN_NAME_POSITION, c.getPosition());
            values.put(PlayerContract.ContactsEntry.COLUMN_NAME_SHIRTNO, c.getShirtNo());
            values.put(PlayerContract.ContactsEntry.COLUMN_NAME_GOAL, c.getGoal());

            db.insert(TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public ArrayList<Player> getAllPlayer(SQLiteDatabase db){
        ArrayList<Player> arrayPlayer = new ArrayList<>();

        Cursor cursor = db.query (TABLE_NAME, new String [] {"name", "age", "position", "shirtNum", "goal"}, null, null, null, null, null);
        Player p;
        while (cursor.moveToNext ()) {
            p = new Player (cursor.getString (0), cursor.getInt (1), cursor.getString (2), cursor.getInt (3), cursor.getInt (4));
            arrayPlayer.add (p);
        }
        cursor.close ();
        return arrayPlayer;
    }

}
