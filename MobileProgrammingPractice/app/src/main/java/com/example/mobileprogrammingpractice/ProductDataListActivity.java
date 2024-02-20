package com.example.mobileprogrammingpractice;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        Product account = new Product();
        account.setName("Binod");
        account.setAddress("Kathmandu");

        Product account1 = new Product();
        account1.setName("Pramod");
        account1.setAddress("Nuwakot");

        Product account2 = new Product();
        account2.setName("Sanaya");
        account2.setAddress("Basundhara");

        Product account3 = new Product();
        account3.setName("Saurabh");
        account3.setAddress("Tanahun");

        Product account4 = new Product();
        account4.setName("Shijal");
        account4.setAddress("Chitwan");

        productList.add(account);
        productList.add(account1);
        productList.add(account2);
        productList.add(account3);
        productList.add(account4);
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