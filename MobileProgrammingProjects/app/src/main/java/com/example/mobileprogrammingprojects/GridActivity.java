package com.example.mobileprogrammingprojects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private GridView gridView;
    private ArrayList<Product> productList = new ArrayList<>();
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initToolbar();
        setData();
        findViews();
    }

    private void setData() {
        Product mobile = new Product();
        mobile.setProductName("Samsung");
        mobile.setQuantity(40);
        mobile.setUnit("Pcs");
        Product mobile1 = new Product();
        mobile.setProductName("Apple");
        mobile.setQuantity(30);
        mobile.setUnit("Pcs");
        Product mobile2 = new Product();
        mobile.setProductName("Nokia");
        mobile.setQuantity(60);
        mobile.setUnit("Pcs");
        Product mobile3 = new Product();
        mobile.setProductName("Motorola");
        mobile.setQuantity(90);
        mobile.setUnit("Pcs");
        productList.add(mobile);
        productList.add(mobile1);
        productList.add(mobile2);
        productList.add(mobile3);
    }

    void initToolbar() {
        toolbar = findViewById(R.id.lytToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.title_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_user);
    }

    void findViews() {
        gridView = findViewById(R.id.gridView);
        adapter = new ListAdapter(productList, GridActivity.this);
        gridView.setAdapter(adapter);
    }
}