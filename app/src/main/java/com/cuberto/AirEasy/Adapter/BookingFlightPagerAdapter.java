package com.cuberto.AirEasy.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cuberto.AirEasy.AirEasy.UpcomingFlightFragment;

public class BookingFlightPagerAdapter extends FragmentStatePagerAdapter {

    public BookingFlightPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                UpcomingFlightFragment tab1 = new UpcomingFlightFragment();
                return tab1;
            case 1:
                UpcomingFlightFragment tab2 = new UpcomingFlightFragment();
                return tab2;
            case 2:
                UpcomingFlightFragment tab3 = new UpcomingFlightFragment();
                return tab3;


            default:
                return null;

        }
    }

        @Override
        public int getCount () {

            return 3;

        }
    }


