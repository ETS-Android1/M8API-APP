package com.example.m8api_app;

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
        View viewForm = inflater.inflate(R.layout.fragment_form, container, false);

        Button BEspaña = viewForm.findViewById(R.id.idiom1);
        Button BCatala = viewForm.findViewById(R.id.idiom2);
        Button BAngles = viewForm.findViewById(R.id.idiom3);

        BEspaña.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // prefs.edit().putString("language", "en").commit();
            }
        });

        BCatala.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
             //Hay  que poner algo que active
            }
        });

        BAngles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Hay  que poner algo que active
            }
        });

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}