package com.cuberto.AirEasy;

import android.app.Dialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.FlightAdapter;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class onewaybooking extends AppCompatActivity implements View.OnClickListener{

    TextView txtmobepay,tvSubtitle;
    ImageView imageView;

FirebaseRecyclerAdapter<FlightModel,FlightAdapter.ViewHolder> firebaseRecyclerAdapter;
FirebaseRecyclerOptions<FlightModel> itemFirebaseRecyclerOptions;
    Integer[] flight_Img = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background};

//    String[] airIndia_Txt = {"Air India","Etihad Airways","Emirates"};
//    String[] number_Txt = {"A6 323","E5 431","M4 754"};
//    String[] rupees_Txt = {"₹1120","₹2120","₹3120"};
//    String[] arrival_Txt = {"12:00","13:00","14:00"};
//    String[] hour_txt = {"2 hr","1.5 hr","2 hr"};
//    String[] stop_txt = {"Non Stop","One Stop","Non Stop"};
//    String[] depart_txt = {"15:00","16:00","18:00"};

    private RecyclerView recyclerView;
    private FlightAdapter flightAdapter;
    private ArrayList<FlightModel> flightModels;

    View view1,view2,view3,view4,view5;
    LinearLayout linear1,linear2,linear3,linear4,linear5,sort_linear,filterLinear;
    Dialog slideDialog;

    ImageView ivCalaender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onewaybooking);
        Userdetails user=(Userdetails) getIntent().getSerializableExtra("details");
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("login");

        filterLinear = findViewById(R.id.filterLinear);
        filterLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onewaybooking.this,FlightFilter_mpActivity.class);
                startActivity(intent);
            }
        });

        ivCalaender = findViewById(R.id.ivCalaender);
        ivCalaender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onewaybooking.this,FlightChooseDateActivity.class);
                startActivity(intent);
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

        txtmobepay.setText(user.from1+"To"+user.dest);
        tvSubtitle.setText(user.d_date+" sept | "+user.Number+" Adult | "+user.classes+" class");


        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.flight_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(onewaybooking.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        flightModels = new ArrayList<>();

        for (int i = 0; i < flight_Img.length; i++) {
            FlightModel flightModel = new FlightModel(flight_Img[i], airIndia_Txt[i],
                    number_Txt[i],rupees_Txt[i],arrival_Txt[i],hour_txt[i],stop_txt[i],depart_txt[i]);
            flightModels.add(flightModel);
        }
        flightAdapter = new FlightAdapter(onewaybooking.this, flightModels);
        recyclerView.setAdapter(flightAdapter);

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

        sort_linear = findViewById(R.id.sort_linear);
        sort_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slideDialog = new Dialog(onewaybooking.this, R.style.CustomDialogAnimation);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // Setting dialogview
                Window window = slideDialog.getWindow();
                //  window.setGravity(Gravity.BOTTOM);

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                slideDialog.setContentView(R.layout.layout_filter);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                //int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.625);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;

                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
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
