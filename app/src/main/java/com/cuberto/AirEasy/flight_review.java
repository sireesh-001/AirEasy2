package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class flight_review extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button next;
    LinearLayout llDetail;
    LinearLayout llFairRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_review);

        llDetail = findViewById(R.id.llDetail);
        llFairRule = findViewById(R.id.llFairRule);


        llFairRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(FlightReview_mpActivity.this,FlightFareRulesCancellation.class);
//                startActivity(intent);
            }
        });
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(FlightReview_mpActivity.this,FlightAddAncillarymeals.class);
//                startActivity(intent);
            }
        });


        llDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(FlightReview_mpActivity.this,FightTravellerDetails_mpActivity.class);
//                startActivity(intent);
            }
        });

        textView = findViewById(R.id.txtmobepay);
        textView.setText("Flight Review");

        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
