package com.example.m8api_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.m8api_app.CLASSES.Player;

public class InfoFragment extends Fragment {

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View infoplayer = inflater.inflate(R.layout.fragment_info, container, false);

        Bundle bundle = getArguments();
        Player player = (Player) bundle.getSerializable("jugador");

        TextView txtplayer = infoplayer.findViewById(R.id.textplayer);
        txtplayer.setText(player.getPlayerName());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}