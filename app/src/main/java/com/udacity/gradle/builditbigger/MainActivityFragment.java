package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.rsherry.androidlibrarydisplayjoke.MainActivityAndroidLibrary;
import com.rsherry.javalibraryjokeprovider.JokeProvider;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        Button mButton = root.findViewById(R.id.showJokeButton);
        mButton.setOnClickListener(this);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    public void tellJoke() {
        JokeProvider mJokeProvider = new JokeProvider();
        String joke = mJokeProvider.getJoke();

        Bundle jokeBundle = new Bundle();
        jokeBundle.putString("joke",joke);

        Toast.makeText(getActivity(), joke , Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), MainActivityAndroidLibrary.class);
        intent.putExtra("joke",jokeBundle);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showJokeButton:
                tellJoke();
                break;
        }
    }
}
