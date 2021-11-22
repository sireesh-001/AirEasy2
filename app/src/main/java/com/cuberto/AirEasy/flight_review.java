package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class flight_review extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button next;
    LinearLayout llDetail;
    LinearLayout llFairRule;
    Userdetails user;
    int p=0,q=0,r=0;
    int number=1;
    String number1="";
    Double price=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_review);
        Userdetails user;
        TextView info10=findViewById(R.id.price);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        String logged=getIntent().getStringExtra("logged");
        String flight=getIntent().getStringExtra("flight");
        String date=getIntent().getStringExtra("date");
        user=(Userdetails) getIntent().getSerializableExtra("user");
        DatabaseReference databaseReference=firebaseDatabase.getReference("login").child("flights").child(date);
        llDetail = findViewById(R.id.llDetail);
        llFairRule = findViewById(R.id.llFairRule);
        TextView info=findViewById(R.id.info);
        TextView info2=findViewById(R.id.info2);
        TextView d_date=findViewById(R.id.d_date);
        TextView info3=findViewById(R.id.info3);
        TextView info4=findViewById(R.id.info4);
        TextView info5=findViewById(R.id.arrival_Txt);
        TextView info6=findViewById(R.id.hour_txt);
        TextView info7=findViewById(R.id.stop_txt);
        TextView info8=findViewById(R.id.info5);
        TextView info9=findViewById(R.id.info6);
        TextView info11=findViewById(R.id.number);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FlightModel model = dataSnapshot.child(flight).getValue(FlightModel.class);



                info.setText(""+model.getdepart_city().substring(0,3).toUpperCase()+" - "+""+model.getarrival_city().substring(0,3).toUpperCase());
                info2.setText(""+model.getStop_txt()+" | "+user.classes);
                d_date.setText(""+user.f_date);
                info3.setText(""+model.getAirIndia_Txt());
                info4.setText(""+model.getNumber_Txt());
                info5.setText(""+model.getDepart_txt());
                info6.setText(""+model.getHour_txt());
                info7.setText(""+model.getStop_txt());
                info8.setText(""+user.f_date);
                info9.setText(""+user.f_date);
                price=Double.parseDouble(model.getRupees_Txt());
                number1=user.Number.substring(0,1);
                number=Integer.parseInt(number1);
//                Toast.makeText(flight_review.this, " "+number ,Toast.LENGTH_SHORT).show();
                info10.setText("₹ "+price*number);
                info11.setText("For "+user.Number);
                price=price*number;



            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.i("DAta","Failed to read value." + error.toException());
            }
        });

        RadioButton radioButton=findViewById(R.id.inc);
        RadioButton radioButton1=findViewById(R.id.noinc);
        EditText editText=findViewById(R.id.offer_txt);
        TextView button=findViewById(R.id.apply);
        CheckBox checkBox=findViewById(R.id.discount_radio);
        CheckBox checkBox1=findViewById(R.id.zero_radio);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p==0){
                price=price+300*number;
                info10.setText("₹ "+price);}
                p=1;
            }
        });
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p==1)
                {
                    price=price-300*number;
                    info10.setText("₹ "+price);
                    p=0;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("AirEasy"));
                {
                    price=price-(0.1*price);
                    info10.setText("₹ "+price);
                }
            }
        });
        int h=(int)(0.35*price);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(q==1){
//
//                    price=price+h;
//                    info10.setText(""+price);
//                    q=0;
//                }
//                else if(q==0){
//                    price=price-h;
//                    info10.setText(""+price);
//                    q=1;
//                }
            }
        });
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r==1){
                    price=price-(500);
                    info10.setText("₹ "+price);
                    r=0;
                }
                else if(r==0){
                    price=price+(500);
                    info10.setText("₹ "+price);
                    r=1;
                }
            }
        });
        llFairRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(flight_review.this,fare_rules.class);
                intent.putExtra("price",info10.getText().toString());
                intent.putExtra("class",info11.getText().toString());
                startActivity(intent);
            }
        });
        TextView view_t=findViewById(R.id.view_t);
        TextView view_t1=findViewById(R.id.view_t1);
        TextView view_t2=findViewById(R.id.view_t2);
        view_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(flight_review.this,fare_rules.class);
                intent.putExtra("price",info10.getText().toString());
                intent.putExtra("class",info11.getText().toString());
                startActivity(intent);
            }
        });
        view_t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(flight_review.this,fare_rules.class);
                intent.putExtra("price",info10.getText().toString());
                intent.putExtra("class",info11.getText().toString());
                startActivity(intent);
            }
        });
        view_t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(flight_review.this,fare_rules.class);
                intent.putExtra("price",info10.getText().toString());
                intent.putExtra("class",info11.getText().toString());
                startActivity(intent);
            }
        });
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(flight_review.this,flight_traveller.class);
                intent.putExtra("flight",flight);
                intent.putExtra("logged",logged);
                intent.putExtra("date",date);
                intent.putExtra("user",user);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });


        llDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(flight_review.this,flight_traveller.class);
                intent.putExtra("flight",flight);
                intent.putExtra("logged",logged);
                intent.putExtra("date",date);
                intent.putExtra("user",user);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.txtmobepay);
        textView.setText("Flight Review");


        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price=0.0;
                onBackPressed();
            }
        });
    }
}
