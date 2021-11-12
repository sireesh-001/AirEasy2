package com.cuberto.AirEasy.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cuberto.AirEasy.AirEasy.BreakUpFragment;
import com.cuberto.AirEasy.AirEasy.CancellationFragment;
import com.cuberto.AirEasy.AirEasy.FlightBaggagesFragment;
import com.cuberto.AirEasy.AirEasy.FlightDataChangeFragment;

public class FlightFareCanTabAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;

    public FlightFareCanTabAdapter(FragmentManager fm, int i) {
        super(fm);
        this.mNumOfTabs = i;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                CancellationFragment tab1 = new CancellationFragment();
                return tab1;
            case 1:
                FlightDataChangeFragment tab2 = new FlightDataChangeFragment();
                return tab2;
            case 2:
                FlightBaggagesFragment tab3 = new FlightBaggagesFragment();
                return tab3;
            case 3:
                BreakUpFragment tab4 = new BreakUpFragment();
                return tab4;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
