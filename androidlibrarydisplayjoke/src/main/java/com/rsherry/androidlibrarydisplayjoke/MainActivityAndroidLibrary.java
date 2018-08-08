package com.rsherry.androidlibrarydisplayjoke;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivityAndroidLibrary extends AppCompatActivity {
    public static final String SHOW_JOKE_FRAGMENT = "showJokeFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ShowJokeFragment showJokeFragment = new ShowJokeFragment();

        if(intent != null) {
            Bundle jokeBundle = intent.getBundleExtra("joke");
            showJokeFragment.setArguments(jokeBundle);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentPlaceHolder, showJokeFragment, SHOW_JOKE_FRAGMENT);
        fragmentTransaction.commit();

    }
}
