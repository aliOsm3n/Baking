package com.example.aliothman.baking;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        if(savedInstanceState == null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            ThirdFragment thirdFragment = new ThirdFragment();
            fragmentManager.beginTransaction().add(R.id.stepdetfram, thirdFragment).commit();

        }
    }
}
