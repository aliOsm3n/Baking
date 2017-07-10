package com.example.aliothman.baking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aliothman.baking.adapter.IngredientsAdapter;
import com.example.aliothman.baking.adapter.StepsAdapter;
import com.example.aliothman.baking.model.Steps;

import java.util.ArrayList;

import static com.example.aliothman.baking.FirstFragment.bakes;
import static com.example.aliothman.baking.MainActivity.the_tab;

/**
 * Created by Ali Othman on 21/06/2017.
 */

public class SecondFragment extends Fragment implements StepsAdapter.ListItemClickListener {

    private RecyclerView stepsRecyclerView;
    private RecyclerView ingredientRecyclerView;
    private StepsAdapter stepsAdapter;
    private IngredientsAdapter ingredientsAdapter;

    private View rootView;
    private int index =0;
    public static ArrayList<Steps> steps = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.second_fragment,container  ,false);
        stepsRecyclerView = (RecyclerView) rootView.findViewById(R.id.stepslist);
        ingredientRecyclerView = (RecyclerView) rootView.findViewById(R.id.ingredientslist);
        stepsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ingredientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       index =getActivity().getIntent().getExtras().getInt(getString(R.string.extra));
        steps = bakes.get(index).getSteps();
        stepsAdapter =new StepsAdapter(this,steps);
        ingredientsAdapter =new IngredientsAdapter(bakes.get(index).getIngredients());
       stepsRecyclerView.setAdapter(stepsAdapter);
        ingredientRecyclerView.setAdapter(ingredientsAdapter);
        return rootView;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if(!the_tab){
            Intent intent =new Intent(getActivity(),ThirdActivity.class);
            intent.putExtra("item",clickedItemIndex);
            startActivity(intent);
        }else {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
             ThirdFragment thirdFragment =new ThirdFragment();
            thirdFragment.index = clickedItemIndex;
            fragmentManager.beginTransaction().replace(R.id.stepdetfram, thirdFragment).commit();

        }

    }
}
