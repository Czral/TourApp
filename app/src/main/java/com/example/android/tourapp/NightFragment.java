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
public class NightFragment extends Fragment {

    // The Food ArrayList naming.
    ArrayList<NightElement> nightElements;

    // The Food ArrayAdapter naming.
    NightElementAdapter nightAdapter;

    public NightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.activity_element_list, container, false);

        // Creating the ArrayList of Nightlife places.
        nightElements = new ArrayList<>();

        nightElements.add(new NightElement(getResources().getString(R.string.wine_o_clock), getResources().getString(R.string.ten_lembesi), getResources().getString(R.string._wine_o_clock_phone),
                getResources().getString(R.string.wine_o_clock_description), getResources().getString(R.string.one_to_two)));

        nightElements.add(new NightElement(getResources().getString(R.string.brettos_bar), getResources().getString(R.string.forty_one_kidathineon), getResources().getString(R.string.brettos_phone),
                getResources().getString(R.string.brettos_description), getResources().getString(R.string.ten_to_three)));

        nightElements.add(new NightElement(getResources().getString(R.string.seven_times), getResources().getString(R.string.thirteen_miaouli), getResources().getString(R.string.seven_times_phone),
                getResources().getString(R.string.seven_times_description), getResources().getString(R.string.eleven_to_three)));

        nightElements.add(new NightElement(getResources().getString(R.string.a_for_athens), getResources().getString(R.string.two_four_miaouli), getResources().getString(R.string.a_for_athens_phone),
                getResources().getString(R.string.a_for_athens_description), getResources().getString(R.string.four_to_one)));

        // Adapter setting.
        nightAdapter = new NightElementAdapter(getActivity(), nightElements);

        // ListView naming.
        ListView listView = fragmentView.findViewById(R.id.list_view);

        // ListView setting adapter.
        listView.setAdapter(nightAdapter);

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

        int i = nightAdapter.getPosition(nightAdapter.getItem(info.position));

        String call = nightElements.get(i).getPhone();

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
                mapIntent.setData(Uri.parse(getResources().getString(R.string.geo) + nightElements.get(i).getAddress() + getResources().getString(R.string.athens)));
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                return true;
        }

        return true;
    }

}