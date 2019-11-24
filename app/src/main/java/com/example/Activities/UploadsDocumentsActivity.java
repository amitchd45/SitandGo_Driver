package com.example.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Adapters.UploadDocumentsParentAdapter;
import com.example.Models.UploadDocumentsModel;
import com.example.Utils.VehicleInformation;
import com.example.connekma_driver.R;

import java.util.ArrayList;


public class UploadsDocumentsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "debug";
    Context context=this;

    RecyclerView mRecyclerView;
    ArrayList<UploadDocumentsModel> uploadDocumentsModels;
    UploadDocumentsParentAdapter uploadDocumentsParentAdapter;
    VehicleInformation vehicleInformation;

    TextView mActivity_Title;
    Button mContinue_btn;
    ImageView mBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads_documents);

        mActivity_Title = findViewById(R.id.activity_name);
        mActivity_Title.setText("Upload Documents");

        mContinue_btn = findViewById(R.id.btn_continue_3);
        mBack = findViewById(R.id.iv_back);
        mContinue_btn.setOnClickListener(this);
        mBack.setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_parent);
        uploadDocumentsModels = new ArrayList<>();
        for (int i = 0; i < VehicleInformation.ParentName.length; i++) {
            UploadDocumentsModel model = new UploadDocumentsModel(VehicleInformation.ParentName[i]);
            uploadDocumentsModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(UploadsDocumentsActivity.this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        uploadDocumentsParentAdapter = new UploadDocumentsParentAdapter(uploadDocumentsModels, UploadsDocumentsActivity.this, new UploadDocumentsParentAdapter.Select() {
            @Override
            public void Choose(int position) {
                Toast.makeText(UploadsDocumentsActivity.this, "ok", Toast.LENGTH_SHORT).show();

            }
        });

        mRecyclerView.setAdapter(uploadDocumentsParentAdapter);
        uploadDocumentsParentAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_continue_3: {

                openSubmitDialog();
                break;
            }
            case R.id.iv_back: {
                onBackPressed();
                break;
            }
        }
    }

    private void openSubmitDialog() {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.documents_submission_dialog);

        Button mCountinue = dialog.findViewById(R.id.btn_continue_5);
        dialog.setCanceledOnTouchOutside(false);
        mCountinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vehicle_intent = new Intent(UploadsDocumentsActivity.this, HomeActivity.class);
                startActivity(vehicle_intent);
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}

