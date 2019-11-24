package com.example.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Adapters.MainAdapter;

import com.example.Models.MainModel;
import com.example.connekma_driver.R;

import java.util.ArrayList;

public class SelectVehicleTypeActivity extends AppCompatActivity implements View.OnClickListener {

    Button mContinue_btn;
    ImageView mBack;
    TextView mActivity_Title;

    RecyclerView mRecyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_vehicle_type);

        mActivity_Title = findViewById(R.id.activity_name);
        mActivity_Title.setText("Select Vehicle Type");
        mContinue_btn = findViewById(R.id.btn_continue);
        mBack = findViewById(R.id.iv_back);
        mContinue_btn.setOnClickListener(this);
        mBack.setOnClickListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Integer[] langLogo = {R.drawable.car_hatch_back,R.drawable.car_sedan};

        String[] langName = {"HATCH BACK","SADEN"};

        mainModels = new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
            MainModel model = new MainModel(langLogo[i],langName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(SelectVehicleTypeActivity.this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(mainModels, SelectVehicleTypeActivity.this, new MainAdapter.Select() {
            @Override
            public void Choose(int position) {

                Toast.makeText(SelectVehicleTypeActivity.this, "okk", Toast.LENGTH_SHORT).show();

            }
        });


        mRecyclerView.setAdapter(mainAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_continue:{
                Intent vehicle_intent = new Intent(SelectVehicleTypeActivity.this,UploadVehiclePhotoActivity.class);
                startActivity(vehicle_intent);
                break;
            }
            case R.id.iv_back:{
                onBackPressed();
                break;
            }
        }
    }
}
