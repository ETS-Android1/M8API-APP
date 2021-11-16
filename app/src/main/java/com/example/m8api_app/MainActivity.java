package com.example.m8api_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    int comprobacio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarations
        TextView textView = findViewById(R.id.textView);
        Button registrar = findViewById(R.id.registrar);
        EditText textname = findViewById(R.id.textname);
        EditText password = findViewById(R.id.password);
        CheckBox checkBox=findViewById(R.id.checkBox);

        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        comprobacio = (preferences.getInt("comprobante", 0));

        if (comprobacio != 0) {
            textname.setText(preferences.getString("Username", ""));
            password.setText(preferences.getString("Password", ""));
            String txtUsername = textname.getText().toString();
            String txtPassword = password.getText().toString();

            if (txtUsername.equals("adam") && txtPassword.equals("adam")) {
                goToMenu();
            }

        }

        //Button which confirms that the password and the name are ok
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the data from the edit text and pass it to a string and then save it in a variable string
                String txtUsername = textname.getText().toString();
                String txtPassword = password.getText().toString();
                //If the user is admin and the password is admin, you will enter the if
                if (checkBox.isChecked()==true){
                    guardarPreferancias();
                }
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

    private void guardarPreferancias() {
        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", ((EditText) findViewById(R.id.textname)).getText().toString());
        editor.putString("Password", ((EditText) findViewById(R.id.password)).getText().toString());
        editor.putInt("comprobante", 1);
        editor.commit();
    }

}