package com.example.m8api_app.CLASSES;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m8api_app.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Player> array_players;


    public RecyclerViewAdapter(ArrayList<Player> arrP){
        array_players = arrP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Textiño.setText(array_players.get(position).getPlayerName());
        //holder.Textiño.setText(array_players.get(position).getAge());
        //holder.Textiño.setText(array_players.get(position).getPosition());
        //holder.Textiño.setText(array_players.get(position).getShirtNo());
        //holder.Textiño.setText(array_players.get(position).getGoal());
    }

    @Override
    public int getItemCount() {
        return array_players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Textiño;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Textiño = itemView.findViewById(R.id.Textiño);
        }
    }
}