package com.example.android.tourapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by XXX on 13-Mar-18.
 */

public class HistoryElementAdapter extends ArrayAdapter {

    public HistoryElementAdapter(Context context, ArrayList<HistoryElement> historyElements) {
        super(context, 0, historyElements);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_history, parent, false);
        }

        HistoryElement currentHistoryElement = (HistoryElement) getItem(position);

        ImageView imageView = listView.findViewById(R.id.image);
        imageView.setImageResource(currentHistoryElement.getImage());

        TextView nameText = listView.findViewById(R.id.name_text);
        nameText.setText(currentHistoryElement.getName());

        TextView addressText = listView.findViewById(R.id.address_text);
        addressText.setText(currentHistoryElement.getAddress());

        String hoursMonday = String.format(Locale.US, getContext().getString(R.string.monday), currentHistoryElement.getHoursMonday());
        TextView hoursMondayText = listView.findViewById(R.id.hours_monday_text);
        hoursMondayText.setText(hoursMonday);

        String hoursTuesday = String.format(Locale.US, getContext().getString(R.string.tuesday), currentHistoryElement.getHoursTuesday());
        TextView hoursTuesdayText = listView.findViewById(R.id.hours_tuesday_text);
        hoursTuesdayText.setText(hoursTuesday);

        String hoursWednesday = String.format(Locale.US, getContext().getString(R.string.wednesday), currentHistoryElement.getHoursWednesday());
        TextView hoursWednesdayText = listView.findViewById(R.id.hours_wednesday_text);
        hoursWednesdayText.setText(hoursWednesday);

        String hoursThursday = String.format(Locale.US, getContext().getString(R.string.thursday), currentHistoryElement.getHoursThursday());
        TextView hoursThursdayText = listView.findViewById(R.id.hours_thursday_text);
        hoursThursdayText.setText(hoursThursday);

        String hoursFriday = String.format(Locale.US, getContext().getString(R.string.friday), currentHistoryElement.getHoursFriday());
        TextView hoursFridayText = listView.findViewById(R.id.hours_friday_text);
        hoursFridayText.setText(hoursFriday);

        String hoursSaturday = String.format(Locale.US, getContext().getString(R.string.saturday), currentHistoryElement.getHoursSaturday());
        TextView hoursSaturdayText = listView.findViewById(R.id.hours_saturday_text);
        hoursSaturdayText.setText(hoursSaturday);

        String hoursSunday = String.format(Locale.US, getContext().getString(R.string.sunday), currentHistoryElement.getHoursSunday());
        TextView hoursSundayText = listView.findViewById(R.id.hours_sunday_text);
        hoursSundayText.setText(hoursSunday);

        TextView phoneText = listView.findViewById(R.id.phone_text);
        phoneText.setText(currentHistoryElement.getPhone());

        RatingBar ratingBar = listView.findViewById(R.id.rating_bar);
        ratingBar.setRating(currentHistoryElement.getRating());
        ratingBar.setIsIndicator(true);

        return listView;

    }
}