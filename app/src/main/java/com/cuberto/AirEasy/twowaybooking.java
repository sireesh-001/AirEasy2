package com.cuberto.AirEasy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.FlightSearchResultRecyAdapter;
import com.cuberto.AirEasy.ModelClass.FlightSearchResultModelClass;

public class twowaybooking extends AppCompatActivity implements View.OnClickListener {


    TextView txtmobepay, tvSubtitle;
    ImageView imageView;
    LinearLayout linear1, linear2, linear3, linear4, linear5, sort_linear, filterLinear;
    View view1, view2, view3, view4, view5;

    private ArrayList<FlightSearchResultModelClass> flightSearchResultModelClasses;
    private RecyclerView recyclerView;
    private FlightSearchResultRecyAdapter bonusRecyAdapter;

    private String title[] ={"Air India","Emirates","Etihad","Air India","Emirates","Etihad"};
    private String price[] = {"₹1120","₹3420","₹2320","₹1120","₹3420","₹2320"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twowaybooking);


        recyclerView =findViewById(R.id.rvlflightSearchResult);
        flightSearchResultModelClasses = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            FlightSearchResultModelClass beanClassForRecyclerView_contacts = new FlightSearchResultModelClass(title[i],price[i]);
            flightSearchResultModelClasses.add(beanClassForRecyclerView_contacts);
        }

        bonusRecyAdapter = new FlightSearchResultRecyAdapter(twowaybooking.this,flightSearchResultModelClasses);

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bonusRecyAdapter);

        txtmobepay = findViewById(R.id.txtmobepay);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        txtmobepay.setText("Delhi To Mumbai");
        tvSubtitle.setText("5 sept | 1 Adult | Business class");

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);


        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        linear4 = findViewById(R.id.linear4);
        linear5 = findViewById(R.id.linear5);

        linear1.setOnClickListener(this);
        linear2.setOnClickListener(this);
        linear3.setOnClickListener(this);
        linear4.setOnClickListener(this);
        linear5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear1:
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear2:
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear3:
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.VISIBLE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear4:
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.VISIBLE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear5:
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.VISIBLE);
                break;
        }
    }
}

