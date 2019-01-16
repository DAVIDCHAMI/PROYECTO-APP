package com.example.u12.adapterapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.u12.adapterapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TFragment extends Fragment {


    public TFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_t, container, false);
        loadAdapter(view);
        return view;
    }

    private void loadAdapter(View view) {

    }


}
