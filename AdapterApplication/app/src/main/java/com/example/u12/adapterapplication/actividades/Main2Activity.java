package com.example.u12.adapterapplication.actividades;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.u12.adapterapplication.fragments.OFragment;
import com.example.u12.adapterapplication.R;
import com.example.u12.adapterapplication.fragments.TFragment;

public class Main2Activity extends AppCompatActivity {

    private TextView textViewOne;
    private TextView textViewTwo;
    private FrameLayout fragmeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewOne = findViewById(R.id.textViewOne);
        textViewTwo = findViewById(R.id.textViewTwo);
        fragmeLayout = findViewById(R.id.fragmeLayout);


        textViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new OFragment());
            }
        });

        textViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showFragment(new TFragment());
            }
        });

showFragment(new OFragment());

    }

    private void showFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(fragmeLayout.getId(), fragment);
        transaction.commit();
    }
}
