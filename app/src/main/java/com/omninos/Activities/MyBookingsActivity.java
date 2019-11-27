package com.omninos.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.omninos.Adapters.MyBookingAdapter;
import com.omninos.Models.BookingModel;
import com.omninos.Utils.MyBookingImformation;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class MyBookingsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mActivity_Title;
    ImageView btn_back;
    Context context= this;

    RecyclerView mRecyclerView;
    ArrayList<BookingModel> bookingModels;
    MyBookingAdapter myBookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        mRecyclerView =(RecyclerView) findViewById(R.id.booking_recyclerView);

        mActivity_Title = (TextView) findViewById(R.id.activity_name);
        mActivity_Title.setText("My Bookings");

        btn_back = findViewById(R.id.iv_back);
        btn_back.setOnClickListener(this);


        bookingModels = new ArrayList<>();
        for (int i = 0; i< MyBookingImformation.booking_no.length; i++){
            BookingModel bookingModel = new BookingModel(MyBookingImformation.date[i],MyBookingImformation.booking_no[i],
                    MyBookingImformation.location[i]);

            bookingModels.add(bookingModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(MyBookingsActivity.this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        MyBookingAdapter myBookingAdapter = new MyBookingAdapter(bookingModels, MyBookingsActivity.this, new MyBookingAdapter.Select() {
            @Override
            public void Start(int position) {
                Toast.makeText(MyBookingsActivity.this, "start trip", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void Cancel(int position) {
                ReasonForCancelletionDialog();
            }
        });

        mRecyclerView.setAdapter(myBookingAdapter);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
        }

    }

    private void ReasonForCancelletionDialog() {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.reason_for_cancellation);
        dialog.setCanceledOnTouchOutside(false);
        TextView mDone = (TextView) dialog.findViewById(R.id.done_1);
        TextView mCancel = (TextView) dialog.findViewById(R.id.cancel_1);
        mDone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
