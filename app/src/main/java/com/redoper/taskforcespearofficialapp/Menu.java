package com.redoper.taskforcespearofficialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.net.Uri;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void RSS (View view) {
        Intent intent = new Intent(this, RSS.class);
        startActivity(intent);
    }

    public void goToWeb (View view) {
        Uri uri = Uri.parse("http://tfsclan.eu");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goToFB (View view) {
        Uri uri = Uri.parse("https://www.facebook.com/TaskForceSpear");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goToYT (View view) {
        Uri uri = Uri.parse("https://www.youtube.com/TfsclanEu");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goToSteam (View view) {
        Uri uri = Uri.parse("http://steamcommunity.com/groups/TFSpearA3");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
