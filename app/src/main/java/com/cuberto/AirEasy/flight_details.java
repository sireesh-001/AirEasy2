package com.cuberto.AirEasy;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.Adapter.CityRecyAdapter;
import com.cuberto.AirEasy.Adapter.TravelCycAdapter;
import com.cuberto.AirEasy.ModelClass.CityModel;
import com.cuberto.AirEasy.ModelClass.CusomterModel;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.cuberto.AirEasy.ModelClass.TravelModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class flight_details extends AppCompatActivity {
    Double price=0.0;
    String clickeditem;
    ImageView imageView;
    int number=1;
    ArrayList<String> list;
    String number1="";
    private ArrayList<TravelModel> cityModelArrayList;
    private TravelCycAdapter cityRecyAdapter;
    String pc;
    FlightModel model;
    RecyclerView recyclerView;
    DatabaseReference databaseReference1,databaseReference2,databaseReference3;
    String logged;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_details);
        logged=getIntent().getStringExtra("logged");
        clickeditem=getIntent().getStringExtra("flight");
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference1=firebaseDatabase.getReference("login").child("users").child(logged).child("flight_details").child(clickeditem);

        TextView classes=findViewById(R.id.classes);
        TextView info=findViewById(R.id.info);
        TextView info2=findViewById(R.id.info2);
        TextView d_date=findViewById(R.id.d_date);
        TextView info3=findViewById(R.id.info3);
        TextView info4=findViewById(R.id.info4);
        TextView info5=findViewById(R.id.arrival_Txt);
        TextView info6=findViewById(R.id.hour_txt);
        TextView info7=findViewById(R.id.stop_txt);
        TextView info8=findViewById(R.id.info5);
        TextView info10=findViewById(R.id.tofrom);
        TextView info9=findViewById(R.id.info6);
        ImageView flight_Img = findViewById(R.id.flight_Img);
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CusomterModel model1 = dataSnapshot.getValue(CusomterModel.class);

            list=model1.object;
            model=model1.model;
                if(model.getAirIndia_Txt().equals("Air India"))
                {
                    flight_Img.setImageResource(R.drawable.airindialogo);
                }
                if(model.getAirIndia_Txt().equals("Vistara"))
                {
                    flight_Img.setImageResource(R.drawable.vistaralogo);
                }
                if(model.getAirIndia_Txt().equals("GoAir"))
                {
                    flight_Img.setImageResource(R.drawable.goairlogo);
                }
                if(model.getAirIndia_Txt().equals("Spicejet"))
                {
                    flight_Img.setImageResource(R.drawable.spicejetlogo);
                }
                if(model.getAirIndia_Txt().equals("Indigo"))
                {
                    flight_Img.setImageResource(R.drawable.indigologo);
                }
            ArrayList<TravelModel> list1=new ArrayList<TravelModel>();

                for (int i = 0; i < list.size(); i++) {
                    databaseReference2=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("adult").child(list.get(i));
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            TravelModel model2 = dataSnapshot.getValue(TravelModel.class);
                            if(model2!=null){
                            list1.add(model2);}
                        }
                        @Override
                        public void onCancelled(DatabaseError error) {
                            Log.i("DAta","Failed to read value." + error.toException());
                        }
                    });
                    databaseReference3=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("child").child(list.get(i));
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            TravelModel model2 = dataSnapshot.getValue(TravelModel.class);
                            if(model2!=null){
                                list1.add(model2);}
                        }
                        @Override
                        public void onCancelled(DatabaseError error) {
                            Log.i("DAta","Failed to read value." + error.toException());
                        }
                    });
                }
                recyclerView = (RecyclerView)findViewById(R.id.success_RecyclerView);
                cityModelArrayList = new ArrayList<>();

                for (int i = 0; i < list1.size(); i++) {
                    TravelModel beanClassForRecyclerView_contacts = list1.get(i);
                    cityModelArrayList.add(beanClassForRecyclerView_contacts);
                }

                cityRecyAdapter = new TravelCycAdapter(flight_details.this,cityModelArrayList);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(flight_details.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(cityRecyAdapter);

                info.setText(""+model.getdepart_city().substring(0,3).toUpperCase()+" - "+""+model.getarrival_city().substring(0,3).toUpperCase());
                info2.setText(""+model.getStop_txt()+" | "+"General");
                d_date.setText("23 Nov 2021");
                info3.setText(""+model.getAirIndia_Txt());
                info4.setText(""+model.getNumber_Txt());
                info5.setText(""+model.getDepart_txt());
                info6.setText(""+model.getHour_txt());
                info7.setText(""+model.getStop_txt());
                info8.setText("23 Nov 2021");
                info9.setText("23 Nov 2021");
                price=Double.parseDouble(model.getRupees_Txt());
                number1=model1.classes.substring(0,1);
                info10.setText(""+model.getdepart_city().substring(0,3)+" - "+model.getarrival_city().substring(0,3));
                number=Integer.parseInt(number1);
//                Toast.makeText(flight_review.this, " "+number ,Toast.LENGTH_SHORT).show();
//                info10.setText("₹ "+price*number);
//                info11.setText("For "+user.Number);
                TextView textVie2=findViewById(R.id.price1);
                textVie2.setText("Travellers "+number+" x ₹"+model.getRupees_Txt()+" + Discounts");
                TextView textView1=findViewById(R.id.txtamount);
                textView1.setText(""+(model1.total-700));
                TextView textView3=findViewById(R.id.tprice);
                textView3.setText(""+model1.total);


            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.i("DAta","Failed to read value." + error.toException());
            }
        });

        LinearLayout linearLayout=findViewById(R.id.rules);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(flight_details.this,fare_rules.class);
                startActivity(intent);
            }
        });
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.getOverflowIcon().setTint(Color.parseColor("#ffffff"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }
}
