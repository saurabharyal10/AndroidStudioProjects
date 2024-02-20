package com.example.mobileprogrammingpractice;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductVH  extends RecyclerView.ViewHolder {
    public TextView txtName, txtAddress;

    public ProductVH(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtAddress = itemView.findViewById(R.id.txtAddress);
    }
}
