package com.omninos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omninos.Models.RecentTransitionsModel;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class RecentTransitionsAdapter extends RecyclerView.Adapter<RecentTransitionsAdapter.ViewHolder> {

    ArrayList<RecentTransitionsModel> recentTransitionsModels;
    Context context;

    public RecentTransitionsAdapter(ArrayList<RecentTransitionsModel> recentTransitionsModels, Context context) {
        this.recentTransitionsModels = recentTransitionsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transations_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mName.setText(recentTransitionsModels.get(position).getDriverName());
        holder.mPrise.setText(recentTransitionsModels.get(position).getPrices());
        holder.mFrom.setText(recentTransitionsModels.get(position).getFrom());
        holder.mTo.setText(recentTransitionsModels.get(position).getTo());
        holder.mDate.setText(recentTransitionsModels.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return recentTransitionsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mPrise,mFrom,mTo,mDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.tv_driver_name);
            mPrise = itemView.findViewById(R.id.tv_amounts);
            mFrom = itemView.findViewById(R.id.tv_from_location);
            mTo = itemView.findViewById(R.id.tv_To_location);
            mDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
