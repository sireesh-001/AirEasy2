package com.cuberto.AirEasy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.CityRecyAdapter;
import com.cuberto.AirEasy.ModelClass.CityModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class to_city extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("login");
    ImageView imageView;

    private ArrayList<CityModel> cityModelArrayList;
    private RecyclerView recyclerView;
    private CityRecyAdapter cityRecyAdapter;

    private String txtcity[] = {"Hyderabad","Mumbai", "Chennai","Jaipur",
            "Goa","Bangalore", "Kolkata","Vizag" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_city);

        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recycler_city);
        cityModelArrayList = new ArrayList<>();


        for (int i = 0; i < txtcity.length; i++) {
            CityModel beanClassForRecyclerView_contacts = new CityModel(txtcity[i]);
            cityModelArrayList.add(beanClassForRecyclerView_contacts);
        }
//        for (int i = 1; i < 10; i++) {
//
//            databaseReference.child("city_name").child("0"+i).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                    if (!task.isSuccessful()) {
//                        Log.e("firebase", "Error getting data", task.getException());
//                    }
//                    else {
//                        String pass=String.valueOf(task.getResult().getValue());
//                        CityModel beanClassForRecyclerView_contacts = new CityModel(pass);
//                        cityModelArrayList.add(beanClassForRecyclerView_contacts);
//
//                    }
//                }
//            });
//
//        }
//        databaseReference.child("city_name").child("10").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
//                    String pass=String.valueOf(task.getResult().getValue());
//                    CityModel beanClassForRecyclerView_contacts = new CityModel(pass);
//                    cityModelArrayList.add(beanClassForRecyclerView_contacts);
//
//                }
//            }
//        });

        cityRecyAdapter = new CityRecyAdapter(to_city.this,cityModelArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(to_city.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cityRecyAdapter);
    }
}

