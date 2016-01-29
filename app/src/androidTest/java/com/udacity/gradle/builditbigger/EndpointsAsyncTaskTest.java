package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by nadajp on 1/27/16.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase{

    CountDownLatch signal;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    public void testVerifyServerResponse() throws InterruptedException {
        try {
                EndpointsAsyncTask task = new EndpointsAsyncTask(
                    new EndpointsAsyncTask.EndpointsTaskListener() {
                @Override
                public void onTaskComplete(String result, String error) {
                    assertNotNull(result);
                    assertNull(error);
                    assertFalse(result.equals(""));
                }
            });
            task.execute();
            signal.await(30, TimeUnit.SECONDS);
        } catch (Exception e){
            fail("Timed out");
        }
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }


}