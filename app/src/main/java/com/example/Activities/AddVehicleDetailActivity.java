package com.example.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.connekma_driver.R;

public class AddVehicleDetailActivity extends AppCompatActivity implements View.OnClickListener {
    Button mContinue_btn;
    ImageView mBack;
    TextView mActivity_Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_detail);

        mContinue_btn = findViewById(R.id.btn_continue_2);
        mBack = findViewById(R.id.iv_back);
        mBack.setOnClickListener(this);
        mContinue_btn.setOnClickListener(this);

        mActivity_Title = findViewById(R.id.activity_name);
        mActivity_Title.setText("Add Vehicle Detail");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_continue_2:{
                Intent intent = new Intent(AddVehicleDetailActivity.this,AddLicenseDetailActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.iv_back:{
                onBackPressed();
                break;
            }
        }
    }
}
