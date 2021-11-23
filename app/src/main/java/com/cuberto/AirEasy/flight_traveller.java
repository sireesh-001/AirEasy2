package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.Adapter.TravelAdapter;
import com.cuberto.AirEasy.ModelClass.CityModel;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class flight_traveller extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button next;
    Userdetails user;
    int number=1;
    String number1="";
    String clickeditem,clickeditem1;
    Double price=0.0;
    EditText name;
    EditText email;
    EditText gender;
    EditText age;
    EditText company;
    int n=1;
    EditText RN;
    FlightModel mode1;
    List<String> list = new ArrayList<String>();
    FirebaseRecyclerAdapter<TravelModel, TravelAdapter> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<TravelModel> itemFirebaseRecyclerOptions;
    private RecyclerView recyclerView,recyclerView1;
    DatabaseReference databaseReference,databaseReference1,databaseReference2,databaseReference3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_traveller);
        Userdetails user;
        TextView info10=findViewById(R.id.price);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        String logged=getIntent().getStringExtra("logged");
        String flight=getIntent().getStringExtra("flight");
        String date=getIntent().getStringExtra("date");
        user=(Userdetails) getIntent().getSerializableExtra("user");
        price=getIntent().getDoubleExtra("price",0.0);
        info10.setText("₹ "+price);
        databaseReference=firebaseDatabase.getReference("login").child("flights").child(date);
        databaseReference1=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("adult");
        databaseReference2=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("child");
        databaseReference3=firebaseDatabase.getReference("login").child("users").child(logged).child("flight_details");
        TextView info=findViewById(R.id.info);
        TextView info2=findViewById(R.id.info2);
        TextView info3=findViewById(R.id.info3);
        TextView info4=findViewById(R.id.info4);
        TextView info5=findViewById(R.id.arrival_Txt);
        TextView info6=findViewById(R.id.hour_txt);
        TextView info7=findViewById(R.id.stop_txt);
        TextView info8=findViewById(R.id.info5);
        TextView info9=findViewById(R.id.info6);
        TextView info11=findViewById(R.id.number);
        ImageView flight_Img = findViewById(R.id.flight_Img);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FlightModel model = dataSnapshot.child(flight).getValue(FlightModel.class);
                   mode1=model;
                if(model.getAirIndia_Txt().equals("Air India"))
                {
                    flight_Img.setImageResource(R.drawable.airindialogo);
                }
                if(model.getAirIndia_Txt().equals("Vistara"))
                {
                    flight_Img.setImageResource(R.drawable.vistaralogo);
                }
                if(model.getAirIndia_Txt().equals("GoAir"))
                {
                    flight_Img.setImageResource(R.drawable.goairlogo);
                }
                if(model.getAirIndia_Txt().equals("Spicejet"))
                {
                    flight_Img.setImageResource(R.drawable.spicejetlogo);
                }
                if(model.getAirIndia_Txt().equals("Indigo"))
                {
                    flight_Img.setImageResource(R.drawable.indigologo);
                }

                info.setText(""+model.getdepart_city().substring(0,3).toUpperCase()+" - "+""+model.getarrival_city().substring(0,3).toUpperCase());
                info2.setText(""+model.getStop_txt()+" | "+user.classes);
                info3.setText(""+model.getAirIndia_Txt());
                info4.setText(""+model.getNumber_Txt());
                info5.setText(""+model.getDepart_txt());
                info6.setText(""+model.getHour_txt());
                info7.setText(""+model.getStop_txt());
                info8.setText("23 Nov 2021");
                info9.setText("23 Nov 2021");
                number1=user.Number.substring(0,1);
                number=Integer.parseInt(number1);
                info11.setText("For "+user.Number);



            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.i("DAta","Failed to read value." + error.toException());
            }
        });

        name=findViewById(R.id.nameid);
        email=findViewById(R.id.emailid);
        gender=findViewById(R.id.genderid);
        age=findViewById(R.id.ageid);
        company=findViewById(R.id.company_value);
        RN=findViewById(R.id.Register_number);




        TextView textView3=findViewById(R.id.tc);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(flight_traveller.this,fare_rules.class);
                intent.putExtra("price",info10.getText().toString());
                intent.putExtra("class",info11.getText().toString());
                startActivity(intent);
            }
        });

        TextView textView6=findViewById(R.id.addT);
        textView6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
