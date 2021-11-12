package com.cuberto.AirEasy.AirEasy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.cuberto.AirEasy.Adapter.BookingFlightPagerAdapter;
import com.cuberto.AirEasy.R;

public class FlightFragment extends Fragment {

    ViewPager viewpager1;
    TabLayout tablayout1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flight, container, false);

        /* Tablayout code is here*/
        viewpager1 = view.findViewById(R.id.viewpager_genealogy);
        tablayout1 = view.findViewById(R.id.tablayout_genealogy);

        tablayout1.addTab(tablayout1.newTab().setText("Upcoming"));
        tablayout1.addTab(tablayout1.newTab().setText("Past "));
        tablayout1.addTab(tablayout1.newTab().setText("Cancelled"));


        BookingFlightPagerAdapter adapter = new BookingFlightPagerAdapter(getChildFragmentManager(), tablayout1.getTabCount());
        viewpager1.setAdapter(adapter);
        viewpager1.setOffscreenPageLimit(2);
        viewpager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout1));
        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpager1.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });



        return  view;
    }

}
