package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rsherry.androidlibrarydisplayjoke.MainActivityAndroidLibrary;

public class MainActivityFragmentPaid extends Fragment implements View.OnClickListener, JokeTaskCompleted {
    //    JokeProvider mJokeProvider = new JokeProvider();
    String mJoke;

    public MainActivityFragmentPaid() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main_paid, container, false);

        Button mButton = root.findViewById(R.id.showJokeButton);
        mButton.setOnClickListener(this);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

        return root;
    }

    public void tellJoke(String string) {
        String joke = string;
        Bundle jokeBundle = new Bundle();
        jokeBundle.putString("joke",joke);

        Intent intent = new Intent(getActivity(), MainActivityAndroidLibrary.class);
        intent.putExtra("joke",jokeBundle);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showJokeButton:
                new EndpointsAsyncTask(new JokeTaskCompleted() {
                    @Override
                    public void onJokeTaskCompleted(String output) {
                        mJoke = output;
                        tellJoke(output);
                    }
                }).execute();
                break;
        }
    }

    @Override
    public void onJokeTaskCompleted(String string) {
        tellJoke(string);
    }
}
