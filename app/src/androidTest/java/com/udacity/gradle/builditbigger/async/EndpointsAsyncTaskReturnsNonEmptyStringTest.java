package com.udacity.gradle.builditbigger.async;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeTaskCompleted;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskReturnsNonEmptyStringTest {
    public static final String TAG = "EndpointsAsyncTaskReturnsNonEmptyStringTest";

    @Test
    public void endpointsAsyncTaskReturnsNonEmptyString() {
        final CountDownLatch signal = new CountDownLatch(1);

        new EndpointsAsyncTask(new JokeTaskCompleted() {
            @Override
            public void onJokeTaskCompleted(String output) {
                Assert.assertNotEquals("", output);
                Assert.assertNotNull(output);
                Assert.assertFalse("Failed to connect to backend server, make sure it is properly configured and running", output.contains("Failed to connect"));
                Log.d(TAG, "here is the value of the returned string " + output);
                signal.countDown();
            }
        }).execute();
        try {
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
