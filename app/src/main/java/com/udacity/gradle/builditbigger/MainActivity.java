package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nadajp.jokedisplay.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointsTaskListener {

    public static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, "Build it Bigger");
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

    public void tellJoke(View view){
        //JokeTeller jokeTeller = new JokeTeller();
        //String joke = jokeTeller.getJoke();
        //Toast.makeText(this, jokeTeller.getJoke(), Toast.LENGTH_SHORT).show();
        new EndpointsAsyncTask(this).execute();

    }

    public void onTaskComplete(String joke, String error){
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        String result = null;
        if (error != null){
            result = error;
        }
        else { result = joke; }
        intent.putExtra(getString(R.string.joke), result);
        startActivity(intent);
    }
}