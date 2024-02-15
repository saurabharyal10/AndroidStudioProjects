package com.example.androidfinalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText editUsername, editPassword, editConfirmPassword, editEmail, editContactNo;
    private RadioGroup radioGroup;
    private CheckBox chkReading, chkWriting, chkMusic, chkGame, chkDrawing;
    private Button btnSignUp;


    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();
        setOnClick();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            String username = editUsername.getText().toString();
                            String contactNumber = editContactNo.getText().toString();
                            String password = editPassword.getText().toString();
                            String email = editEmail.getText().toString();
                            final String value = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId()))
                                    .getText().toString();

                            User user = new User(username, password, email, value, contactNumber);

                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);
                            Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(SignupActivity.this, "Sign up Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
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
        String username = editUsername.getText().toString();
        String contactNumber = editContactNo.getText().toString();
        String password = editPassword.getText().toString();
        String confirmPassword = editConfirmPassword.getText().toString();
        String email = editEmail.getText().toString();
        final String value = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId()))
                            .getText().toString();
        Log.d("GenderValue", value);


        if (chkReading.isChecked())
            Log.d("CheckBox", chkReading.getText().toString());
        if (chkWriting.isChecked())
            Log.d("CheckBox", chkWriting.getText().toString());
        if (chkMusic.isChecked())
            Log.d("CheckBox", chkMusic.getText().toString());
        if (chkGame.isChecked())
            Log.d("CheckBox", chkGame.getText().toString());
        if (chkDrawing.isChecked())
            Log.d("CheckBox", chkDrawing.getText().toString());

        if (username.equals("")) {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (confirmPassword.equals("")) {
            Toast.makeText(this, "Confirm Password cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Password and confirm password did not match", Toast.LENGTH_SHORT).show();
        }else if (email.equals("")) {
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (contactNumber.equals("")) {
            Toast.makeText(this, "Contact Number cannot be empty", Toast.LENGTH_SHORT).show();
        } else if (!contactNumber.equals(10)) {
            Toast.makeText(this, "Contact Number should be of ten numbers", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sign up successfully", Toast.LENGTH_SHORT).show();
        }
    }

    void findViews() {
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        editEmail = findViewById(R.id.editEmail);
        radioGroup = findViewById(R.id.radioGroup);
        chkReading = findViewById(R.id.chkReading);
        chkWriting = findViewById(R.id.chkWriting);
        chkMusic = findViewById(R.id.chkMusic);
        chkGame = findViewById(R.id.chkGame);
        chkDrawing = findViewById(R.id.chkDrawing);
        editContactNo = findViewById(R.id.editContactNo);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
}