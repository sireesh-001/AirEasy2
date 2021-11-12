package com.cuberto.AirEasy;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.cuberto.AirEasy.Adapter.FlightFareCanTabAdapter;

public class fare_rules extends AppCompatActivity {


    TabLayout tabLayout;
    TextView tvReset,tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fare_rules);


        tvReset = findViewById(R.id.tvReset);
        tvTitle = findViewById(R.id.tvTitle);

        tvReset.setVisibility(View.INVISIBLE);
        tvTitle.setText("Fare Rules");

        tabLayout = findViewById(R.id.tb_flight_fare);

        tabLayout.addTab(tabLayout.newTab().setText("Cancellation"));
        tabLayout.addTab(tabLayout.newTab().setText("Date Change"));
        tabLayout.addTab(tabLayout.newTab().setText("Baggages"));
        tabLayout.addTab(tabLayout.newTab().setText("Breakup"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        FlightFareCanTabAdapter adapter = new FlightFareCanTabAdapter(getSupportFragmentManager(), 4);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
