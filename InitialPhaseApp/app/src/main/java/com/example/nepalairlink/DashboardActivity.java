package com.example.nepalairlink;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    private String username, password;
    private boolean isLogin;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppCompatButton btnSend;

    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_categories,
            R.drawable.ic_favorite,
            R.drawable.ic_profile,
            R.drawable.ic_settings,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        isLogin = getIntent().getBooleanExtra("isLogin", false);
        Toast.makeText(this, username + " " + password + " " + isLogin, Toast.LENGTH_SHORT).show();

        initToolbar();
        findViews();
        setupViewpager();
        tabLayout.setupWithViewPager(viewPager);
        setTabIcon();
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#ff33b5e5"), PorterDuff.Mode.SRC_IN);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#ff33b5e5"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#FFFFFFFF"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    void setTabIcon() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    void initToolbar() {
        toolbar = findViewById(R.id.lytToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.title_main);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.insta_icon);
    }

    private void findViews() {
        tabLayout = findViewById(R.id.lytTab);
        viewPager = findViewById(R.id.viewPager);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Value", "Result get");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void setupViewpager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new CategoryFragment(), "Category");
        adapter.addFragment(new FavoriteFragment(), "Favorite");
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new SettingsFragment(), "Settings");
        viewPager.setAdapter(adapter);

    }
}