package com.example.plapp.presentation;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MyApplication extends Application {

    private static Context context;


    @Override
    public void onCreate()
    {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }
    public static Context getAppContext()
    {
        return MyApplication.context;
    }

}
