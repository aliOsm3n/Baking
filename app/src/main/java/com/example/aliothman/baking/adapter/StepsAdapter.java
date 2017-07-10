package com.example.aliothman.baking.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliothman.baking.R;
import com.example.aliothman.baking.model.Steps;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ali Othman on 21/06/2017.
 */

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.VHolder> {

    final private ListItemClickListener mOnClickListener;
    final private ArrayList<Steps> steps;

    public StepsAdapter(ListItemClickListener mOnClickListener, ArrayList<Steps> steps) {
        this.mOnClickListener = mOnClickListener;
        this.steps = steps;
    }


    public interface ListItemClickListener{
         void onListItemClick(int clickedItemIndex);
    }


    @Override
    public VHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
      View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item , viewGroup , false);
        VHolder viewHolder =new VHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
              holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

      class VHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

          ImageView icon;
          TextView name;
          TextView servings;

        public VHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            name = (TextView) itemView.findViewById(R.id.name);
            servings = (TextView) itemView.findViewById(R.id.servings);
                itemView.setOnClickListener(this);
        }

          void onBind(int position){
             if(!steps.isEmpty()){
                 if(!steps.get(position).getThumbnailURL().isEmpty()){
                     Picasso.with(itemView.getContext()).load(steps.get(position).getThumbnailURL()).error(R.drawable.ic_insert_image)
                             .into(icon);
                 }else {
                     icon.setImageResource(R.drawable.ic_insert_image);
                 }
                 name.setText(steps.get(position).getShortDescription());
                 servings.setText("steps :" + steps.get(position).getId());

             }

          }

          @Override
          public void onClick(View v) {
              int clickedPosition =getAdapterPosition();
             mOnClickListener.onListItemClick(clickedPosition);

          }
      }
}
