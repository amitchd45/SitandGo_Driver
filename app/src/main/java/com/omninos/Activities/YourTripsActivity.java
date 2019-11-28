package com.omninos.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninos.Adapters.RecentTransitionsAdapter;
import com.omninos.Models.BookingModel;
import com.omninos.Models.RecentTransitionsModel;
import com.omninos.Utils.MyBookingImformation;
import com.omninos.Utils.RecentTransition;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class YourTripsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    ImageView btn_back;
    RecyclerView mRecyclerView;
    ArrayList<RecentTransitionsModel> recentTransitionsModels;
    RecentTransitionsAdapter recentTransitionsAdapter;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_trips);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_transition);

        mActivity_Title = (TextView) findViewById(R.id.activity_name);
        mActivity_Title.setText("Your Trips");

        btn_back = findViewById(R.id.iv_back);
        btn_back.setOnClickListener(this);

        recentTransitionsModels = new ArrayList<>();
        int length=RecentTransition.DriverName.length;
        for (int i = 0; i <length; i++) {
            RecentTransitionsModel recentTransitionsModel = new RecentTransitionsModel(RecentTransition.DriverName[i], RecentTransition.Prices[i],
                    RecentTransition.From[i], RecentTransition.To[i], RecentTransition.Date[i]);

            recentTransitionsModels.add(recentTransitionsModel);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(YourTripsActivity.this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        RecentTransitionsAdapter recentTransitionsAdapter = new RecentTransitionsAdapter(recentTransitionsModels,context);
        mRecyclerView.setAdapter(recentTransitionsAdapter);
        recentTransitionsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
        }
    }
}
