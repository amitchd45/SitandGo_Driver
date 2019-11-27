package com.omninos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omninos.Models.RiderModel;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class RiderAdapter extends RecyclerView.Adapter<RiderAdapter.ViewHolder> {

    ArrayList<RiderModel> riderModels;
    Context context;

    public RiderAdapter(ArrayList<RiderModel> riderModels) {
        this.riderModels = riderModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rider_item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mName.setText(riderModels.get(position).getUserName());
        holder.mRatingBar.setRating(Float.parseFloat(riderModels.get(position).getRatingBar()));
        holder.mDate.setText(riderModels.get(position).getDate());


    }

    @Override
    public int getItemCount() {
        return riderModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mDate;
        RatingBar mRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.user_name);
            mRatingBar = itemView.findViewById(R.id.user_rating);
            mDate = itemView.findViewById(R.id.Date);
        }
    }
}
