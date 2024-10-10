package com.example.nepalairlink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private AppCompatSpinner spnCountry;
    private View mainView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_home, container, false);
        findViews();
        initToolbar();
        return mainView;
    }

    void initToolbar() {
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.country));
        spnCountry.setAdapter(adapter);
    }
    private void findViews() {
        spnCountry = mainView.findViewById(R.id.spnCountry);

    }

}