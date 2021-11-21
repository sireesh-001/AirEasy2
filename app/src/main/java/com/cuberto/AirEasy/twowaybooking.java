package com.cuberto.AirEasy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
    DatabaseReference databaseReference=firebaseDatabase.getReference("login").child("flights").child("01");
    TextView txtmobepay, tvSubtitle;
    ImageView imageView;
    String clickeditem;
    LinearLayout linear1, linear2, linear3, linear4, linear5, sort_linear, filterLinear;
    View view1, view2, view3, view4, view5;
    Dialog slideDialog;
    private ArrayList<FlightSearchResultModelClass> flightSearchResultModelClasses;
    private RecyclerView recyclerView;
    private FlightSearchResultRecyAdapter bonusRecyAdapter;
    ImageView ivCalaender;
    public int sort=1;
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

        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        update();


        ivCalaender = findViewById(R.id.ivCalaender);
        ivCalaender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(twowaybooking.this,FlightChooseDateActivity.class);
                startActivity(intent);
            }
        });

        filterLinear = findViewById(R.id.filterLinear);
        filterLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(twowaybooking.this,FlightFilter_mpActivity.class);
                startActivity(intent);
            }
        });

        sort_linear = findViewById(R.id.sort_linear);
        sort_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideDialog = new Dialog(twowaybooking.this, R.style.CustomDialogAnimation);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // Setting dialogview
                Window window = slideDialog.getWindow();
                //  window.setGravity(Gravity.BOTTOM);

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                slideDialog.setContentView(R.layout.layout_filter);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());
                if(slideDialog.findViewById(R.id.rd1).isSelected()){
                    sort=1;
                }
                else if(slideDialog.findViewById(R.id.rd2).isSelected()){
                    sort=2;
                }
                else if(slideDialog.findViewById(R.id.rd3).isSelected()){
                    sort=3;
                }
                else if(slideDialog.findViewById(R.id.rd4).isSelected()){
                    sort=4;
                }
                //int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.625);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;


                slideDialog.getWindow().setAttributes(layoutParams);

                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();
                slideDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {

                        update();
                    }
                });

                update();
            }
        });

        txtmobepay = findViewById(R.id.txtmobepay);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        txtmobepay.setText(user.from1+" To "+user.dest);
        tvSubtitle.setText(user.f_date+" | "+user.Number+" Adult | "+user.classes+" class");

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
                holder.arrival_city.setText(model.getarrival_city());
                holder.depart_city.setText(model.getdepart_city());
                holder.airIndia_Txt.setText(model.getAirIndia_Txt());
                holder.number_Txt.setText(model.getNumber_Txt());
                holder.rupees_Txt.setText("₹"+model.getRupees_Txt());
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
                        Intent intent=new Intent(twowaybooking.this,flight_review.class);
                        startActivity(intent);
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
                databaseReference=firebaseDatabase.getReference("login").child("flights").child("01");
                update();
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear2:
                databaseReference=firebaseDatabase.getReference("login").child("flights").child("02");
                update();
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear3:
                databaseReference=firebaseDatabase.getReference("login").child("flights").child("03");
                update();
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

