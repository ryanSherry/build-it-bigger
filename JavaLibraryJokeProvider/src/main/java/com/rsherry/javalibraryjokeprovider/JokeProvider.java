package com.rsherry.javalibraryjokeprovider;

import java.util.Random;

public class JokeProvider {
    private String[] mJokesArray = JokesArray.getJokesArray();
    public String getJoke() {
        int randomJokeIndex = new Random().nextInt(mJokesArray.length);
        return mJokesArray[randomJokeIndex];
    }
}
