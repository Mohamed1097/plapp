package com.example.plapp.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plapp.Entities.PremireLeagueTeams.Squad;
import com.example.plapp.R;

import java.util.List;

public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.SquadViewHolder>

{
    private List<Squad>teamSquad;


    public SquadAdapter(List<Squad> teamSquad) {
        this.teamSquad = teamSquad;
    }

    @NonNull
    @Override
    public SquadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pl_team_squad,parent,false);

        SquadViewHolder squadViewHolder=new SquadViewHolder(view);

        return squadViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SquadViewHolder holder, int position)
    {

        holder.playerName.setText(teamSquad.get(position).getName());

        holder.playerNationality.setText(teamSquad.get(position).getNationality());

        holder.playerPosition.setText(String.valueOf(teamSquad.get(position).getPosition()));
    }

    @Override
    public int getItemCount() {
        return teamSquad.size();
    }

    class SquadViewHolder extends RecyclerView.ViewHolder {

      private TextView playerName,playerNationality,playerPosition;

        public SquadViewHolder(@NonNull View itemView) {
            super(itemView);

            playerName=itemView.findViewById(R.id.playerName);

            playerPosition=itemView.findViewById(R.id.position);

            playerNationality=itemView.findViewById(R.id.playerNationality);

        }
    }
}
