package com.example.android.tourapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by XXX on 15-Mar-18.
 */

public class HotelElementAdapter extends RecyclerView.Adapter<HotelElementAdapter.HotelViewHolder> {

    private static ArrayList<FoodHistoryElement> hotelElements;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class HotelViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView addressTextView;
        private final TextView phoneTextView;
        private final TextView hotelTextView;

        private final RatingBar serviceRatingBar;
        private final RatingBar foodRatingBar;
        private final RatingBar valueRatingBar;

        @SuppressLint("QueryPermissionsNeeded")
        public HotelViewHolder(View view) {
            super(view);

            Context context = view.getContext();

            hotelTextView = view.findViewById(R.id.food_text);
            nameTextView = view.findViewById(R.id.name_text);
            addressTextView = view.findViewById(R.id.address_text);
            phoneTextView = view.findViewById(R.id.phone_text);

            serviceRatingBar = view.findViewById(R.id.service_rating_bar);
            foodRatingBar = view.findViewById(R.id.food_rating_bar);
            valueRatingBar = view.findViewById(R.id.value_rating_bar);

            phoneTextView.setOnClickListener(v -> {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(context.getString(R.string.tel) + hotelElements.get(getAdapterPosition()).getPhone()));
                if (callIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(callIntent);
                }
            });

            addressTextView.setOnClickListener(v -> {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(context.getString(R.string.geo) +
                        hotelElements.get(getAdapterPosition()).getAddress() +
                        context.getString(R.string.athens)));
                if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(mapIntent);
                }
            });
        }
    }

    public HotelElementAdapter(ArrayList<FoodHistoryElement> hotels) {
        hotelElements = hotels;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public HotelElementAdapter.HotelViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_history_list_item, viewGroup, false);

        return new HotelViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull HotelElementAdapter.HotelViewHolder viewHolder, final int position) {

        FoodHistoryElement currentFood = hotelElements.get(position);

        viewHolder.hotelTextView.setText(R.string.comfort_cleanliness);
        viewHolder.nameTextView.setText(currentFood.getName());
        viewHolder.addressTextView.setText(currentFood.getAddress());
        viewHolder.phoneTextView.setText(currentFood.getPhone());
        viewHolder.serviceRatingBar.setRating(currentFood.getService());
        viewHolder.foodRatingBar.setRating(currentFood.getFood());
        viewHolder.valueRatingBar.setRating(currentFood.getValue());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (hotelElements != null) {

            return hotelElements.size();
        }
        return 0;
    }

}