package com.example.m8api_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarations
        TextView textView = findViewById(R.id.textView);
        Button registrar = findViewById(R.id.registrar);
        EditText textname = findViewById(R.id.textname);
        EditText password = findViewById(R.id.password);

        //Button which confirms that the password and the name are ok
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textname.getText().toString().equals("adam")&& password.getText().toString().equals("adam")){
                    Log.i("Test","Bien");
                    goToMenu();
                }else{
                    Log.i("Test","Mal");
                }
            }
        });
    }

    public void goToMenu(){
        Intent intentmenu = new Intent(this,Menu.class);
        startActivity(intentmenu);
    }

}