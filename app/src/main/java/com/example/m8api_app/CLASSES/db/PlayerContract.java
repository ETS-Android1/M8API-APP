package com.example.m8api_app.CLASSES.db;

import android.provider.BaseColumns;

public class PlayerContract {
    private PlayerContract(){}
    public static class ContactsEntry implements BaseColumns {
        public static final String TABLE_NAME ="contacts";
        public static final String ID = "id";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_POSITION = "position";
        public static final String COLUMN_NAME_SHIRTNO = "shirt no";
        public static final String COLUMN_NAME_GOAL = "goal";
    }
}
