package com.example.android.tourapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.android.tourapp.databinding.ActivityFragmentRecyclerBinding;
import com.example.android.tourapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActivityFragmentRecyclerBinding binding = ActivityFragmentRecyclerBinding.inflate(inflater);
        View root = binding.getRoot();

        // Creating the ArrayList of Food places.
        ArrayList<FoodHistoryElement> foodElements = new ArrayList<>();

        foodElements.add(new FoodHistoryElement(getResources().getString(R.string.bairaktaris), getResources().getString(R.string.five_monastiraki), getResources().getString(R.string.bairaktaris_phone),
                4f, 5f, 4.4f));

        foodElements.add(new FoodHistoryElement(getResources().getString(R.string.fanis_karamanlidika), getResources().getString(R.string.fifty_two_evripidou), getResources().getString(R.string.fanis_phone),
                4.4f, 4.8f, 4.2f));

        foodElements.add(new FoodHistoryElement(getResources().getString(R.string.dinner_int_the_sky), getResources().getString(R.string.iakchou_voutadon), getResources().getString(R.string.dinner_int_the_sky_phone),
                5f, 4.6f, 4.4f));

        foodElements.add(new FoodHistoryElement(getResources().getString(R.string.falafellas), getResources().getString(R.string.fifty_one_aiolou), getResources().getString(R.string.falafellas_phone),
                4.5f, 4.4f, 4.5f));

        foodElements.add(new FoodHistoryElement(getResources().getString(R.string.kallipateira), getResources().getString(R.string.eight_astiggos), getResources().getString(R.string.kalipateira_phone),
                4.2f, 4.5f, 4.2f));

        foodElements.add(new FoodHistoryElement(getResources().getString(R.string.savvas), getResources().getString(R.string.one_five_one_patission), getResources().getString(R.string.savvas_phone),
                4f, 4.6f, 4.4f));

        // Adapter setting.
        FoodAdapter foodAdapter = new FoodAdapter(foodElements);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(foodAdapter);

        return root;

    }
}