package com.example.m8api_app.CLASSES.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PlayerDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + PlayerContract.ContactsEntry.TABLE_NAME + "("
            + PlayerContract.ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PlayerContract.ContactsEntry.COLUMN_NAME_NAME + " VARCHAR "
            + PlayerContract.ContactsEntry.COLUMN_NAME_AGE + " INTEGER "
            + PlayerContract.ContactsEntry.COLUMN_NAME_POSITION + " VARCHAR "
            + PlayerContract.ContactsEntry.COLUMN_NAME_SHIRTNO + " INTEGER "
            + PlayerContract.ContactsEntry.COLUMN_NAME_GOAL + " INTEGER "
            + ")";


    public PlayerDBHelper(@Nullable Context context, @Nullable String db1, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, db1, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
