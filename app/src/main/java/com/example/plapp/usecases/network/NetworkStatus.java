package com.example.plapp.usecases.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.plapp.presentation.MyApplication;

public class NetworkStatus
{
    public static boolean isNetworkConnected()
    {
        ConnectivityManager cm =
                (ConnectivityManager) MyApplication.getAppContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
