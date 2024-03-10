package com.example.mobileprogrammingprojects;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private View mainView;
    private EditText edtName, edtAddress, edtPhone, edtEmailAddress;
    private TextView txtPreview;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mainView = inflater.inflate(R.layout.fragment_profile, container, false);
        findViews();
        setOnClick();
        return mainView;
    }

    void setOnClick() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtName.getText().toString().equals(""))
                    txtPreview.setText("Name cannot be empty");
                else if (edtAddress.getText().toString().equals(""))
                    txtPreview.setText("Address cannot be empty");
                else if (edtPhone.getText().toString().equals(""))
                    txtPreview.setText("Phone cannot be empty");
                else if (edtEmailAddress.getText().toString().equals(""))
                    txtPreview.setText("Email Address cannot be empty");
                else {
                    String name = edtName.getText().toString();
                    String address = edtAddress.getText().toString();
                    String phone = edtPhone.getText().toString();
                    String emailAddress = edtEmailAddress.getText().toString();

                    txtPreview.setText("Name :" + name + "\n" + "Address :" + address + "\n" +
                            "Phone :" + phone + "\n" + "Email Address :" + emailAddress + "\n");

                }
            }
        });
    }

    private void findViews() {
        edtName = mainView.findViewById(R.id.edtName);
        edtAddress = mainView.findViewById(R.id.edtAddress);
        edtPhone = mainView.findViewById(R.id.edtPhone);
        edtEmailAddress = mainView.findViewById(R.id.edtEmailAddress);
        btnSubmit = mainView.findViewById(R.id.btnSubmit);
        txtPreview = mainView.findViewById(R.id.txtPreview);
    }
}