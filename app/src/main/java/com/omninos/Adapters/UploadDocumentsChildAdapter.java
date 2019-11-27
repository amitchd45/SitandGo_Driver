package com.omninos.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omninos.Models.DocumentsTypeModel;
import com.omninos.connekma_driver.R;

import java.util.ArrayList;

public class UploadDocumentsChildAdapter extends RecyclerView.Adapter<UploadDocumentsChildAdapter.ViewHolder> {

    ArrayList<DocumentsTypeModel> documentsTypeModels;
    Context context;
    UploadDocumentsChildAdapter.Select select;
    int a =-1;

    public static interface Select {
        void Choose(int position);
    }


        public UploadDocumentsChildAdapter(ArrayList<DocumentsTypeModel> documentsTypeModels, Context context, Select select) {
        this.documentsTypeModels = documentsTypeModels;
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.documents_type_child_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTextTitleChild.setText(documentsTypeModels.get(position).getChildName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=position;
                select.Choose(position);
                notifyDataSetChanged();
            }
        });

        if (position==a){
            holder.mCheck.setVisibility(View.VISIBLE);
        }else {
            holder.mCheck.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return documentsTypeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextTitleChild;
        ImageView mCheck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextTitleChild = itemView.findViewById(R.id.tv_textTitle_child);
            mCheck = itemView.findViewById(R.id.iv_check);
        }
    }
}
