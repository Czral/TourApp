package com.example.android.tourapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.android.tourapp.databinding.ActivityFragmentRecyclerBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightFragment extends Fragment {

    public NightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActivityFragmentRecyclerBinding binding = ActivityFragmentRecyclerBinding.inflate(inflater);
        View root = binding.getRoot();

        ArrayList<NightElement> nightElements = new ArrayList<>();

        nightElements.add(new NightElement(getResources().getString(R.string.wine_o_clock), getResources().getString(R.string.ten_lembesi), getResources().getString(R.string._wine_o_clock_phone),
                getResources().getString(R.string.wine_o_clock_description), getResources().getString(R.string.one_to_two)));

        nightElements.add(new NightElement(getResources().getString(R.string.brettos_bar), getResources().getString(R.string.forty_one_kidathineon), getResources().getString(R.string.brettos_phone),
                getResources().getString(R.string.brettos_description), getResources().getString(R.string.ten_to_three)));

        nightElements.add(new NightElement(getResources().getString(R.string.seven_times), getResources().getString(R.string.thirteen_miaouli), getResources().getString(R.string.seven_times_phone),
                getResources().getString(R.string.seven_times_description), getResources().getString(R.string.eleven_to_three)));

        nightElements.add(new NightElement(getResources().getString(R.string.a_for_athens), getResources().getString(R.string.two_four_miaouli), getResources().getString(R.string.a_for_athens_phone),
                getResources().getString(R.string.a_for_athens_description), getResources().getString(R.string.four_to_one)));

        // Adapter setting.
        NightAdapter nightAdapter = new NightAdapter(nightElements);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(nightAdapter);

        return root;

    }

}