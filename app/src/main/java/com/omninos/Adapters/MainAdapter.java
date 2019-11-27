package com.omninos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omninos.Models.MainModel;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<MainModel> mainModels;
    Context context;
    Select select;
    int a = -1;
    int c = 0;

    public static interface Select {
        void Choose(int position);
    }

    public MainAdapter(ArrayList<MainModel> mainModels, Context context, Select select) {
        this.mainModels = mainModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.mCarImage.setImageResource(mainModels.get(position).getLangLogo());
        holder.mCarName.setText(mainModels.get(position).getLangName());

        if (position == a) {
            if (c == 0) {
                holder.mRelative.setVisibility(View.VISIBLE);
                holder.mRelative1.setVisibility(View.VISIBLE);

                c = 1;
            } else if (c == 1) {
                holder.mRelative.setVisibility(View.GONE);
                holder.mRelative1.setVisibility(View.GONE);
                c = 0;
            }

        } else {
            holder.mRelative.setVisibility(View.GONE);
            holder.mRelative1.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = position;
                select.Choose(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mCarImage;
        TextView mCarName, tv1;
        RelativeLayout mRelative, mRelative1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mCarImage = itemView.findViewById(R.id.iv_car_Image);
            mCarName = itemView.findViewById(R.id.tv_car_name);
            mRelative = itemView.findViewById(R.id.rell);
            mRelative1 = itemView.findViewById(R.id.rell1);
//            tv1=itemView.findViewById(R.id.tv1);


        }
    }
}
