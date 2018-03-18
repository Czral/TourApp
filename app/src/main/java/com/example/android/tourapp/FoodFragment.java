package com.example.android.tourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    // The Food ArrayList naming.
    ArrayList<FoodElement> foodElements;

    // The Food ArrayAdapter naming.
    FoodElementAdapter foodAdapter;

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.activity_element_list, container, false);

        // Creating the ArrayList of Food places.
        foodElements = new ArrayList<>();

        foodElements.add(new FoodElement(getResources().getString(R.string.bairaktaris), getResources().getString(R.string.five_monastiraki), getResources().getString(R.string.bairaktaris_phone),
                4f, 5f, 4.4f));

        foodElements.add(new FoodElement(getResources().getString(R.string.fanis_karamanlidika), getResources().getString(R.string.fifty_two_evripidou), getResources().getString(R.string.fanis_phone),
                4.4f, 4.8f, 4.2f));

        foodElements.add(new FoodElement(getResources().getString(R.string.dinner_int_the_sky), getResources().getString(R.string.iakchou_voutadon), getResources().getString(R.string.dinner_int_the_sky_phone),
                5f, 4.6f, 4.4f));

        foodElements.add(new FoodElement(getResources().getString(R.string.falafellas), getResources().getString(R.string.fifty_one_aiolou), getResources().getString(R.string.falafellas_phone),
                4.5f, 4.4f, 4.5f));

        foodElements.add(new FoodElement(getResources().getString(R.string.kallipateira), getResources().getString(R.string.eight_astiggos), getResources().getString(R.string.kalipateira_phone),
                4.2f, 4.5f, 4.2f));

        foodElements.add(new FoodElement(getResources().getString(R.string.savvas), getResources().getString(R.string.one_five_one_patission), getResources().getString(R.string.savvas_phone),
                4f, 4.6f, 4.4f));

        // Adapter setting.
        foodAdapter = new FoodElementAdapter(getActivity(), foodElements);

        // ListView naming.
        ListView listView = fragmentView.findViewById(R.id.list_view);

        // ListView setting adapter.
        listView.setAdapter(foodAdapter);

        // Making ListView capable of ContextMenu.
        registerForContextMenu(listView);

        return listView;

    }

    // Creates ContextMenu for Long Click.
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
    }

    // ContextMenu function.
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int i = foodAdapter.getPosition(foodAdapter.getItem(info.position));

        String call = foodElements.get(i).getPhone();

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
                mapIntent.setData(Uri.parse(getResources().getString(R.string.geo) + foodElements.get(i).getAddress() + getResources().getString(R.string.athens)));
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                return true;
        }

        return true;
    }

}