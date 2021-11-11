package com.cuberto.AirEasy.AirEasy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.Adapter.CityRecyAdapter;
import com.cuberto.AirEasy.ModelClass.CityModel;
import com.cuberto.AirEasy.R;

import java.util.ArrayList;

public class Search_from_city extends AppCompatActivity {

    ImageView imageView;

    private ArrayList<CityModel> cityModelArrayList;
    private RecyclerView recyclerView;
    private CityRecyAdapter cityRecyAdapter;

    private String txtcity[] = {"Chennai","Delhi", "Goa","Indore",
            "Chennai","Delhi", "Goa","Indore" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fromcity);

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

        cityRecyAdapter = new CityRecyAdapter(Search_from_city.this,cityModelArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Search_from_city.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cityRecyAdapter);
    }
}
