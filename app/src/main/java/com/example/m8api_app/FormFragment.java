package com.example.m8api_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;

import com.example.m8api_app.CLASSES.Player;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<Player> array_players;

    public FormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewForm = inflater.inflate(R.layout.fragment_form, container, false);

        //Declarations
        Button BGuardarPlayer = viewForm.findViewById(R.id.BGuardarPlayer);
        EditText editTextTextPersonName = viewForm.findViewById(R.id.editTextTextPersonName);
        EditText dato1 = viewForm.findViewById(R.id.dato1);
        EditText dato2 = viewForm.findViewById(R.id.dato2);
        EditText dato3 = viewForm.findViewById(R.id.dato3);
        EditText dato4 = viewForm.findViewById(R.id.dato4);
        BGuardarPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Crear objecte Player amb les dades
                String playerName = editTextTextPersonName.getText().toString();
                int age = Integer.parseInt(dato1.getText().toString());
                String position = dato2.getText().toString();
                int shirtNo = Integer.parseInt(dato3.getText().toString());
                int goal = Integer.parseInt(dato4.getText().toString());

                Player p = new Player(playerName, age, position, shirtNo, goal);

                //array_players.add(p.Player(playerName, age, position, shirtNo, goal));
            }
        });


        return viewForm;
    }
}