if(name.getText().toString().equals("")||email.getText().toString().equals("")||gender.getText().toString().equals("")||age.getText().toString().equals("")){
    Toast.makeText(flight_traveller.this, "Please Enter all the values",Toast.LENGTH_SHORT).show();
}
else{
    TravelModel model=new TravelModel(givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect(),gender.getText().toString(),email.getText().toString(),name.getText().toString(),age.getText().toString(),company.getText().toString(),RN.getText().toString());
    databaseReference1.push().setValue(model);
    firebaseRecyclerAdapter.notifyDataSetChanged();
}
            }
        });

        TextView textView7=findViewById(R.id.addT1);
        textView7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")||email.getText().toString().equals("")||gender.getText().toString().equals("")||age.getText().toString().equals("")){
                    Toast.makeText(flight_traveller.this, "Please Enter all the values",Toast.LENGTH_SHORT).show();
                }
                else{
                    TravelModel model=new TravelModel(givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect(),gender.getText().toString(),email.getText().toString(),name.getText().toString(),age.getText().toString(),company.getText().toString(),RN.getText().toString());
                    databaseReference2.push().setValue(model);

                    firebaseRecyclerAdapter.notifyDataSetChanged();
                }
            }
        });

        LinearLayoutManager layoutManager;
        recyclerView=findViewById(R.id.travel_RecyclerView);
        layoutManager = new LinearLayoutManager(flight_traveller.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView1=findViewById(R.id.child_RecyclerView);
        layoutManager = new LinearLayoutManager(flight_traveller.this);
        recyclerView1.setLayoutManager(layoutManager);
        update();
        ImageView imageView=findViewById(R.id.up_arrow);

        LinearLayout linearLayout1=findViewById(R.id.flight_details);

        ImageView finalImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearLayout1.getVisibility()==View.GONE){
                    linearLayout1.setVisibility(View.VISIBLE);
                    finalImageView.setRotation(180f);
                }
                else if(linearLayout1.getVisibility()==View.VISIBLE){
                    linearLayout1.setVisibility(View.GONE);
                    finalImageView.setRotation(0f);
                }
            }
        });
        LinearLayout linearLayout=findViewById(R.id.gstl);
        CheckBox checkBox=findViewById(R.id.gst);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearLayout.getVisibility()==View.GONE){
                    linearLayout.setVisibility(View.VISIBLE);
                }
                else if(linearLayout.getVisibility()==View.VISIBLE){
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });
        textView = findViewById(R.id.txtmobepay);
        next = findViewById(R.id.next);
        CheckBox checkBox1=findViewById(R.id.check1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(flight_traveller.this, payment.class);
                if(list.size()==number && checkBox1.isChecked()){
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST",(Serializable)list);
                intent.putExtra("list", args);
                intent.putExtra("number",number);
                intent.putExtra("fmodel",mode1);
                intent.putExtra("logged",logged);
                intent.putExtra("flight",flight);
                intent.putExtra("date",date);
                intent.putExtra("user",user);
                intent.putExtra("price",price);
                startActivity(intent);}
                else{
                    Toast.makeText(flight_traveller.this, "please select the Correct number of travellers and Please Accpect T & C",Toast.LENGTH_SHORT).show();
                }
            }
        });
        textView.setText("Traveller Detail");

        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    void update(){
        Query query = databaseReference1;
        itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<TravelModel>().setQuery(query,TravelModel.class).build();
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<TravelModel, TravelAdapter>(itemFirebaseRecyclerOptions) {
            @Override
            public void onBindViewHolder(@NonNull final TravelAdapter holder, final int position, TravelModel model) {
                String name1=model.getname();
                String age1=model.getAge();
                String email1=model.getemail();
                String gender1=model.getGender();
                String company1=model.getCompany();
                String rn1=model.getRn();

                holder.name.setText(""+model.getname());
                holder.gender.setText(""+model.getGender());

                holder.setItemClickListener1(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int positon) {
                        clickeditem1=getSnapshots().getSnapshot(positon).getKey();
                        if (list.contains(clickeditem1)) {
                            for (int i = 0; i < list.size(); i++) {
                                if(list.get(i)==clickeditem1){
                                    list.remove(i);
                                    Toast.makeText(flight_traveller.this, " "+clickeditem ,Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            list.add(clickeditem1);
                        }
                    }
                });

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int positon) {
                        TravelModel clickmodel=model;
                        clickeditem=getSnapshots().getSnapshot(positon).getKey();
                        Toast.makeText(flight_traveller.this, " "+clickeditem ,Toast.LENGTH_SHORT).show();
                       name.setText(""+name1);
                    age.setText(""+age1);
                    email.setText(""+email1);
                gender.setText(""+gender1);
                company.setText(""+company1);
                    RN.setText(""+rn1);
                    }
                });
            }

            @NonNull
            @Override
            public TravelAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.travellers, parent, false);
                TravelAdapter viewHolder=new TravelAdapter(view);
                return viewHolder;
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    query = databaseReference2;
    itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<TravelModel>().setQuery(query,TravelModel.class).build();
    firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<TravelModel, TravelAdapter>(itemFirebaseRecyclerOptions) {
        @Override
        public void onBindViewHolder(@NonNull final TravelAdapter holder, final int position, TravelModel model) {

            String name1=model.getname();
            String age1=model.getAge();
            String email1=model.getemail();
            String gender1=model.getGender();
            String company1=model.getCompany();
            String rn1=model.getRn();



            holder.name.setText(""+name1);
            holder.gender.setText(""+gender1);
            holder.setItemClickListener1(new ItemClickListener() {
                @Override
                public void onclick(View view, int positon) {
                    clickeditem1=getSnapshots().getSnapshot(positon).getKey();
                    if (list.contains(clickeditem1)) {
                        for (int i = 0; i < list.size(); i++) {
                            if(list.get(i)==clickeditem1){
                            list.remove(i);}
                        }
                    } else {
                            list.add(clickeditem1);
                    }
                }
            });

            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onclick(View view, int positon) {
                    TravelModel clickmodel=model;
                    clickeditem=getSnapshots().getSnapshot(positon).getKey();
                    Toast.makeText(flight_traveller.this, " "+clickeditem ,Toast.LENGTH_SHORT).show();
                       name.setText(""+name1);
                    age.setText(""+age1);
                    email.setText(""+email1);
                gender.setText(""+gender1);
                company.setText(""+company1);
                    RN.setText(""+rn1);
                }
            });
        }

        @NonNull
        @Override
        public TravelAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.travellers, parent, false);
            TravelAdapter viewHolder=new TravelAdapter(view);
            return viewHolder;
        }
    };

        firebaseRecyclerAdapter.startListening();
        recyclerView1.setAdapter(firebaseRecyclerAdapter);

}
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
//void upgrade()
//{
//    databaseReference.addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            TravelModel model = dataSnapshot.child(clickeditem).getValue(TravelModel.class);
//            name.setText(""+model.name);
//            age.setText(""+model.age);
//            email.setText(""+model.email);
//            gender.setText(""+model.gender);
//            company.setText(""+model.company);
//            RN.setText(""+model.rn);
//        }
//        @Override
//        public void onCancelled(DatabaseError error) {
//            Log.i("DAta","Failed to read value." + error.toException());
//        }
//    });
//}
}