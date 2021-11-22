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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.BookFlightPagerAdapter;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class onewaybooking extends AppCompatActivity implements View.OnClickListener{
String clickeditem;
    TextView txtmobepay,tvSubtitle;
    ImageView imageView;
    String number,classes,f_date="",d_date="",form1,dest,way,type;
FirebaseRecyclerAdapter<FlightModel, BookFlightPagerAdapter> firebaseRecyclerAdapter;
FirebaseRecyclerOptions<FlightModel> itemFirebaseRecyclerOptions;
    Integer[] flight_Img = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background};
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("login").child("flights").child("01");
    private RecyclerView recyclerView;
    private BookFlightPagerAdapter bookFlightPagerAdapter;
    private ArrayList<FlightModel> flightModels;

    View view1,view2,view3,view4,view5;
    LinearLayout linear1,linear2,linear3,linear4,linear5,sort_linear,filterLinear;
    Dialog slideDialog;

    ImageView ivCalaender;
    public int sort=1;
    String date="01";
    String logged;
    public static String flight;
    Userdetails user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onewaybooking);
        user=(Userdetails) getIntent().getSerializableExtra("details");
        logged=getIntent().getStringExtra("logged");
        flight=getIntent().getStringExtra("flight");
        form1=user.from1;
        dest=user.dest;
        f_date=user.f_date;
        d_date=user.d_date;
        way=user.way;
        classes=user.classes;
        number= user.Number;
        type=user.type;
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
        Toast.makeText(onewaybooking.this, " "+flight ,Toast.LENGTH_SHORT).show();

        txtmobepay = findViewById(R.id.txtmobepay);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        flight="";
                onBackPressed();
            }
        });

        txtmobepay.setText(user.from1+" To "+user.dest);
        tvSubtitle.setText("23 Nov 2021" +" sept | "+user.Number+" Adult | "+user.classes+" class");


        /*----------Recycler view code------------*/

        recyclerView = findViewById(R.id.flight_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(onewaybooking.this);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        FlightModel flightModel=new FlightModel(
//                "arrival_Txt" ,
//                "depart_txt" ,
//                "airIndia_Txt" ,
//                "number_Txt" ,
//                "rupees_Txt" ,
//                "hour_txt" ,
//                "stop_txt" );
//        databaseReference.push().setValue(flightModel);
//        firebaseRecyclerAdapter.notifyDataSetChanged();
        update();
//        flightModels = new ArrayList<>();
//
//        for (int i = 0; i < flight_Img.length; i++) {
//            FlightModel flightModel = new FlightModel(flight_Img[i], airIndia_Txt[i],
//                    number_Txt[i],rupees_Txt[i],arrival_Txt[i],hour_txt[i],stop_txt[i],depart_txt[i]);
//            flightModels.add(flightModel);
//        }
//        flightAdapter = new FlightAdapter(onewaybooking.this, flightModels);
//        recyclerView.setAdapter(flightAdapter);

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


    }
    void update(){
        Query query=databaseReference.orderByChild("d_a_s").equalTo(flight);
        if(sort==1){
//            query = databaseReference.equalTo(flight);
            }
        else if (sort==2) {
            query = databaseReference.orderByChild("hour_txt");
        }
        else if (sort==3) {
            query = databaseReference.orderByChild("depart_txt");
        }
        else if (sort==4) {
            query = databaseReference.orderByChild("depart_txt").limitToLast(50);

        }
        itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<FlightModel>().setQuery(query,FlightModel.class).build();
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<FlightModel, BookFlightPagerAdapter>(itemFirebaseRecyclerOptions) {
            @Override
            public void onBindViewHolder(@NonNull final BookFlightPagerAdapter holder, final int position, FlightModel model) {

                if(model.getAirIndia_Txt().equals("Air India"))
                {
                    holder.flight_Img.setImageResource(R.drawable.airindialogo);
                }
                if(model.getAirIndia_Txt().equals("Vistara"))
                {
                    holder.flight_Img.setImageResource(R.drawable.vistaralogo);
                }
                if(model.getAirIndia_Txt().equals("GoAir"))
                {
                    holder.flight_Img.setImageResource(R.drawable.goairlogo);
                }
                if(model.getAirIndia_Txt().equals("Spicejet"))
                {
                    holder.flight_Img.setImageResource(R.drawable.spicejetlogo);
                }
                if(model.getAirIndia_Txt().equals("Indigo"))
                {
                    holder.flight_Img.setImageResource(R.drawable.indigologo);
                }
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
                        FlightModel clickmodel=model;
                        clickeditem=getSnapshots().getSnapshot(positon).getKey();
                        Toast.makeText(onewaybooking.this, " "+clickeditem ,Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(onewaybooking.this,flight_review.class);
                        intent.putExtra("flight",clickeditem);
                        intent.putExtra("logged",logged);
                        intent.putExtra("date",date);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }
                });}


            @NonNull
            @Override
            public BookFlightPagerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight, parent, false);
                BookFlightPagerAdapter viewHolder=new BookFlightPagerAdapter(view);
                return viewHolder;
            }
        };

firebaseRecyclerAdapter.startListening();
recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linear1:
                databaseReference=firebaseDatabase.getReference("login").child("flights").child("01");
                date="01";
                update();
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear2:
                databaseReference=firebaseDatabase.getReference("login").child("flights").child("02");
                date="02";
                update();
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.GONE);
                view4.setVisibility(View.GONE);
                view5.setVisibility(View.GONE);
                break;
            case R.id.linear3:
                databaseReference=firebaseDatabase.getReference("login").child("flights").child("03");
                date="03";
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
