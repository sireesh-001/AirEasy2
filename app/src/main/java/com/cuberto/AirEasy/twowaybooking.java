package com.cuberto.AirEasy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.FlightAdapter;
import com.cuberto.AirEasy.Adapter.FlightSearchResultRecyAdapter;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.cuberto.AirEasy.ModelClass.FlightSearchResultModelClass;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class twowaybooking extends AppCompatActivity implements View.OnClickListener {
    FirebaseRecyclerAdapter<FlightSearchResultModelClass, FlightSearchResultRecyAdapter> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<FlightSearchResultModelClass> itemFirebaseRecyclerOptions;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("update");
    TextView txtmobepay, tvSubtitle;
    ImageView imageView;
    String clickeditem;
    LinearLayout linear1, linear2, linear3, linear4, linear5, sort_linear, filterLinear;
    View view1, view2, view3, view4, view5;

    private ArrayList<FlightSearchResultModelClass> flightSearchResultModelClasses;
    private RecyclerView recyclerView;
    private FlightSearchResultRecyAdapter bonusRecyAdapter;

//    private String title[] ={"Air India","Emirates","Etihad","Air India","Emirates","Etihad"};
//    private String price[] = {"₹1120","₹3420","₹2320","₹1120","₹3420","₹2320"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twowaybooking);
        Userdetails user=(Userdetails) getIntent().getSerializableExtra("details");


        recyclerView =findViewById(R.id.rvlflightSearchResult);
//        flightSearchResultModelClasses = new ArrayList<>();
//
//        for (int i = 0; i < title.length; i++) {
//            FlightSearchResultModelClass beanClassForRecyclerView_contacts = new FlightSearchResultModelClass(title[i],price[i]);
//            flightSearchResultModelClasses.add(beanClassForRecyclerView_contacts);
//        }
//
//        bonusRecyAdapter = new FlightSearchResultRecyAdapter(twowaybooking.this,flightSearchResultModelClasses);

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        update();

        txtmobepay = findViewById(R.id.txtmobepay);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        txtmobepay.setText(user.from1+"To"+user.dest);
        tvSubtitle.setText(user.d_date+" sept | "+user.Number+" Adult | "+user.classes+" class");

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
    void update(){
        itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<FlightSearchResultModelClass>().setQuery(databaseReference,FlightSearchResultModelClass.class).build();
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<FlightSearchResultModelClass, FlightSearchResultRecyAdapter>(itemFirebaseRecyclerOptions) {
            @Override
            public void onBindViewHolder(@NonNull final FlightSearchResultRecyAdapter holder, final int position, FlightSearchResultModelClass model) {

//                FlightModel model = models.get(position);


//                holder.flight_Img.setImageResource(model.getFlight_Img());
                ////        if(position==2){
////
////            holder.llBg.setBackgroundColor(Color.parseColor("#e3f5ff"));
////        }else if(position==5){
////
////            holder.llBg.setBackgroundColor(Color.parseColor("#e3f5ff"));
////        }
                holder.airIndia_Txt.setText(model.getAirIndia_Txt());
                holder.number_Txt.setText(model.getNumber_Txt());
                holder.rupees_Txt.setText(model.getRupees_Txt());
                holder.arrival_Txt.setText(model.getArrival_Txt());
                holder.hour_txt.setText(model.getHour_txt());
                holder.stop_txt.setText(model.getStop_txt());
                holder.depart_txt.setText(model.getDepart_txt());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int positon) {
                        FlightSearchResultModelClass clickmodel=model;
                        clickeditem=getSnapshots().getSnapshot(positon).getKey();
                        Toast.makeText(twowaybooking.this, " "+clickeditem ,Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @NonNull
            @Override

            public FlightSearchResultRecyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight_search_result_list, parent, false);
                FlightSearchResultRecyAdapter viewHolder=new FlightSearchResultRecyAdapter(view);
                return viewHolder;
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);

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

