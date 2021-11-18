package com.cuberto.AirEasy;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class ViewPager extends FragmentPagerAdapter {
    public ViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
    switch (position){
        case 0:return new Onboarding1();
        case 1:return new Onboarding2();
        case 2:return new Onboarding3();
        case 3:return new Login();

    }

        return null;
    }

    @Override
    public int getCount() {

        return 4;
    }
}
