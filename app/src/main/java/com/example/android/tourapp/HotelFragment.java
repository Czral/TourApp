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
public class HotelFragment extends Fragment {

    // The Hotel ArrayList naming.
    ArrayList<FoodElement> hotelElements;

    // The Hotel ArrayAdapter naming.
    HotelElementAdapter hotelAdapter;

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.activity_element_list, container, false);

        // Creating the ArrayList of Hotels.
        hotelElements = new ArrayList<>();

        hotelElements.add(new FoodElement(getResources().getString(R.string.hilton), getResources().getString(R.string.forty_six_vas_sofias), getResources().getString(R.string.hilton_phone),
                5f, 4.8f, 4.2f));

        hotelElements.add(new FoodElement(getResources().getString(R.string.president), getResources().getString(R.string.forty_three_kifisias), getResources().getString(R.string.president_phone),
                4.5f, 4.5f, 4.2f));

        hotelElements.add(new FoodElement(getResources().getString(R.string.pan), getResources().getString(R.string.eleven_mitropoleos), getResources().getString(R.string.pan_phone),
                4.5f, 4.4f, 4.6f));

        hotelElements.add(new FoodElement(getResources().getString(R.string.phaedra), getResources().getString(R.string.sixteen_cherefontos), getResources().getString(R.string.phaedra_phone),
                4.4f, 4.5f, 5f));

        hotelElements.add(new FoodElement(getResources().getString(R.string.stratos_vassilikos), getResources().getString(R.string.one_one_four_micha), getResources().getString(R.string.stratos_vassilikos_phone),
                4.5f, 4.4f, 4.4f));

        // Adapter setting.
        hotelAdapter = new HotelElementAdapter(getActivity(), hotelElements);

        // ListView naming.
        ListView listView = fragmentView.findViewById(R.id.list_view);

        // ListView setting adapter.
        listView.setAdapter(hotelAdapter);

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

    //    int u = hotelAdapter.getPosition(hotelElements.indexOf(info.position));

        int i = hotelAdapter.getPosition(hotelAdapter.getItem(info.position));

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