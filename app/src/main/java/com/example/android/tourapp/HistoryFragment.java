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
public class HistoryFragment extends Fragment {

    // The History ArrayList naming.
    ArrayList<HistoryElement> historyElements;

    // The History ArrayAdapter naming.
    HistoryElementAdapter historyAdapter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.activity_element_list, container, false);

        // Creating the ArrayList of History Sights.
        historyElements = new ArrayList<>();

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

        // Adapter setting.
        historyAdapter = new HistoryElementAdapter(getActivity(), historyElements);

        // ListView naming.
        ListView listView = fragmentView.findViewById(R.id.list_view);

        // ListView setting adapter.
        listView.setAdapter(historyAdapter);

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

        int i = historyAdapter.getPosition(historyAdapter.getItem(info.position));

        String call = historyElements.get(i).getPhone();

        switch (item.getItemId()) {

            // Using Intent for call.
            case (R.id.call_item):

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(getResources().getString(R.string.tel) + call));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }

                return true;

            // Using Intent for map (using the address).
            case (R.id.map_item):

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(getResources().getString(R.string.geo) + historyElements.get(i).getAddress() + getResources().getString(R.string.athens)));
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

                return true;
        }

        return true;
    }

}