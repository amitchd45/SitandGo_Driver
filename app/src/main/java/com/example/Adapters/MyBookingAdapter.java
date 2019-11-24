package com.example.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Models.BookingModel;
import com.example.connekma_driver.R;

import java.util.ArrayList;

public class MyBookingAdapter extends RecyclerView.Adapter<MyBookingAdapter.ViewHolder>{

    ArrayList<BookingModel> bookingModels;
    Context context;
    Select select;
    int b=-1;

    public static interface Select {
        void Start(int position);
        void Cancel(int position);
    }


    public MyBookingAdapter(ArrayList<BookingModel> bookingModels, Context context, Select select) {
        this.bookingModels = bookingModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mBooking_no.setText(bookingModels.get(position).getBooking_no());
        holder.mDateTime.setText(bookingModels.get(position).getDate());
        holder.mLocation.setText(bookingModels.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return bookingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mBooking_no,mDateTime,mLocation;
        Button mCancel,mStart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBooking_no = (TextView) itemView.findViewById(R.id.booking_sr_no);
            mDateTime = (TextView) itemView.findViewById(R.id.booking_date);
            mLocation = (TextView) itemView.findViewById(R.id.booking_location);
            mCancel = itemView.findViewById(R.id.btn_trip_cancel);
            mStart = itemView.findViewById(R.id.btn_start_trip);
            mStart.setOnClickListener(this);
            mCancel.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_start_trip:{
                    select.Start(getLayoutPosition());
                    break;
                }
                case R.id.btn_trip_cancel:{
                    select.Cancel(getLayoutPosition());
                    break;
                }
            }
        }
    }
}
