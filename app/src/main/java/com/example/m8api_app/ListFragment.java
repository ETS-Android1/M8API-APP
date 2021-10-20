package com.example.m8api_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m8api_app.CLASSES.Player;
import com.example.m8api_app.CLASSES.RecyclerViewAdapter;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View player = inflater.inflate(R.layout.fragment_list,container,false);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Adam", 20, "delantero", 10, 200));
        players.add(new Player("Marta", 30, "delantera", 1, 100));
        players.add(new Player("Miguel", 21, "centrocampista", 9, 10));
        players.add(new Player("Eric", 20, "portero", 12, 1));
        players.add(new Player("Arnau", 19, "delantero", 5, 5));

        RecyclerView recyclerView = player.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(players);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((player.getContext())));

        return player;
    }
}