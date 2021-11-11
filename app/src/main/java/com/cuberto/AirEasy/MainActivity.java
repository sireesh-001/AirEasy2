package com.cuberto.AirEasy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.cuberto.liquid_swipe.LiquidPager;

public class MainActivity extends AppCompatActivity {
    LiquidPager pager;
    com.cuberto.AirEasy.ViewPager viewPager;
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
pager =findViewById(R.id.pager);
viewPager=new ViewPager(getSupportFragmentManager(),1);
pager.setAdapter(viewPager);

    }
}
