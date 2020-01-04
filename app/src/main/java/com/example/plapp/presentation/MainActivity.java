package com.example.plapp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.plapp.Entities.PremireLeagueTeams.Team;
import com.example.plapp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView teamsListRecycler;
    private PlTeamsAdapter plTeamsAdapter;
    private PlViewModel plViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PL Teams");

        teamsListRecycler=findViewById(R.id.teamsListRecycler);
        teamsListRecycler.setLayoutManager(new LinearLayoutManager(this));
        teamsListRecycler.setHasFixedSize(true);

        plViewModel= ViewModelProviders.of(this).get(PlViewModel.class);
        plViewModel.getTeams();
        plViewModel.mutableLiveData.observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(List<Team> teams)
            {
                plTeamsAdapter=new PlTeamsAdapter(teams,MainActivity.this);
                teamsListRecycler.setAdapter(plTeamsAdapter);

            }
        });


    }

}
