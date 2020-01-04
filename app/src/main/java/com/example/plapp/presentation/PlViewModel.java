package com.example.plapp.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plapp.Entities.PremireLeagueTeams.Squad;
import com.example.plapp.Entities.PremireLeagueTeams.Team;
import com.example.plapp.usecases.PlUseCase;

import java.util.List;

public class PlViewModel extends ViewModel
{
    private PlUseCase plUseCase;
     MutableLiveData<List<Team>> mutableLiveData;
     MutableLiveData<List<Squad>>listMutableLiveData;

    public void getSquad(int teamid )
    {
        plUseCase.retriveSquad(teamid);
    }

    public PlViewModel()
    {
        listMutableLiveData=new MutableLiveData<>();
        mutableLiveData=new MutableLiveData<>();
        plUseCase=new PlUseCase(mutableLiveData,listMutableLiveData);

    }

    public void getTeams()
    {
        plUseCase.retriveTeams();
    }

}
