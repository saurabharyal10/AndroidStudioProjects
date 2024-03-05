package com.example.mobileprogrammingprojects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.mobileprogrammingprojects.movie.MovieContainer;
import com.example.mobileprogrammingprojects.movie.Results;
import com.google.gson.Gson;
import com.example.mobileprogrammingprojects.movie.MovieContainer;
import com.example.mobileprogrammingprojects.movie.Results;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Results> movieResult = new ArrayList<>();
    private ListAdapter adapter;
    private MovieContainer movieData;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = new DBHandler(ProductListActivity.this);
        JSONAsyncTask asyncTask = new JSONAsyncTask();
        asyncTask.execute("https://www.tutorialspoint.com/images/tp-logo-diamond.png");
        setContentView(R.layout.activity_product_list);

        setData();
        dbHandler.getData();
        saveDatabase();
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
    private void saveDatabase() {
        dbHandler.addNewCourse("Binod", "BCA 6th sem", "Samakhusi", "Mobile Programming");
        dbHandler.addNewCourse("Sujata", "BCA 6th sem", "Samakhusi", "Mobile Programming");
        dbHandler.addNewCourse("Shyan", "BIM 6th sem", "Samakhusi", "DevOps");
        dbHandler.addNewCourse("Pramod", "BSC CSIT 6th sem", "Samakhusi", "Network Programming");
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
        listView = findViewById(R.id.listView);
        adapter = new ListAdapter(productList, ProductListActivity.this);
        listView.setAdapter(adapter);
    }
    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {
        ProgressDialog p = new ProgressDialog(ProductListActivity.this);
        ;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p.setMessage("Please wait...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();

        }

        @Override
        protected Boolean doInBackground(String... urls) {

            //------------------>>
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://api.themoviedb.org/3/movie/upcoming?api_key=ef8f48b43832a9e95b87408bf739ed51")
                    .build();
            Response responses = null;


            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.d("Page Vale", String.valueOf(e.getLocalizedMessage()));
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    p.dismiss();
                    if (response.isSuccessful()) {
                        String jsonData = response.body().string();
                        JSONObject Jobject = null;

                        Gson gsonObj = new Gson();

                        movieData = gsonObj.fromJson(jsonData, MovieContainer.class);
                        movieResult.clear();
                        movieResult.addAll(movieData.getResultList());
//                        try {
//                            Jobject = new JSONObject(jsonData);
//                            JSONArray Jarray = Jobject.getJSONArray("results");
//
//                            for (int i = 0; i < Jarray.length(); i++) {
//                                JSONObject object = Jarray.getJSONObject(i);
//                                Log.d("Title", object.getString("title"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }


                    }
                }
            });


            return false;
        }

        protected void onPostExecute(Boolean result) {

        }
    }
}