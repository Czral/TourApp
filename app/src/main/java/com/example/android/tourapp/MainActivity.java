package com.example.android.tourapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), this));

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this);

        viewPager.setAdapter(fragmentAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(ResourcesCompat.getColor(getResources(), R.color.white, null), ResourcesCompat.getColor(getResources(), R.color.tab_indicator, null));

    }

}