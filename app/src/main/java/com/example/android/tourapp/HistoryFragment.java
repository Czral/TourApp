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
public class HistoryFragment extends Fragment {

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActivityFragmentRecyclerBinding binding = ActivityFragmentRecyclerBinding.inflate(inflater);
        View root = binding.getRoot();

        // The History ArrayList naming.
        ArrayList<HistoryElement> historyElements = new ArrayList<>();

        historyElements.add(new HistoryElement(R.drawable.acropolis_museum, getResources().getString(R.string.acropolis_museum), getResources().getString(R.string.fifteen_dionisiou),
                getResources().getString(R.string.nine_to_five), getResources().getString(R.string.nine_to_five), getResources().getString(R.string.nine_to_five), getResources().getString(R.string.nine_to_five),
                getResources().getString(R.string.nine_to_ten), getResources().getString(R.string.nine_to_eight), getResources().getString(R.string.nine_to_eight), getResources().getString(R.string.acropolis_phone), 5f));

        historyElements.add(new HistoryElement(R.drawable.national_archaeology_museum, getResources().getString(R.string.national_archaeology_museum), getResources().getString(R.string.forty_four_patission),
                getResources().getString(R.string.one_to_eight), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four),
                getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.national_archaeology_museum_phone), 4.5f));

        historyElements.add(new HistoryElement(R.drawable.byzantine_christian_museum, getResources().getString(R.string.byzantine), getResources().getString(R.string.twenty_two_sofias),
                getResources().getString(R.string.closed), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four),
                getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.nine_to_four), getResources().getString(R.string.byzantine_phone), 4f));

        historyElements.add(new HistoryElement(R.drawable.cycladic_museum, getResources().getString(R.string.museum_cycladic), getResources().getString(R.string.four_neophytou),
                getResources().getString(R.string.ten_to_five), getResources().getString(R.string.closed), getResources().getString(R.string.ten_to_five), getResources().getString(R.string.ten_to_eight),
                getResources().getString(R.string.ten_to_five), getResources().getString(R.string.ten_to_five), getResources().getString(R.string.eleven_to_five), getResources().getString(R.string.museum_cycladic_phone), 4f));

        historyElements.add(new HistoryElement(R.drawable.agora, getResources().getString(R.string.agora), getResources().getString(R.string.twenty_four_adrianou),
                getResources().getString(R.string.eleven_to_seven), getResources().getString(R.string.eight_thirty_to_seven_thirty), getResources().getString(R.string.eight_thirty_to_seven_thirty), getResources().getString(R.string.eight_thirty_to_seven_thirty),
                getResources().getString(R.string.eight_thirty_to_seven_thirty), getResources().getString(R.string.eight_thirty_to_seven_thirty), getResources().getString(R.string.eight_thirty_to_seven_thirty), getResources().getString(R.string.agora_phone), 4f));

        historyElements.add(new HistoryElement(R.drawable.temple_olympian_zeus, getResources().getString(R.string.temple_zeus), getResources().getString(R.string.olgas_sofias),
                getResources().getString(R.string.eleven_to_seven_thirty), getResources().getString(R.string.closed), getResources().getString(R.string.eight_to_seven_thirty), getResources().getString(R.string.eight_to_seven_thirty),
                getResources().getString(R.string.eight_to_seven_thirty), getResources().getString(R.string.eight_to_seven_thirty), getResources().getString(R.string.eight_to_seven_thirty), getResources().getString(R.string.temple_zeus_phone), 4.5f));

        historyElements.add(new HistoryElement(R.drawable.national_historical_museum, getResources().getString(R.string.national_historical_museum), getResources().getString(R.string.kolokotronis_square),
                getResources().getString(R.string.closed), getResources().getString(R.string.eight_thirty_to_two_thirty), getResources().getString(R.string.eight_thirty_to_two_thirty), getResources().getString(R.string.eight_thirty_to_two_thirty),
                getResources().getString(R.string.eight_thirty_to_two_thirty), getResources().getString(R.string.eight_thirty_to_two_thirty), getResources().getString(R.string.eight_thirty_to_two_thirty), getResources().getString(R.string.national_historical_museum_phone), 4f));

        HistoryAdapter historyAdapter = new HistoryAdapter(historyElements);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(historyAdapter);

        return root;

    }

}