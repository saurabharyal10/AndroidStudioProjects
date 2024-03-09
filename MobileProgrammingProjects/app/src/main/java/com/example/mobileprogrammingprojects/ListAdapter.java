package com.example.mobileprogrammingprojects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private ArrayList<Product> mData = new ArrayList<>();
    private Context mContext;

    public ListAdapter(ArrayList<Product> data, Context context) {
        mData.addAll(data);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Product getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.adapter_product, null);
        ViewHolder holder = new ViewHolder(view);


        holder.txtProductTitle.setText(mData.get(position).getProductName());
        holder.txtProductQuantity.setText(String.valueOf(mData.get(position).getQuantity()));
        holder.txtProductUnit.setText(mData.get(position).getUnit());
        return view;
    }


    public static class ViewHolder {

        public ViewHolder(View view) {
            txtProductTitle = view.findViewById(R.id.txtProductTitle);
            txtProductUnit = view.findViewById(R.id.txtProductUnit);
            txtProductQuantity = view.findViewById(R.id.txtProductQuantity);
        }


        public TextView txtProductTitle, txtProductUnit, txtProductQuantity;
    }

}