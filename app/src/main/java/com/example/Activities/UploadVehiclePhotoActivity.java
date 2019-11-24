package com.example.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.connekma_driver.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class UploadVehiclePhotoActivity extends AppCompatActivity implements View.OnClickListener {

    Button mContinue_btn;
    ImageView mTakeImage,mSetVehiclePhoto,mBack;
    TextView mActivity_Title;
    Uri resultUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_vehicle_photo);

        mContinue_btn = findViewById(R.id.btn_continue_1);
        mBack = findViewById(R.id.iv_back);
        mTakeImage = findViewById(R.id.iv_pick_image);
        mTakeImage.setOnClickListener(this);
        mContinue_btn.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mSetVehiclePhoto = findViewById(R.id.iv_vehicle_image);
        mActivity_Title = findViewById(R.id.activity_name);
        mActivity_Title.setText("Upload Vehicle Photo");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_continue_1:{
                Intent vehicle_intent = new Intent(UploadVehiclePhotoActivity.this,AddVehicleDetailActivity.class);
                startActivity(vehicle_intent);
                break;
            }
            case R.id.iv_pick_image:{
                CropImage.activity().setGuidelines(CropImageView.Guidelines.ON);
                CropImage.activity().start(UploadVehiclePhotoActivity.this);
                break;
            }
            case R.id.iv_back:{
                onBackPressed();
                break;
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {

            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {

                    resultUri = result.getUri();
                    mSetVehiclePhoto.setImageURI(resultUri);

                    Toast.makeText(this, "Image Uploade Successfully.", Toast.LENGTH_SHORT).show();

                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception erroe = result.getError();
                    Toast.makeText(this, "error,please try again.", Toast.LENGTH_SHORT).show();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
