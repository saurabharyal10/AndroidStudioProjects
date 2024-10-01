package com.example.nepalairlink;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CategoryFragment extends Fragment {

    private View mainView;
    private TextView txtCategory;
    private EditText edtEmailAddress;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mainView = inflater.inflate(R.layout.fragment_category, container, false);
        findView();
        return  mainView;
    }

    private void findView(){
        txtCategory = mainView.findViewById(R.id.txtCategory);
        edtEmailAddress = mainView.findViewById(R.id.edtEmailAddress);
    }
}