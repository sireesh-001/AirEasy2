package com.cuberto.AirEasy;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cuberto.AirEasy.Adapter.SuccessAdapter;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.cuberto.AirEasy.ModelClass.TravelModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class successful extends AppCompatActivity {


    TextView next;
    int number=1;
    String number1="";
    Double price=0.0;
    int n=1;
    FlightModel mode1;
    List<String> list = new ArrayList<String>();
    FirebaseRecyclerAdapter<TravelModel, SuccessAdapter> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<TravelModel> itemFirebaseRecyclerOptions;
    private RecyclerView recyclerView;
    DatabaseReference databaseReference,databaseReference1,databaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successful);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.chosenorange));
        }
        Userdetails user;
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        String logged=getIntent().getStringExtra("logged");
        String flight=getIntent().getStringExtra("flight");
        String date=getIntent().getStringExtra("date");
        user=(Userdetails) getIntent().getSerializableExtra("user");
        price=getIntent().getDoubleExtra("price",0.0);
        databaseReference2=firebaseDatabase.getReference("login").child("flights").child(date);
        databaseReference=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("adult");
        databaseReference1=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("child");
        TextView info=findViewById(R.id.info);
        TextView info2=findViewById(R.id.info2);
        TextView info3=findViewById(R.id.info3);
        TextView info4=findViewById(R.id.info4);
        TextView info5=findViewById(R.id.arrival_Txt);
        TextView info12=findViewById(R.id.depart_txt);
        TextView info6=findViewById(R.id.hour_txt);
        TextView info7=findViewById(R.id.stop_txt);
        TextView info8=findViewById(R.id.info5);
        TextView info9=findViewById(R.id.info6);
        TextView textView2=findViewById(R.id.price1);
        textView2.setText("Travellers "+user.Number+" x ₹"+price+" + Discounts");
        TextView textView1=findViewById(R.id.txtamount);
        textView1.setText(""+price);
        price=price+500+100+100;
        TextView textView5=findViewById(R.id.price);
        textView5.setText("₹ "+price);
        ImageView flight_Img = findViewById(R.id.flight_Img);
        TextView textView12=findViewById(R.id.depart_name);
        TextView textView22=findViewById(R.id.arrival_name);
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FlightModel model = dataSnapshot.child(flight).getValue(FlightModel.class);
                if(model.getdepart_city().equals("Hyderabad"))
                {
                    textView12.setText("Rajiv Gandhi International Airport");

                }
                else if(model.getdepart_city().equals("Delhi"))
                {
                    textView12.setText("Indira Gandhi International Airport");
                }
                else if(model.getdepart_city().equals("Chennai"))
                {
                    textView12.setText("Chennai International Airport");
                }
                if(model.getarrival_city().equals("Hyderabad"))
                {
                    textView22.setText("Rajiv Gandhi International Airport");

                }
                else if(model.getarrival_city().equals("Delhi"))
                {
                    textView22.setText("Indira Gandhi International Airport");
                }
                else if(model.getarrival_city().equals("Chennai"))
                {
                    textView22.setText("Chennai International Airport");
                }
                if(model.getAirIndia_Txt().equals("Air India"))
                {
                    flight_Img.setImageResource(R.drawable.airindialogo);
                }
                else if(model.getAirIndia_Txt().equals("Vistara"))
                {
                    flight_Img.setImageResource(R.drawable.vistaralogo);
                }
                else if(model.getAirIndia_Txt().equals("GoAir"))
                {
                    flight_Img.setImageResource(R.drawable.goairlogo);
                }
                else if(model.getAirIndia_Txt().equals("Spicejet"))
                {
                    flight_Img.setImageResource(R.drawable.spicejetlogo);
                }
                else if(model.getAirIndia_Txt().equals("Indigo"))
                {
                    flight_Img.setImageResource(R.drawable.indigologo);
                }
                info.setText(""+model.getdepart_city().substring(0,3).toUpperCase()+" - "+""+model.getarrival_city().substring(0,3).toUpperCase());
                info2.setText(""+model.getStop_txt()+" | "+user.classes);
                info3.setText(""+model.getAirIndia_Txt());
                info4.setText(""+model.getNumber_Txt());
                info5.setText(""+model.getDepart_txt());
                info12.setText(""+model.getArrival_Txt());
                info6.setText(""+model.getHour_txt());
                info7.setText(""+model.getStop_txt());
//                info8.setText(""+user.f_date);
//                info9.setText(""+user.f_date);
                number1=user.Number.substring(0,1);
                number=Integer.parseInt(number1);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.i("DAta","Failed to read value." + error.toException());
            }
        });
        TextView share=findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendshare();
            }
        });
        TextView whatsapp=findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendwhatsapp();
            }
        });


        LinearLayout textView7=findViewById(R.id.tc);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(successful.this,fare_rules.class);
                intent.putExtra("price",price.toString());
                startActivity(intent);
            }
        });



        LinearLayoutManager layoutManager;
        recyclerView=findViewById(R.id.success_RecyclerView);
        layoutManager = new LinearLayoutManager(successful.this);
        recyclerView.setLayoutManager(layoutManager);
        update();


        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(successful.this, booking_details.class);
                intent.putExtra("logged",logged);
                startActivity(intent);
            }
        });

    }
    void update(){
        Query query = databaseReference;
        itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<TravelModel>().setQuery(query,TravelModel.class).build();
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<TravelModel, SuccessAdapter>(itemFirebaseRecyclerOptions) {
            @Override
            public void onBindViewHolder(@NonNull final SuccessAdapter holder, final int position, TravelModel model) {

                holder.name.setText(""+model.getname());
                holder.gender.setText(""+model.getGender());
                holder.pnr.setText(""+model.pnr);

            }

            @NonNull
            @Override
            public SuccessAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pnrdetails, parent, false);
                SuccessAdapter viewHolder=new SuccessAdapter(view);
                return viewHolder;
            }
        };

        query = databaseReference1;
        itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<TravelModel>().setQuery(query,TravelModel.class).build();
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<TravelModel, SuccessAdapter>(itemFirebaseRecyclerOptions) {
            @Override
            public void onBindViewHolder(@NonNull final SuccessAdapter holder, final int position, TravelModel model) {

                holder.name.setText(""+model.getname());
                holder.gender.setText(""+model.getGender());
                holder.pnr.setText(""+model.pnr);

            }

            @NonNull
            @Override
            public SuccessAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pnrdetails, parent, false);
                SuccessAdapter viewHolder=new SuccessAdapter(view);
                return viewHolder;
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
    void sendwhatsapp(){
        Intent waIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + "917660993300" + "&text=" + "Please help me out with my booking"));
        startActivity(waIntent);
    }
    void sendshare() {
        Log.i("Send email", "");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Customer,Your flight booking is confirmed for travel from  on 23 Nov 2021 \n\nYour flight  will depart from Terminal 1, Chennai International Airport \n\nCabin baggage per adult/child is 7Kgs and check-in baggage is 15Kgs.\\n\\nImportant information: We wish to remind you that AirEasy never asks for your personal banking and security details like passwords, CVV, OTP, etc. For any queries, please reach out to us via the help section on our mobile app");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(successful.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}



