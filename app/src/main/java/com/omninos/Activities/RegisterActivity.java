package com.omninos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.omninos.connekma_driver.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button mRegister_btn;
    ImageView mBack_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegister_btn = findViewById(R.id.register_btn);
        mBack_arrow = findViewById(R.id.iv_back_btn);
        mRegister_btn.setOnClickListener(this);
        mBack_arrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_btn:{
                Intent verification_intent = new Intent(RegisterActivity.this,VerificationActivity.class);
                startActivity(verification_intent);
                break;
            }
            case R.id.iv_back_btn:{
                onBackPressed();
                break;
            }
        }

    }
}
