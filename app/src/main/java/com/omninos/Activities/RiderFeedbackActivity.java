package com.omninos.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninos.Adapters.RiderAdapter;
import com.omninos.Models.RiderModel;
import com.omninos.Utils.RiderInformation;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class RiderFeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    ImageView btn_back;

    RecyclerView mRecyclerView;
    ArrayList<RiderModel> riderModels = new ArrayList<>();
    RiderAdapter riderAdapter;
    RiderInformation riderInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_feedback);

        mActivity_Title = (TextView) findViewById(R.id.activity_name);
        mActivity_Title.setText("Rider Feedback");

        btn_back = findViewById(R.id.iv_back);
        btn_back.setOnClickListener(this);

        mRecyclerView = findViewById(R.id.recycler_view_avrage_rating);

        for (int i = 0; i < RiderInformation.UserName.length; i++) {
            RiderModel riderModel = new RiderModel(RiderInformation.UserName[i], RiderInformation.RatingBar[i],
                    RiderInformation.Date[i]);

            riderModels.add(riderModel);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(RiderFeedbackActivity.this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        RiderAdapter riderAdapter = new RiderAdapter(riderModels);
        mRecyclerView.setAdapter(riderAdapter);
        riderAdapter.notifyDataSetChanged();

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
