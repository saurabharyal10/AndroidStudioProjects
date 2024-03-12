package com.example.mobileprogrammingprojects;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MoreFragment extends Fragment {

    private View mainView;
    private Button btnChange;
    private int i = 0;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_more, container, false);
        findViews();
        initToolbar();
        setupViewpager();
        return mainView;
    }

    void initToolbar() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i % 2 == 0) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new Image1Fragment()).addToBackStack("Home").commit();
                } else {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new FavoriteFragment()).addToBackStack("Category").commit();
                }
                i++;
            }
        });
    }
    private void findViews() {
        btnChange = mainView.findViewById(R.id.btnChange);
        viewPager = mainView.findViewById(R.id.viewPager);
    }
    private void setupViewpager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

    }
}