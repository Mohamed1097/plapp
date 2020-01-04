package com.example.plapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plapp.Entities.PremireLeagueTeams.Team;
import com.example.plapp.R;

import java.util.List;

public class PlTeamsAdapter extends RecyclerView.Adapter<PlTeamsAdapter.PlTeamsViewHolder>{
    private List<Team> teamslist;
    private Context context;

    public PlTeamsAdapter(List<Team> teamslist, Context context) {
        this.teamslist = teamslist;
        this.context = context;
    }

    @NonNull
    @Override
    public PlTeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plteamselement_layout,parent,false);
        PlTeamsViewHolder plTeamsViewHolder=new PlTeamsViewHolder(view);
        return plTeamsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PlTeamsViewHolder holder, final int position) {

        holder.teamName.setText(teamslist.get(position).getName());

        holder.teamColor.setText(teamslist.get(position).getClubColors());

        holder.teamWebsite.setText(teamslist.get(position).getWebsite());

        holder.teamStadium.setText(teamslist.get(position).getVenue());

        holder.squadtxt.setText("Squad of "+teamslist.get(position).getName() +",GO..");

        holder.squadtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(context,SquadActivity.class);
                intent.putExtra("TeamId",teamslist.get(position).getId());
                intent.putExtra("TeamName",teamslist.get(position).getName());
                context.startActivity(intent);
            }
        });

        holder.teamWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teamWebsite=new Intent(Intent.ACTION_VIEW, Uri.parse(teamslist.get(position).getWebsite()));
                context.startActivity(teamWebsite);
            }
        });

    }


    @Override
    public int getItemCount() {
        return teamslist.size();
    }



    class PlTeamsViewHolder extends RecyclerView.ViewHolder
    {
        private TextView teamName,teamStadium,teamWebsite,teamColor,squadtxt;

        public PlTeamsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            teamName=itemView.findViewById(R.id.teamName);

            teamStadium=itemView.findViewById(R.id.teamStadium);

            teamWebsite=itemView.findViewById(R.id.teamWebsite);

            teamColor=itemView.findViewById(R.id.teamColor);

            squadtxt=itemView.findViewById(R.id.squadtxt);




        }
    }
}
