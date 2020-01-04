package com.example.plapp.usecases;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.plapp.Entities.PremireLeagueTeams.HttpApiFootballDataOrgV2Competitions;
import com.example.plapp.Entities.PremireLeagueTeams.HttpApiFootballDataOrgV2CompetitionsSquad;
import com.example.plapp.Entities.PremireLeagueTeams.Squad;
import com.example.plapp.Entities.PremireLeagueTeams.Team;
import com.example.plapp.presentation.MyApplication;
import com.example.plapp.usecases.repository.PlRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlUseCase
{
    private PlRepo plRepo;
    private MutableLiveData<List<Team>>mutableLiveData;
    private MutableLiveData<List<Squad>>listMutableLiveData;



    public PlUseCase(MutableLiveData<List<Team>> mutableLiveData,MutableLiveData<List<Squad>> listMutableLiveData)
    {
        plRepo=new PlRepo();
        this.mutableLiveData = mutableLiveData;
        this.listMutableLiveData = listMutableLiveData;
    }
    public void retriveSquad(int teamid)
    {
        plRepo.getSquad(teamid).enqueue(new Callback<HttpApiFootballDataOrgV2CompetitionsSquad>() {
            @Override
            public void onResponse(Call<HttpApiFootballDataOrgV2CompetitionsSquad> call, Response<HttpApiFootballDataOrgV2CompetitionsSquad> response)
            {
              listMutableLiveData.setValue(response.body().getSquad());
            }

            @Override
            public void onFailure(Call<HttpApiFootballDataOrgV2CompetitionsSquad> call, Throwable t)
            {
                Toast.makeText(MyApplication.getAppContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void retriveTeams()
    {
        plRepo.getTeams().enqueue(new Callback<HttpApiFootballDataOrgV2Competitions>() {
            @Override
            public void onResponse(Call<HttpApiFootballDataOrgV2Competitions> call, Response<HttpApiFootballDataOrgV2Competitions> response) {
                mutableLiveData.setValue(response.body().getTeams());
            }

            @Override
            public void onFailure(Call<HttpApiFootballDataOrgV2Competitions> call, Throwable t)
            {
                Toast.makeText(MyApplication.getAppContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
