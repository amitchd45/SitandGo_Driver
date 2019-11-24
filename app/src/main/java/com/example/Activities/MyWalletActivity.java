package com.example.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.connekma_driver.R;

public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mActivity_Title;
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);

        mActivity_Title = (TextView) findViewById(R.id.activity_name);
        mActivity_Title.setText("Wallet");

        btn_back = findViewById(R.id.iv_back);
        btn_back.setOnClickListener(this);
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
