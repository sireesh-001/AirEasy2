package com.cuberto.AirEasy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    TextView textView;
    /*Linear Layout*/
    LinearLayout li1, li2, li3;

    /*Radio Button*/
    RadioButton radio1, radio2, radio3;
    /*Text View*/
    TextView txt1, txt2, txt3, price_Txt, price1_Txt, price2_Txt,txtmobepay;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(FlightPayment.this,FlightBookingSuccessfull.class);
//                startActivity(intent);
            }
        });

        textView = findViewById(R.id.txtmobepay);
        textView.setText("Traveller Detail");
        imageView = findViewById(R.id.imgback);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        li1 = findViewById(R.id.li1);
        li2 = findViewById(R.id.li2);
        li3 = findViewById(R.id.li3);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);

        price_Txt = findViewById(R.id.price_Txt);
        price1_Txt = findViewById(R.id.price1_Txt);
        price2_Txt = findViewById(R.id.price2_Txt);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        li1.setOnClickListener(this);
        li2.setOnClickListener(this);
        li3.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.li1:
                radio1.setChecked(true);
                radio2.setChecked(false);
                radio3.setChecked(false);

                radio1.setTextColor(Color.parseColor("#313131"));
                radio2.setTextColor(Color.parseColor("#adadad"));
                radio3.setTextColor(Color.parseColor("#adadad"));

                price_Txt.setTextColor(Color.parseColor("#313131"));
                price1_Txt.setTextColor(Color.parseColor("#adadad"));
                price2_Txt.setTextColor(Color.parseColor("#adadad"));

                txt1.setTextColor(Color.parseColor("#313131"));
                txt2.setTextColor(Color.parseColor("#adadad"));
                txt3.setTextColor(Color.parseColor("#adadad"));

                break;
            case R.id.li2:
                radio1.setChecked(false);
                radio2.setChecked(true);
                radio3.setChecked(false);

                radio1.setTextColor(Color.parseColor("#adadad"));
                radio2.setTextColor(Color.parseColor("#313131"));
                radio3.setTextColor(Color.parseColor("#adadad"));

                price_Txt.setTextColor(Color.parseColor("#adadad"));
                price1_Txt.setTextColor(Color.parseColor("#313131"));
                price2_Txt.setTextColor(Color.parseColor("#adadad"));

                txt1.setTextColor(Color.parseColor("#adadad"));
                txt2.setTextColor(Color.parseColor("#313131"));
                txt3.setTextColor(Color.parseColor("#adadad"));

                break;

            case R.id.li3:
                radio1.setChecked(false);
                radio2.setChecked(false);
                radio3.setChecked(true);

                radio1.setTextColor(Color.parseColor("#adadad"));
                radio2.setTextColor(Color.parseColor("#adadad"));
                radio3.setTextColor(Color.parseColor("#313131"));

                price_Txt.setTextColor(Color.parseColor("#adadad"));
                price1_Txt.setTextColor(Color.parseColor("#adadad"));
                price2_Txt.setTextColor(Color.parseColor("#313131"));

                txt1.setTextColor(Color.parseColor("#adadad"));
                txt2.setTextColor(Color.parseColor("#adadad"));
                txt3.setTextColor(Color.parseColor("#313131"));
                break;
        }

    }
}
