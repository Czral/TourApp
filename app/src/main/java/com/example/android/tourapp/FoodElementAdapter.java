package com.example.android.tourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by XXX on 14-Mar-18.
 */

public class FoodElementAdapter extends ArrayAdapter {

    public FoodElementAdapter(Context context, ArrayList<FoodElement> foodElements) {
        super(context, 0, foodElements);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_food, parent, false);
        }

        FoodElement currentFood = (FoodElement) getItem(position);

        TextView nameText = listView.findViewById(R.id.name_text);
        nameText.setText(currentFood.getName());

        TextView addressText = listView.findViewById(R.id.address_text);
        addressText.setText(currentFood.getAddress());

        TextView phoneText = listView.findViewById(R.id.phone_text);
        phoneText.setText(currentFood.getPhone());

        RatingBar serviceBar = listView.findViewById(R.id.service_rating_bar);
        serviceBar.setRating(currentFood.getService());

        RatingBar foodBar = listView.findViewById(R.id.food_rating_bar);
        foodBar.setRating(currentFood.getFood());

        RatingBar valueBar = listView.findViewById(R.id.value_rating_bar);
        valueBar.setRating(currentFood.getValue());

        return listView;

    }
}