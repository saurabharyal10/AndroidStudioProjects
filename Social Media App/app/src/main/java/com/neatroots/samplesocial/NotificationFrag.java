package com.neatroots.samplesocial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class NotificationFrag extends Fragment {

    RecyclerView notificationRV;
    ArrayList<NotificationModel> list;

    public NotificationFrag() {
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
        View view = inflater.inflate(R.layout.fragment_notification2, container, false);
        notificationRV = view.findViewById(R.id.notificationRV);
        list = new ArrayList<>();
        list.add(new NotificationModel(R.drawable.profile1,"<b>Alicia Addams</b> mention you in a comment: Nice Try","just now"));
        list.add(new NotificationModel(R.drawable.deaf,"<b>Janeeleona</b> Liked your picture.","40 minutes ago"));
        list.add(new NotificationModel(R.drawable.cover,"<b>Katherinn</b> Commented on your post.","2 hours"));
        list.add(new NotificationModel(R.drawable.art,"<b>Alicia Addams</b> mention you in a comment: Nice Try","3 hours"));
        list.add(new NotificationModel(R.drawable.profile,"<b>Janeeleona</b> Liked your picture.","3 hours"));
        list.add(new NotificationModel(R.drawable.dennis,"<b>Katherinn</b> Commented on your post.","4 hours"));
        list.add(new NotificationModel(R.drawable.profile1,"<b>Alicia Addams</b> mention you in a comment: Nice Try","4 hours"));
        list.add(new NotificationModel(R.drawable.profile,"<b>Janeeleona</b> Liked your picture.","4 hours"));
        list.add(new NotificationModel(R.drawable.cover,"<b>Katherinn</b> Commented on your post.","4 hours"));



        NotificationAdapter adapter = new NotificationAdapter(list, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        notificationRV.setLayoutManager(layoutManager);
        notificationRV.setNestedScrollingEnabled(false);
        notificationRV.setAdapter(adapter);

        return view;
    }
}