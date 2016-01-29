package com.nadajp.jokedisplay;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokeDisplayFragment extends Fragment {


    public JokeDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_joke_display, container, false);
        String joke = this.getArguments().getString("joke");
        TextView txtJoke = (TextView) v.findViewById(R.id.txtJoke);
        txtJoke.setText(joke);
        return v;
    }

}
