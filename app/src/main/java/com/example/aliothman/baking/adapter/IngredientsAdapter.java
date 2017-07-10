package com.example.aliothman.baking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aliothman.baking.R;
import com.example.aliothman.baking.model.Ingredients;

import java.util.ArrayList;

/**
 * Created by Ali Othman on 21/06/2017.
 */

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.VHolder> {

    final private ArrayList<Ingredients> ingredients;

    public IngredientsAdapter(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.ingredient_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        VHolder viewHolder = new VHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    class VHolder extends RecyclerView.ViewHolder {

        TextView ingredient;
        TextView quantity;
        TextView measure;


        public VHolder(View itemView) {
            super(itemView);
            ingredient = (TextView) itemView.findViewById(R.id.ingredient);
            measure = (TextView) itemView.findViewById(R.id.measure);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
        }

        void onBind(int position) {
            if (!ingredients.isEmpty()) {
                ingredient.setText(ingredients.get(position).getIngredient());
                measure.setText(ingredients.get(position).getMeasure());
                quantity.setText(ingredients.get(position).getQuantity()+"");
            }
        }
    }
}
