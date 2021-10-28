package com.example.android.tourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.android.tourapp.databinding.ActivityFragmentRecyclerBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {

    // The Hotel ArrayList naming.
    private ArrayList<FoodHistoryElement> hotelElements;

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActivityFragmentRecyclerBinding binding = ActivityFragmentRecyclerBinding.inflate(inflater);
        View root = binding.getRoot();

        // Creating the ArrayList of Hotels.
        hotelElements = new ArrayList<>();

        hotelElements.add(new FoodHistoryElement(getResources().getString(R.string.hilton), getResources().getString(R.string.forty_six_vas_sofias), getResources().getString(R.string.hilton_phone),
                5f, 4.8f, 4.2f));

        hotelElements.add(new FoodHistoryElement(getResources().getString(R.string.president), getResources().getString(R.string.forty_three_kifisias), getResources().getString(R.string.president_phone),
                4.5f, 4.5f, 4.2f));

        hotelElements.add(new FoodHistoryElement(getResources().getString(R.string.pan), getResources().getString(R.string.eleven_mitropoleos), getResources().getString(R.string.pan_phone),
                4.5f, 4.4f, 4.6f));

        hotelElements.add(new FoodHistoryElement(getResources().getString(R.string.phaedra), getResources().getString(R.string.sixteen_cherefontos), getResources().getString(R.string.phaedra_phone),
                4.4f, 4.5f, 5f));

        hotelElements.add(new FoodHistoryElement(getResources().getString(R.string.stratos_vassilikos), getResources().getString(R.string.one_one_four_micha), getResources().getString(R.string.stratos_vassilikos_phone),
                4.5f, 4.4f, 4.4f));

        // Adapter setting.
        HotelElementAdapter hotelAdapter = new HotelElementAdapter(hotelElements);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(hotelAdapter);

        // Making ListView capable of ContextMenu.
        registerForContextMenu(root);
        return root;

    }

    // Creates ContextMenu for Long Click.
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
    }

    // ContextMenu function.
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //    int u = hotelAdapter.getPosition(hotelElements.indexOf(info.position));

    //    int i = hotelAdapter.getPosition(hotelAdapter.getItem(info.position));
        int i = 0;

        String call = hotelElements.get(i).getPhone();

        switch (item.getItemId()) {

            // Using Intent for call.
            case (R.id.call_item):

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(getResources().getString(R.string.tel) + call));
                if (callIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(callIntent);

                }

                return true;

            // Using Intent for map (using the address).
            case (R.id.map_item):

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(getResources().getString(R.string.geo) + hotelElements.get(i).getAddress() + getResources().getString(R.string.athens)));
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                return true;
        }

        return true;
    }

}