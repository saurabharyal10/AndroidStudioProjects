package com.example.mobileprogrammingprojects;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductVH extends RecyclerView.ViewHolder {
    public TextView txtProductTitle, txtProductUnit, txtProductQuantity;

    public ProductVH(@NonNull View itemView) {
        super(itemView);
        txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
        txtProductUnit = itemView.findViewById(R.id.txtProductUnit);
        txtProductQuantity = itemView.findViewById(R.id.txtProductQuantity);
    }
}
