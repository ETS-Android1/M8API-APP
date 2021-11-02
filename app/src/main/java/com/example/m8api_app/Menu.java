package com.example.m8api_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.m8api_app.CLASSES.db.PlayerDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {

    private PlayerDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dbHelper = new PlayerDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        dbHelper.dropTable(db);
        dbHelper.onCreate(db);
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.nav_llista:
                    selectedFragment = new ListFragment(dbHelper,db);
                    break;
                case R.id.nav_add:
                    selectedFragment = new FormFragment(dbHelper,db);
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();



            return true;
        });

    }

    //Close the db when the activity onDestroy
    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }

}