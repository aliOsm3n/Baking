package com.example.aliothman.baking;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import static com.example.aliothman.baking.MainActivity.the_tab;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(savedInstanceState ==null){
            FragmentManager fragmentManager =getSupportFragmentManager();
            if(the_tab){
                SecondFragment secondFragment =new SecondFragment();
                fragmentManager.beginTransaction().replace(R.id.stepfram, secondFragment).commit();

                ThirdFragment thirdFragment =new ThirdFragment();
                fragmentManager.beginTransaction().replace(R.id.stepdetfram, thirdFragment).commit();
            }else {
                  SecondFragment secondFragment = new SecondFragment();
                fragmentManager.beginTransaction().add(R.id.stepfram, secondFragment).commit();
            }

        }


    }
}
