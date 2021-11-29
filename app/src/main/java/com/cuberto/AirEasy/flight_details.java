package com.cuberto.AirEasy;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.Adapter.CityRecyAdapter;
import com.cuberto.AirEasy.Adapter.TravelCycAdapter;
import com.cuberto.AirEasy.ModelClass.CityModel;
import com.cuberto.AirEasy.ModelClass.CusomterModel;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.cuberto.AirEasy.ModelClass.TravelModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class flight_details extends AppCompatActivity {
    Double price=0.0;
    String clickeditem;
    ImageView imageView;
    int number=1;
    ArrayList<String> list;
    String number1="";
    private ArrayList<TravelModel> cityModelArrayList;
    private TravelCycAdapter cityRecyAdapter;
    String pc;
    int pageHeight = 1120;
    int pagewidth = 792;
    Bitmap bmp, scaledbmp;
    FlightModel model;
    public String name,numbers,ddate,dcity,acity;
    RecyclerView recyclerView;
    private static final int PERMISSION_REQUEST_CODE = 200;

    DatabaseReference databaseReference1,databaseReference2,databaseReference3,databaseReference4;
    String logged;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_details);
        logged=getIntent().getStringExtra("logged");
        clickeditem=getIntent().getStringExtra("flight");
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference1=firebaseDatabase.getReference("login").child("users").child(logged).child("flight_details").child(clickeditem);
        databaseReference4=firebaseDatabase.getReference("login").child("users").child(logged).child("login_details");
        TextView classes=findViewById(R.id.classes);
        TextView info=findViewById(R.id.info);
        TextView info2=findViewById(R.id.info2);
        TextView d_date=findViewById(R.id.d_date);
        TextView info3=findViewById(R.id.info3);
        TextView info4=findViewById(R.id.info4);
        TextView info5=findViewById(R.id.arrival_Txt);
        TextView info6=findViewById(R.id.hour_txt);
        TextView info7=findViewById(R.id.stop_txt);
        TextView info8=findViewById(R.id.info5);
        TextView info10=findViewById(R.id.tofrom);
        TextView info9=findViewById(R.id.info6);
        ImageView flight_Img = findViewById(R.id.flight_Img);
        TextView textView1=findViewById(R.id.depart_name);
        TextView textView2=findViewById(R.id.arrival_name);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.circlelogo);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 140, 140, false);
        if (checkPermission()) {
            Toast.makeText(flight_details.this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }

        databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User model = snapshot.getValue(User.class);
name=model.firstname;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("DAta","Failed to read value." + error.toException());
            }
        });
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CusomterModel model1 = dataSnapshot.getValue(CusomterModel.class);

            list=model1.object;
            model=model1.model;
            numbers=model.getNumber_Txt();
            ddate=model.getDepart_txt();
            dcity=model.getdepart_city();
            acity=model.getarrival_city();

                if(model.getdepart_city().equals("Hyderabad"))
                {
                    textView1.setText("Rajiv Gandhi International Airport");

                }
                else if(model.getdepart_city().equals("Delhi"))
                {
                    textView1.setText("Indira Gandhi International Airport");
                }
                else if(model.getdepart_city().equals("Chennai"))
                {
                    textView1.setText("Chennai International Airport");
                }
                if(model.getarrival_city().equals("Hyderabad"))
                {
                    textView2.setText("Rajiv Gandhi International Airport");

                }
                else if(model.getarrival_city().equals("Delhi"))
                {
                    textView2.setText("Indira Gandhi International Airport");
                }
                else if(model.getarrival_city().equals("Chennai"))
                {
                    textView2.setText("Chennai International Airport");
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
            ArrayList<TravelModel> list1=new ArrayList<TravelModel>();

                for (int i = 0; i < list.size(); i++) {
                    databaseReference2=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("adult").child(list.get(i));
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            TravelModel model2 = dataSnapshot.getValue(TravelModel.class);
                            if(model2!=null){
                            list1.add(model2);}
                        }
                        @Override
                        public void onCancelled(DatabaseError error) {
                            Log.i("DAta","Failed to read value." + error.toException());
                        }
                    });
                    databaseReference3=firebaseDatabase.getReference("login").child("users").child(logged).child("travel_names").child("child").child(list.get(i));
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            TravelModel model2 = dataSnapshot.getValue(TravelModel.class);
                            if(model2!=null){
                                list1.add(model2);}
                        }
                        @Override
                        public void onCancelled(DatabaseError error) {
                            Log.i("DAta","Failed to read value." + error.toException());
                        }
                    });
                }
                recyclerView = (RecyclerView)findViewById(R.id.success_RecyclerView);
                cityModelArrayList = new ArrayList<>();

                for (int i = 0; i < list1.size(); i++) {
                    TravelModel beanClassForRecyclerView_contacts = list1.get(i);
                    cityModelArrayList.add(beanClassForRecyclerView_contacts);
                }

                cityRecyAdapter = new TravelCycAdapter(flight_details.this,cityModelArrayList);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(flight_details.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(cityRecyAdapter);

                info.setText(""+model.getdepart_city().substring(0,3).toUpperCase()+" - "+""+model.getarrival_city().substring(0,3).toUpperCase());
                info2.setText(""+model.getStop_txt()+" | "+"General");
                d_date.setText("23 Nov 2021");
                info3.setText(""+model.getAirIndia_Txt());
                info4.setText(""+model.getNumber_Txt());
                info5.setText(""+model.getDepart_txt());
                info6.setText(""+model.getHour_txt());
                info7.setText(""+model.getStop_txt());
                info8.setText("23 Nov 2021");
                info9.setText("23 Nov 2021");
                price=Double.parseDouble(model.getRupees_Txt());
                number1=model1.classes.substring(0,1);
                info10.setText(""+model.getdepart_city().substring(0,3)+" - "+model.getarrival_city().substring(0,3));
                number=Integer.parseInt(number1);
//                Toast.makeText(flight_review.this, " "+number ,Toast.LENGTH_SHORT).show();
//                info10.setText("₹ "+price*number);
//                info11.setText("For "+user.Number);
                TextView textVie2=findViewById(R.id.price1);
                textVie2.setText("Travellers "+number+" x ₹"+model.getRupees_Txt()+" + Discounts");
                TextView textView1=findViewById(R.id.txtamount);
                textView1.setText(""+(model1.total-700));
                TextView textView3=findViewById(R.id.tprice);
                textView3.setText(""+model1.total);


            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.i("DAta","Failed to read value." + error.toException());
            }
        });
