package com.example.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.connekma_driver.R;

public class AddLicenseDetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mActivity_Title;
    Button mContinue_btn;
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_license_detail);

        mActivity_Title = findViewById(R.id.activity_name);
        mActivity_Title.setText("Add License Detail");

        mContinue_btn = findViewById(R.id.btn_continue_4);
        mBack = findViewById(R.id.iv_back);
        mBack.setOnClickListener(this);
        mContinue_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_continue_4:{
                Intent intent = new Intent(AddLicenseDetailActivity.this,UploadsDocumentsActivity.class);
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
