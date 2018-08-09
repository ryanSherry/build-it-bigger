package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rsherry.androidlibrarydisplayjoke.MainActivityAndroidLibrary;
import com.rsherry.javalibraryjokeprovider.JokeProvider;

public class MainActivityAppFree extends AppCompatActivity {

    JokeProvider mJokeProvider = new JokeProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_free);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJokeUnused() {
        String joke = mJokeProvider.getJoke();

        Bundle jokeBundle = new Bundle();
        jokeBundle.putString("joke",joke);

        Toast.makeText(this, joke , Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivityAndroidLibrary.class);
        intent.putExtra("joke",jokeBundle);

        startActivity(intent);
    }
}
