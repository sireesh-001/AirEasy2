package com.cuberto.AirEasy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.WardAdapter;
import com.cuberto.AirEasy.ModelClass.WardModel;

public class FlightFilter_mpActivity extends AppCompatActivity {

    String[] time_Txt = {"Before 11 AM","11 AM - 5 PM","5 PM - 9 PM","After 9 PM"};
    String[] air_lines = {"Indigo","Air Asia","Vistara","Emirats","Etihad","Go Air"};

    private RecyclerView recyclerView,recyclerView1;
    private WardAdapter wardAdapter;
    private ArrayList<WardModel> wardModels;

    TextView tvTitle;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_filter_mp);

        apply = findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(FlightFilter_mpActivity.this,FlightReview_mpActivity.class);
//                startActivity(intent);
            }
        });

        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Filter");

        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.ward_recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(FlightFilter_mpActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        wardModels = new ArrayList<>();

        for (int i = 0; i < time_Txt.length; i++) {
            WardModel wardModel = new WardModel(time_Txt[i]);
            wardModels.add(wardModel);
        }
        wardAdapter = new WardAdapter(FlightFilter_mpActivity.this, wardModels);
        recyclerView.setAdapter(wardAdapter);
        /*----------Recycler view code------------*/
        recyclerView1 = findViewById(R.id.airlines_recyclerView);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(FlightFilter_mpActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        wardModels = new ArrayList<>();

        for (int i = 0; i < air_lines.length; i++) {
            WardModel wardModel = new WardModel(air_lines[i]);
            wardModels.add(wardModel);
        }
        wardAdapter = new WardAdapter(FlightFilter_mpActivity.this, wardModels);
        recyclerView1.setAdapter(wardAdapter);
    }
}
