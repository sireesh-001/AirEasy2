package com.cuberto.AirEasy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.cuberto.liquid_swipe.LiquidPager;

public class MainActivity1 extends AppCompatActivity {
    LiquidPager pager;
    com.cuberto.AirEasy.ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        pager =findViewById(R.id.pager);
        viewPager=new ViewPager(getSupportFragmentManager(),0);
        pager.setAdapter(viewPager);
    }
}