package com.example.plapp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.plapp.Entities.PremireLeagueTeams.Squad;
import com.example.plapp.R;

import java.util.List;

public class SquadActivity extends AppCompatActivity {
    private int teamid;
    private RecyclerView squadRecycler;
    private SquadAdapter squadAdapter;
    private PlViewModel plViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad);

        plViewModel= ViewModelProviders.of(this).get(PlViewModel.class);



        Intent intent=getIntent();
        String name=intent.getStringExtra("TeamName");
        Toolbar toolbar = findViewById(R.id.squadToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name+" Squad");



        squadRecycler=findViewById(R.id.squadRecycler);
        squadRecycler.setLayoutManager(new LinearLayoutManager(this));
        squadRecycler.setHasFixedSize(true);


        teamid= intent.getIntExtra("TeamId",0);
        plViewModel.getSquad(teamid);

        plViewModel.listMutableLiveData.observe(this, new Observer<List<Squad>>() {
            @Override
            public void onChanged(List<Squad> squads)
            {
                squadAdapter=new SquadAdapter(squads);
                squadRecycler.setAdapter(squadAdapter);
            }
        });


    }
}
