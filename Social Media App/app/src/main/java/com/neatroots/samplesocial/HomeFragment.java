package com.neatroots.samplesocial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView storyRV, dashboardRV;
    ArrayList<StoryModel> storyList;
    ArrayList<DashboardModel> dashboardList;
    ImageView addStory;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Story Recycler View
        storyRV = view.findViewById(R.id.storyRV);
        storyList = new ArrayList<>();
        storyList.add(new StoryModel(R.drawable.dennis,R.drawable.deaf,"Darshil",R.drawable.ic_video_camera));
        storyList.add(new StoryModel(R.drawable.nature_dordogne,R.drawable.art,"Bhuva",R.drawable.ic_video_camera));
        storyList.add(new StoryModel(R.drawable.profile1,R.drawable.profile,"Bhuva",R.drawable.ic_live));
        StoryAdapter adapter = new StoryAdapter(storyList,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true);
        storyRV.setLayoutManager(layoutManager);
        storyRV.setNestedScrollingEnabled(false);
        storyRV.setAdapter(adapter);

        //Dashboard Recycler View
        dashboardRV = view.findViewById(R.id.dashboardRV);
        dashboardList = new ArrayList<>();
        dashboardList.add(new DashboardModel(R.drawable.hipster,R.drawable.new_hope,"New Hope","Traveler, life Lover","247","57","33"));
        dashboardList.add(new DashboardModel(R.drawable.dennis,R.drawable.dennis_kane,"Dennis Kane","Photographer","247","57","33"));
        dashboardList.add(new DashboardModel(R.drawable.nature1,R.drawable.nature,"Alicia ","Traveler, life Lover","247","57","33"));
        dashboardList.add(new DashboardModel(R.drawable.art,R.drawable.nature_dordogne,"Alicia ","Traveler, life Lover","247","57","33"));
        DashboardAdapter dashboardAdapter = new DashboardAdapter(dashboardList,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        dashboardRV.setLayoutManager(linearLayoutManager);
        dashboardRV.addItemDecoration(new DividerItemDecoration(dashboardRV.getContext(), DividerItemDecoration.VERTICAL));
        dashboardRV.setNestedScrollingEnabled(false);
        dashboardRV.setAdapter(dashboardAdapter);


        addStory = view.findViewById(R.id.addStory);
        addStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}