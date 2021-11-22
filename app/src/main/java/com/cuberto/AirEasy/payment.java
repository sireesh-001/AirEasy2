package com.cuberto.AirEasy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.cuberto.AirEasy.ModelClass.CusomterModel;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class payment extends AppCompatActivity implements View.OnClickListener{
    Double price=0.0;
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
        String logged=getIntent().getStringExtra("logged");
        String flight=getIntent().getStringExtra("flight");
        String date=getIntent().getStringExtra("date");
        Userdetails user=(Userdetails) getIntent().getSerializableExtra("user");
        int number=getIntent().getIntExtra("number",0);
        FlightModel model=(FlightModel) getIntent().getSerializableExtra("fmodel");
        Bundle args = getIntent().getBundleExtra("list");
        ArrayList<String> object = (ArrayList<String>) args.getSerializable("ARRAYLIST");
        price=getIntent().getDoubleExtra("price",0.0);
        TextView textVie2=findViewById(R.id.price1);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference1=firebaseDatabase.getReference("login").child("users").child(logged).child("flight_details");

        textVie2.setText("Travellers "+number+" x ₹"+model.getRupees_Txt()+" + Discounts");
TextView textView1=findViewById(R.id.txtamount);
textView1.setText(""+price);
        price=price+500+100+100;
TextView textView3=findViewById(R.id.tprice);
textView3.setText(""+price);
TextView classes=findViewById(R.id.classes);
classes.setText("For "+number+" Travellers");
TextView textView5=findViewById(R.id.price);
textView5.setText("₹ "+price);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CusomterModel cusomterModel=new CusomterModel(model,price,user.Number.substring(0,1),object);
                databaseReference1.push().setValue(cusomterModel);

                Intent intent = new Intent(payment.this,successful.class);
                intent.putExtra("number",number);
                intent.putExtra("fmodel",model);
                intent.putExtra("logged",logged);
                intent.putExtra("flight",flight);
                intent.putExtra("date",date);
                intent.putExtra("user",user);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.txtmobepay);
        textView.setText("Traveller Detail");
        imageView = findViewById(R.id.imgback);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price=0.0;
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

