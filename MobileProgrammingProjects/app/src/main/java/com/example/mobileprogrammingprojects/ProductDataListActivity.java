package com.example.mobileprogrammingprojects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class ProductDataListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView productRecyclerView;
    private ArrayList<Product> productList = new ArrayList<>();
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_data_list);
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
        mobile1.setProductName("Apple");
        mobile1.setQuantity(30);
        mobile1.setUnit("Pcs");
        Product mobile2 = new Product();
        mobile2.setProductName("Nokia");
        mobile2.setQuantity(60);
        mobile2.setUnit("Pcs");
        Product mobile3 = new Product();
        mobile3.setProductName("Motorolla");
        mobile3.setQuantity(90);
        mobile3.setUnit("Pcs");
        productList.add(mobile);
        productList.add(mobile1);
        productList.add(mobile2);
        productList.add(mobile3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            toolbar.setTitle("Profile");
        else if (item.getItemId() == R.id.cart){
            setData();
            adapter.notifyDataSetChanged();
        }
        else if (item.getItemId() == R.id.search)
            toolbar.setTitle("Search");
        return super.onOptionsItemSelected(item);
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
        productRecyclerView = findViewById(R.id.productRecyclerView);
        adapter = new ProductAdapter(productList, ProductDataListActivity.this);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this, 3);
        productRecyclerView.setLayoutManager(layoutManager);
        productRecyclerView.setAdapter(adapter);
    }
}