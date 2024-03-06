package com.example.mobileprogrammingprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText editUsername, editPassword, editConfirmPassword, editContactNo;
    private TextView txtPreview;
    private CheckBox chkCoding, chkDesigning, chkQA;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();
        setOnClick();
    }

    void setOnClick() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateSignupForm();
            }
        });
    }

    void validateSignupForm() {
        String name = editUsername.getText().toString();
        String contactNumber = editContactNo.getText().toString();
        String password = editPassword.getText().toString();
        String confirmPassword = editConfirmPassword.getText().toString();


        if (chkCoding.isChecked())
            Log.d("CheckBox", chkCoding.getText().toString());
        if (chkDesigning.isChecked())
            Log.d("CheckBox", chkDesigning.getText().toString());
        if (chkQA.isChecked())
            Log.d("CheckBox", chkQA.getText().toString());

        if (name.equals("")) {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (contactNumber.equals("")) {
            Toast.makeText(this, "Contact Number cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (confirmPassword.equals("")) {
            Toast.makeText(this, "Confirm Password cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Password and confirm password did not match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sign up successfully", Toast.LENGTH_SHORT).show();
        }

    }

    void findViews() {
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editContactNo = findViewById(R.id.editContactNo);

        chkCoding = findViewById(R.id.chkCoding);
        chkDesigning = findViewById(R.id.chkDesigning);
        chkQA = findViewById(R.id.chkQA);

        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        txtPreview = findViewById(R.id.txtPreview);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
}