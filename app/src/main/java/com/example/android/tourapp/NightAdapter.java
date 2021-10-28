package com.example.android.tourapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NightAdapter extends RecyclerView.Adapter<NightAdapter.NightViewHolder> {

    private static ArrayList<NightElement> nightElements;

    public static class NightViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView addressTextView;
        private final TextView phoneTextView;
        private final TextView descriptionTextView;
        private final TextView openHoursTextView;

        @SuppressLint("QueryPermissionsNeeded")
        public NightViewHolder(View view) {
            super(view);

            Context context = view.getContext();

            nameTextView = view.findViewById(R.id.name_text);
            addressTextView = view.findViewById(R.id.address_text);
            phoneTextView = view.findViewById(R.id.phone_text);
            descriptionTextView = view.findViewById(R.id.description_text);
            openHoursTextView = view.findViewById(R.id.opening_hours_text);

            phoneTextView.setOnClickListener(v -> {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(context.getString(R.string.tel) + nightElements.get(getAdapterPosition()).getPhone()));
                if (callIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(callIntent);
                }
            });

            addressTextView.setOnClickListener(v -> {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(context.getString(R.string.geo) +
                        nightElements.get(getAdapterPosition()).getAddress() +
                        context.getString(R.string.athens)));
                if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(mapIntent);
                }
            });
        }
    }

    public NightAdapter(ArrayList<NightElement> nights) {
        nightElements = nights;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public NightAdapter.NightViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.night_list_item, viewGroup, false);

        return new NightAdapter.NightViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull NightAdapter.NightViewHolder viewHolder, final int position) {

        NightElement currentNight = nightElements.get(position);

        viewHolder.nameTextView.setText(currentNight.getName());
        viewHolder.addressTextView.setText(currentNight.getAddress());
        viewHolder.phoneTextView.setText(currentNight.getPhone());
        viewHolder.descriptionTextView.setText(currentNight.getDescription());
        viewHolder.openHoursTextView.setText(currentNight.getHours());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (nightElements != null) {

            return nightElements.size();
        }
        return 0;
    }
}