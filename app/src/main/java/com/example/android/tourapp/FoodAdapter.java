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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private static ArrayList<FoodHistoryElement> foodElements;

    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView addressTextView;
        private final TextView phoneTextView;

        private final RatingBar serviceRatingBar;
        private final RatingBar foodRatingBar;
        private final RatingBar valueRatingBar;

        @SuppressLint("QueryPermissionsNeeded")
        public FoodViewHolder(View view) {
            super(view);

            Context context = view.getContext();

            nameTextView = view.findViewById(R.id.name_text);
            addressTextView = view.findViewById(R.id.address_text);
            phoneTextView = view.findViewById(R.id.phone_text);

            serviceRatingBar = view.findViewById(R.id.service_rating_bar);
            foodRatingBar = view.findViewById(R.id.food_rating_bar);
            valueRatingBar = view.findViewById(R.id.value_rating_bar);

            phoneTextView.setOnClickListener(v -> {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(context.getString(R.string.tel) + foodElements.get(getAdapterPosition()).getPhone()));
                if (callIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(callIntent);
                }
            });

            addressTextView.setOnClickListener(v -> {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(context.getString(R.string.geo) +
                        foodElements.get(getAdapterPosition()).getAddress() +
                        context.getString(R.string.athens)));
                if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(mapIntent);
                }
            });
        }
    }

    public FoodAdapter(ArrayList<FoodHistoryElement> foods) {
        foodElements = foods;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_history_list_item, viewGroup, false);

        return new FoodViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder viewHolder, final int position) {

        FoodHistoryElement currentFood = foodElements.get(position);

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
        if (foodElements != null) {

            return foodElements.size();
        }
        return 0;
    }

}