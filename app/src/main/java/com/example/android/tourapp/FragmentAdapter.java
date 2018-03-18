package com.example.android.tourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by XXX on 13-Mar-18.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
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
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getResources().getString(R.string.hotels);
        } else if (position == 1) {
            return mContext.getResources().getString(R.string.food);
        } else if (position == 2) {
            return mContext.getResources().getString(R.string.nightlife);
        } else {
            return mContext.getResources().getString(R.string.sights);
        }

    }
}