package com.redoper.taskforcespearofficialapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        ReadRss readRss=new ReadRss(this,recyclerView);
            if(isOnline()){
                readRss.execute();
            } else{
                Toast.makeText(getBaseContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
    }
}