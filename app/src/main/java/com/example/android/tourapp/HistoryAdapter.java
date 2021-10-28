package com.example.android.tourapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private static ArrayList<HistoryElement> historyElements;

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView addressTextView;
        private final TextView phoneTextView;

        private final TextView mondayTextView;
        private final TextView tuesdayTextView;
        private final TextView wednesdayTextView;
        private final TextView thursdayTextView;
        private final TextView fridayTextView;
        private final TextView saturdayTextView;
        private final TextView sundayTextView;

        private final RatingBar ratingBar;

        private final ImageView imageView;

        @SuppressLint("QueryPermissionsNeeded")
        public HistoryViewHolder(View view) {
            super(view);

            Context context = view.getContext();

            nameTextView = view.findViewById(R.id.name_text);
            addressTextView = view.findViewById(R.id.address_text);
            phoneTextView = view.findViewById(R.id.phone_text);
            mondayTextView = view.findViewById(R.id.hours_monday_text);
            tuesdayTextView = view.findViewById(R.id.hours_tuesday_text);
            wednesdayTextView = view.findViewById(R.id.hours_wednesday_text);
            thursdayTextView = view.findViewById(R.id.hours_thursday_text);
            fridayTextView = view.findViewById(R.id.hours_friday_text);
            saturdayTextView = view.findViewById(R.id.hours_saturday_text);
            sundayTextView = view.findViewById(R.id.hours_sunday_text);

            ratingBar = view.findViewById(R.id.rating_bar);

            imageView = view.findViewById(R.id.image);

            phoneTextView.setOnClickListener(v -> {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(context.getString(R.string.tel) + historyElements.get(getAdapterPosition()).getPhone()));
                if (callIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(callIntent);
                }
            });

            addressTextView.setOnClickListener(v -> {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(context.getString(R.string.geo) +
                        historyElements.get(getAdapterPosition()).getAddress() +
                        context.getString(R.string.athens)));
                if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(mapIntent);
                }
            });
        }
    }

    public HistoryAdapter(ArrayList<HistoryElement> histories) {
        historyElements = histories;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.history_list_item, viewGroup, false);

        return new HistoryAdapter.HistoryViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder viewHolder, final int position) {

        HistoryElement currentHistory = historyElements.get(position);

        Context context = viewHolder.itemView.getContext();

        viewHolder.nameTextView.setText(currentHistory.getName());
        viewHolder.addressTextView.setText(currentHistory.getAddress());
        viewHolder.phoneTextView.setText(currentHistory.getPhone());

        viewHolder.imageView.setImageResource(currentHistory.getImage());

        viewHolder.mondayTextView.setText(String.format(Locale.US,
                context.getString(R.string.monday), currentHistory.getHoursMonday()));
        viewHolder.tuesdayTextView.setText(String.format(Locale.US,
                context.getString(R.string.tuesday), currentHistory.getHoursTuesday()));
        viewHolder.wednesdayTextView.setText(String.format(Locale.US,
                context.getString(R.string.wednesday), currentHistory.getHoursWednesday()));
        viewHolder.thursdayTextView.setText(String.format(Locale.US,
                context.getString(R.string.thursday), currentHistory.getHoursThursday()));
        viewHolder.fridayTextView.setText(String.format(Locale.US,
                context.getString(R.string.friday), currentHistory.getHoursFriday()));
        viewHolder.saturdayTextView.setText(String.format(Locale.US,
                context.getString(R.string.saturday), currentHistory.getHoursSaturday()));
        viewHolder.sundayTextView.setText(String.format(Locale.US,
                context.getString(R.string.sunday), currentHistory.getHoursSunday()));
        viewHolder.phoneTextView.setText(currentHistory.getPhone());
        viewHolder.ratingBar.setRating(currentHistory.getRating());
        viewHolder.ratingBar.setIsIndicator(true);
    }

    @Override
    public int getItemCount() {
        if (historyElements != null) {

            return historyElements.size();
        }
        return 0;
    }
}