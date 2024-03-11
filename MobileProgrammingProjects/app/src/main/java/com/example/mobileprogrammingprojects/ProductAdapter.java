package com.example.mobileprogrammingprojects;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductVH> {
    private ArrayList<Product> productList = new ArrayList<>();
    private Context mContext;
    public  ProductAdapter(ArrayList<Product> productList, Context context){
        this.productList=productList;
        mContext=context;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product,parent, false);
        return new ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Product obj=productList.get(position);
        holder.txtProductTitle.setText(obj.getProductName());
        holder.txtProductQuantity.setText(String.valueOf(obj.getQuantity()));
        holder.txtProductUnit.setText(obj.getUnit());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DashboardActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
