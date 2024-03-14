package com.example.mobileprogrammingprojects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomepageActivity extends AppCompatActivity {

    private TextView txtLogin, txtSignUp;
    private EditText editUsername;
    private EditText editPassword;
    private EditText editConfirmPassword;
//    private EditText rdMale, rdFemale;
    private EditText editContactNo;
    private Button btnLogin, btnSignUp;
    private TextView txtPreview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        setOnClick();
        findViews();
    }
    void setOnClick() {
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this,SignupActivity.class);
//                startActivityForResult(intent,300);
//                finish();
                startActivity(intent);

            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, SignupActivity.class);
                startActivity(intent);
//                finish();

                if(editUsername.getText().toString().equals(""))
                    txtPreview.setText("Username is required");
                else if(editPassword.getText().toString().equals(""))
                    txtPreview.setText("Password is required");
                else if(editConfirmPassword.getText().toString().equals(""))
                    txtPreview.setText("Confirm Password is required");
                else if(editContactNo.getText().toString().equals(""))
                    txtPreview.setText("Contact No. is required");
                else{
                    String username = editUsername.getText().toString();
                    String password = editPassword.getText().toString();
                    String contactNo = editContactNo.getText().toString();
//                    String gender = rdMale.getText().toString();
//                    String gender = rdFemale.getText().toString();
                    txtPreview.setText("Username:"+username +"\n"+ "Password:"+password+"\n"+
                            "Contact No.:"+contactNo+"\n");
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
                startActivity(intent);

                if(editUsername.getText().toString().equals(""))
                    txtPreview.setText("Username cannot be empty");
                else if(editPassword.getText().toString().equals(""))
                    txtPreview.setText("Password cannot be empty");
                else{
                    String username = editUsername.getText().toString();
                    String password = editPassword.getText().toString();
                    txtPreview.setText("Username:"+username +"\n"+ "Password:"+password);
                }
            }
        });
    }

    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(requestCode==100&& resultCode==RESULT_OK){
//            String returnString = data.getStringExtra("Value");
//
//            Log.d("Data", returnString);
//        }else if(requestCode==300&& resultCode==RESULT_OK){
//            Log.d("Data", data.getData().toString());
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    void findViews () {
        txtLogin = findViewById(R.id.txtLogin);
        txtSignUp = findViewById(R.id.txtSignUp);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        editContactNo = findViewById(R.id.editContactNo);
//        rdMale = findViewById(R.id.rdMale);
//        rdFemale = findViewById(R.id.rdFemale);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtPreview = findViewById(R.id.txtPreview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == android.R.id.home)
//            toolbar.setTitle("Profile");
//        else if (item.getItemId() == R.id.cart)
//            toolbar.setTitle("Cart");
//        else if (item.getItemId() == R.id.search)
//            toolbar.setTitle("Search");
        return super.onOptionsItemSelected(item);
    }
}