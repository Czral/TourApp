package com.example.android.tourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by XXX on 15-Mar-18.
 */

public class NightElementAdapter extends ArrayAdapter {

    public NightElementAdapter(Context context, ArrayList<NightElement> nightElements) {
        super(context, 0, nightElements);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_night, parent, false);
        }

        NightElement currentNight = (NightElement) getItem(position);

        TextView nameText = listView.findViewById(R.id.name_text);
        nameText.setText(currentNight.getName());

        TextView addressText = listView.findViewById(R.id.address_text);
        addressText.setText(currentNight.getAddress());

        TextView phoneText = listView.findViewById(R.id.phone_text);
        phoneText.setText(currentNight.getPhone());

        TextView descriptionText = listView.findViewById(R.id.description_text);
        descriptionText.setText(currentNight.getDescription());

        TextView hoursText = listView.findViewById(R.id.opening_hours_text);
        hoursText.setText(currentNight.getHours());

        return listView;
    }
}