package com.example.aliothman.baking;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public static boolean the_tab = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            if(findViewById(R.id.bakeGrid) != null){
                the_tab = true;
                FragmentManager fragmentManager = getSupportFragmentManager();
                FirstFragment firstFragment = new FirstFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.bakeGrid, firstFragment)
                        .commit();
            }else {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FirstFragment firstFragment = new FirstFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.bakeframe, firstFragment)
                        .commit();
            }

        }

    }
}
