package com.example.plapp.usecases.repository;

import com.example.plapp.Entities.PremireLeagueTeams.HttpApiFootballDataOrgV2Competitions;
import com.example.plapp.Entities.PremireLeagueTeams.HttpApiFootballDataOrgV2CompetitionsSquad;
import com.example.plapp.usecases.network.PL_Retrofit;
import com.example.plapp.usecases.network.PlTeamsApi;

import retrofit2.Call;

public class PlRepo
{
    private PlTeamsApi plTeamsApi;

    public PlRepo()
    {
        plTeamsApi = PL_Retrofit.getRetrofit().create(PlTeamsApi.class);
    }



    public Call<HttpApiFootballDataOrgV2Competitions>getTeams()
    {
        return plTeamsApi.getTeams("e167575c42454e78826fabdcd7e0a70b");
    }
    public Call<HttpApiFootballDataOrgV2CompetitionsSquad>getSquad(int teamId)
    {
        return plTeamsApi.getSquad("e167575c42454e78826fabdcd7e0a70b",teamId);
    }
}
