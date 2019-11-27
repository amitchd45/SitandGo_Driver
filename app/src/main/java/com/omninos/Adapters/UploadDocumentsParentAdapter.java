package com.omninos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omninos.Models.DocumentsTypeModel;
import com.omninos.Models.UploadDocumentsModel;
import com.omninos.Utils.VehicleInformationChild;
import com.omninos.Utils.VehicleInsurance;
import com.omninos.Utils.VehiclePermit;
import com.omninos.Utils.VehicleRegistration;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class UploadDocumentsParentAdapter extends RecyclerView.Adapter<UploadDocumentsParentAdapter.ViewHolder> {

    ArrayList<UploadDocumentsModel> uploadDocumentsModels;
    UploadDocumentsChildAdapter uploadDocumentsChildAdapter;
    VehicleInformationChild vehicleInformationChild;

    Context context;
    UploadDocumentsParentAdapter.Select select;
    int a = -1;
    int c = 0;

    public static interface Select {
        void Choose(int position);
    }

    public UploadDocumentsParentAdapter(ArrayList<UploadDocumentsModel> uploadDocumentsModels, Context context, Select select) {
        this.uploadDocumentsModels = uploadDocumentsModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public UploadDocumentsParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.documents_type_parent_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UploadDocumentsParentAdapter.ViewHolder holder, final int position) {


        holder.mTextTitleParent.setText(uploadDocumentsModels.get(position).getParentName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.recyclerView.setHasFixedSize(true);
        ArrayList<DocumentsTypeModel> documentsTypeModels = new ArrayList<>();
        holder.mDown.setVisibility(View.VISIBLE);

        if (position == a) {
            if(c==0){
                holder.mDown.setVisibility(View.GONE);
                holder.mUp.setVisibility(View.VISIBLE);
                holder.recyclerView.setVisibility(View.VISIBLE);

                if (uploadDocumentsModels.get(position).getParentName().equals("Step 1:Driver License")) {

                    for (int i = 0; i < VehicleInformationChild.ChildName.length; i++) {
                        DocumentsTypeModel model = new DocumentsTypeModel(VehicleInformationChild.ChildName[i]);
                        documentsTypeModels.add(model);
                    }
                } else if (uploadDocumentsModels.get(position).getParentName().equals("Step 2:Vehicle Insurance")) {

                    for (int i = 0; i < VehicleInsurance.ChildName.length; i++) {
                        DocumentsTypeModel model = new DocumentsTypeModel(VehicleInsurance.ChildName[i]);
                        documentsTypeModels.add(model);
                    }
                } else if (uploadDocumentsModels.get(position).getParentName().equals("Step 3:Vehicle Permit")) {

                    for (int i = 0; i < VehiclePermit.ChildName.length; i++) {
                        DocumentsTypeModel model = new DocumentsTypeModel(VehiclePermit.ChildName[i]);
                        documentsTypeModels.add(model);
                    }
                } else if (uploadDocumentsModels.get(position).getParentName().equals("Step 4:Vehicle Registration")) {

                    for (int i = 0; i < VehicleRegistration.ChildName.length; i++) {
                        DocumentsTypeModel model = new DocumentsTypeModel(VehicleRegistration.ChildName[i]);
                        documentsTypeModels.add(model);
                    }
                }
                c=1;
            }
            else if(c==1){
                holder.mUp.setVisibility(View.GONE);
                holder.recyclerView.setVisibility(View.GONE);
                c=0;
            }


        } else {
            holder.mUp.setVisibility(View.GONE);
            holder.recyclerView.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = position;
                select.Choose(position);
                notifyDataSetChanged();

            }
        });






//
//
//        documentsTypeModels = new ArrayList<>();
//        for (int i = 0; i < VehicleInformationChild.ChildName.length; i++) {
//            DocumentsTypeModel model = new DocumentsTypeModel(VehicleInformationChild.ChildName[i]);
//            documentsTypeModels.add(model);
//        }


        uploadDocumentsChildAdapter = new UploadDocumentsChildAdapter(documentsTypeModels, context, new UploadDocumentsChildAdapter.Select() {
            @Override
            public void Choose(int position) {

                Toast.makeText(context, "position=" + position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.recyclerView.setAdapter(uploadDocumentsChildAdapter);
        uploadDocumentsChildAdapter.notifyDataSetChanged();


    }


    @Override
    public int getItemCount() {
        return uploadDocumentsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView mTextTitleParent;
        ImageView mDown, mUp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.rv_child);
            mTextTitleParent = itemView.findViewById(R.id.tv_textTitle_parent);
            mDown = itemView.findViewById(R.id.iv_arrow_down);
            mUp = itemView.findViewById(R.id.iv_arrow_up);
        }
    }
}

