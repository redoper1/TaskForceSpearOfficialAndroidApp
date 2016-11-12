package com.redoper.taskforcespearofficialapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;

public class RSS extends AppCompatActivity {

    RecyclerView recyclerView;

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        }
        return false;
    }

    public boolean isUrlReachable() {
        try{
            URL testUrl = new URL("http://www.tfsclan.eu/feed");
            URLConnection connection = testUrl.openConnection();
            connection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        ReadRss readRss=new ReadRss(this,recyclerView);
            if(isOnline()){
                if(isUrlReachable()){
                readRss.execute();
                } else{
                    Toast.makeText(getBaseContext(), "Can't connect to host", Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(getBaseContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
    }
}