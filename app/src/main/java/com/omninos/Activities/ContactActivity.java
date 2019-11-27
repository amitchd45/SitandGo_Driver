package com.omninos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.omninos.connekma_driver.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mActivity_Title;
    ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mActivity_Title = (TextView) findViewById(R.id.activity_name);
        mActivity_Title.setText("Contact Us");

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
