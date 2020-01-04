package com.example.plapp.usecases.network;

import com.example.plapp.presentation.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;


import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PL_Retrofit
{


    static Retrofit retrofit = null;




    public static Retrofit getRetrofit() {
        if(retrofit==null) {
            retrofit= new Retrofit.Builder()
                    .baseUrl("http://api.football-data.org/")
                    .client(CacheData.okHttpClient())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }


}
