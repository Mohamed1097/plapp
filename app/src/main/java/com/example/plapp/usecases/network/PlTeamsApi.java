package com.example.plapp.usecases.network;

import com.example.plapp.Entities.PremireLeagueTeams.HttpApiFootballDataOrgV2Competitions;
import com.example.plapp.Entities.PremireLeagueTeams.HttpApiFootballDataOrgV2CompetitionsSquad;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface PlTeamsApi
{
    @GET("v2/competitions/2021/teams")
    Call<HttpApiFootballDataOrgV2Competitions>getTeams(@Header("x-Auth-token")String token);

    @GET("/v2/teams/{id}")
    Call<HttpApiFootballDataOrgV2CompetitionsSquad>getSquad(@Header("x-Auth-token")String token, @Path("id")long teamid);



}
