package com.nadajp.jokedisplay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Log.i("JokeDisplayActivity", "jokedisplay");
        String joke = getIntent().getStringExtra("joke");

        Fragment fragment = new JokeDisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("joke", joke);
        fragment.setArguments(bundle);
        android.support.v4.app.FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_holder, fragment);
        transaction.commit();
    }
}
