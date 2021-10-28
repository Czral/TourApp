package com.example.android.tourapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Created by XXX on 13-Mar-18.
 */

public class FragmentAdapter extends FragmentStateAdapter {

    private Context mContext;

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new HotelFragment();
        } else if (position == 1) {
            return new FoodFragment();
        } else if (position == 2) {
            return new NightFragment();
        } else {
            return new HistoryFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}