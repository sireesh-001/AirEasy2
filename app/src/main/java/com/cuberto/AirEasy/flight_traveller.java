package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class flight_traveller extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_traveller);

        textView = findViewById(R.id.txtmobepay);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(FightTravellerDetails_mpActivity.this, FlightPayment.class);
//                startActivity(intent);
            }
        });
        textView.setText("Traveller Detail");

        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}