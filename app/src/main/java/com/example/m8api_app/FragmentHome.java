package com.example.m8api_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m8api_app.CLASSES.Player;

import java.util.ArrayList;
import java.util.Locale;

public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);

        Button BEspaña = viewHome.findViewById(R.id.idiom1);
        Button BCatala = viewHome.findViewById(R.id.idiom2);
        Button BAngles = viewHome.findViewById(R.id.idiom3);
        Button BNoLogin = viewHome.findViewById(R.id.idiom4);

        BEspaña.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("Es");
            }
        });

        BCatala.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("Ca");
            }
        });

        BAngles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("En");
            }
        });


        BNoLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("credenciales", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                refresh();
            }
        });

        return viewHome;
    }

    public void Save(String locale){
        SharedPreferences preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        final Configuration config = new Configuration(getResources().getConfiguration());
        config.locale = new Locale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Idioma",locale );
        editor.commit();
        refresh();
    }

    public void refresh(){
        Intent intent = new Intent(getContext(),MainActivity.class);
        startActivity(intent);
    }
}