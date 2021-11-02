package com.example.m8api_app;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m8api_app.CLASSES.Player;
import com.example.m8api_app.CLASSES.RecyclerViewAdapter;
import com.example.m8api_app.CLASSES.db.PlayerDBHelper;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    public ListFragment() {
        // Required empty public constructor
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private PlayerDBHelper dbHelper;
    private SQLiteDatabase db;

    public ListFragment(PlayerDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        ArrayList <Player> arrayPlayer = dbHelper.getAllPlayer(db);

        View player = inflater.inflate(R.layout.fragment_list,container,false);
        RecyclerView recyclerView = player.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(arrayPlayer);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((player.getContext())));
      /*  arrayPlayer.add(new Player("Adam", 20, "delantero", 10, 200));
        arrayPlayer.add(new Player("Marta", 30, "delantera", 1, 100));
        arrayPlayer.add(new Player("Miguel", 21, "centrocampista", 9, 10));
        arrayPlayer.add(new Player("Eric", 20, "portero", 12, 1));
        arrayPlayer.add(new Player("Arnau", 19, "delantero", 5, 5));*/


        return player;
    }
}