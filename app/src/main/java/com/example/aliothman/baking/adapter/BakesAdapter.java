package com.example.aliothman.baking.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aliothman.baking.R;
import com.example.aliothman.baking.model.Bakes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ali Othman on 20/06/2017.
 */

public class BakesAdapter extends RecyclerView.Adapter<BakesAdapter.VHolder> {


    final private ListItemClickListener mOnClickListener;
    final private ArrayList<Bakes> bakes;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public BakesAdapter(ListItemClickListener listener, ArrayList<Bakes> bakes) {
        mOnClickListener = listener;
        this.bakes = bakes;
    }

    @Override
    public VHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        VHolder viewHolder = new VHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return bakes.size();
    }

    class VHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

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

        void onBind(int position) {
            if (!TextUtils.isEmpty(bakes.get(position).getImage())){
                 // Then load in image view.
                Picasso.with(itemView.getContext()).load(bakes.get(position).getImage()).into(icon);
                name.setText(bakes.get(position).getName());
                servings.setText(itemView.getContext().getString(R.string.servings) + " " + bakes.get(position).getServings());
            }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
