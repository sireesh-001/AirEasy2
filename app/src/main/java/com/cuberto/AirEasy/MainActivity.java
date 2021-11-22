package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import com.cuberto.liquid_swipe.LiquidPager;

public class MainActivity extends AppCompatActivity {
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        }
        new CountDownTimer(5000, 1000){
            public void onTick(long millisUntilFinished){
//
            }
            public  void onFinish(){
                Intent intent=new Intent(MainActivity.this,MainActivity1.class);
                startActivity(intent);
            }
        }.start();


    }
}