TextView whatsapp=findViewById(R.id.whatsapp);
whatsapp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendwhatsapp();
    }
});
TextView call=findViewById(R.id.call);
call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        callPhone();
    }
});
TextView email=findViewById(R.id.mail);
email.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendEmail();
    }
});
TextView share=findViewById(R.id.share);
share.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendshare();
    }
});
        LinearLayout linearLayout=findViewById(R.id.rules);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(flight_details.this,fare_rules.class);
                startActivity(intent);
            }
        });
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.getOverflowIcon().setTint(Color.parseColor("#ffffff"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_booking:
                sendshare();
                return true;
            case R.id.download_ticket:
                generatePDF();
                return true;
            case R.id.print_invoice:
                generateInvoice();
                return true;
            case R.id.cancel_booking:
                Intent intent=new Intent(flight_details.this,booking_details.class);
                intent.putExtra("logged",logged);
                intent.putExtra("yes",clickeditem);
                startActivity(intent);
                finish();
                System.exit(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void callPhone(){
//        Intent intent=new Intent(Intent.ACTION_CALL);
//        Uri uri=Uri.parse("tel:+917660993300");
//        intent.setData(uri);
//        String[] permissions={Manifest.permission.CALL_PHONE};
//        if (ActivityCompat.checkSelfPermission(flight_details.this,
//                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(flight_details.this,permissions,100);
//        }
//        startActivity(intent);
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:07660993300"));

        if (ActivityCompat.checkSelfPermission(flight_details.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);


    }
    void sendwhatsapp(){
        Intent waIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + "917660993300" + "&text=" + "Id "+clickeditem+" : Please help me out with my booking"));
        startActivity(waIntent);
    }
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"koduru.reddy.19cse@bmu.edu.in"};
        String[] CC = {"sireeshr001@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "AirEasy Customer Care Id:"+clickeditem);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Please Write your problem here \n\n\n\n\n\n\n\n\n\n\n Regards\nAirEasy Team\nCEO Sireesh Reddy");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(flight_details.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    void sendshare() {
        Log.i("Send email", "");

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear "+name+",Your flight booking is confirmed for travel from "+dcity+" to "+acity+" on 23 Nov 2021 at "+ddate+".\n\nYour flight "+numbers+" will depart from Terminal 1, Chennai International Airport \n\nCabin baggage per adult/child is 7Kgs and check-in baggage is 15Kgs.\\n\\nImportant information: We wish to remind you that AirEasy never asks for your personal banking and security details like passwords, CVV, OTP, etc. For any queries, please reach out to us via the help section on our mobile app");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(flight_details.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
    void generatePDF() {

        PdfDocument pdfDocument = new PdfDocument();
        Paint paint = new Paint();
        Paint title = new Paint();
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);
        Canvas canvas = myPage.getCanvas();
        canvas.drawBitmap(scaledbmp, 56, 40, paint);
        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        title.setTextSize(15);
        title.setColor(ContextCompat.getColor(this, R.color.dark_blue));
        canvas.drawText("Flight from "+dcity+" to "+acity+" has been booked, Successfully on "+ddate+ "Flight No: "+numbers, 209, 100, title);
        canvas.drawText("AirEasy", 209, 80, title);
        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        title.setColor(ContextCompat.getColor(this, R.color.dark_blue));
        title.setTextSize(15);
        title.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("This is Flight Ticket which we have created.", 396, 560, title);
        pdfDocument.finishPage(myPage);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "AirEasy Ticket.pdf");

        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(flight_details.this, "PDF file generated successfully.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdfDocument.close();
    }
void generateInvoice(){
    PdfDocument pdfDocument = new PdfDocument();
    Paint paint = new Paint();
    Paint title = new Paint();
    PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();
    PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);
    Canvas canvas = myPage.getCanvas();
    canvas.drawBitmap(scaledbmp, 56, 40, paint);
    title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
    title.setTextSize(15);
    title.setColor(ContextCompat.getColor(this, R.color.dark_blue));
    canvas.drawText("Flight from "+dcity+" to "+acity+" has been booked, Successfully on "+ddate+ "Flight No: "+numbers, 209, 100, title);
    canvas.drawText("AirEasy", 209, 80, title);
    title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    title.setColor(ContextCompat.getColor(this, R.color.dark_blue));
    title.setTextSize(15);
    title.setTextAlign(Paint.Align.CENTER);
    canvas.drawText("This is a Invoice file for Flight no: "+numbers+" which we have created.", 396, 560, title);
    pdfDocument.finishPage(myPage);
    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "AirEasy Invoice.pdf");

    try {
        pdfDocument.writeTo(new FileOutputStream(file));
        Toast.makeText(flight_details.this, "PDF file generated successfully.", Toast.LENGTH_SHORT).show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    pdfDocument.close();
}
    private boolean checkPermission() {
        // checking of permissions.
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        // requesting permissions if not provided.
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }

}
