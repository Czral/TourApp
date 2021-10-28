package com.example.android.tourapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.android.tourapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private final String[] TITLES = {"Hotels", "Food", "Night", "Sights"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        binding.viewPager.setAdapter(new FragmentAdapter(this));

        TabLayoutMediator.TabConfigurationStrategy strategy = (tab, position) -> tab.setText(TITLES[position]);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, strategy).attach();

        binding.tabLayout.setTabTextColors(ResourcesCompat.getColor(getResources(), R.color.white, null),
                ResourcesCompat.getColor(getResources(), R.color.tab_indicator, null));

    }

}