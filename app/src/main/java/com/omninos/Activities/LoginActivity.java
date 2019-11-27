package com.omninos.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omninos.connekma_driver.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button mLogin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin_btn = findViewById(R.id.login_btn);
        mLogin_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:{
                Intent register_intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register_intent);
                break;
            }
        }
    }
}
