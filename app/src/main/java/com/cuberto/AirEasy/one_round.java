package com.cuberto.AirEasy;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//public class one_round extends Fragment implements View.OnClickListener {
////    View view;
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        view=inflater.inflate(R.layout.fragment_one_round, container, false);
////        return view;
////    }
//    ImageView imageView;
//    TextView oneWay_Txt, trip_Txt, today1, today2,textView;
//    Spinner spinner_travellers, spinner_class;
//    LinearLayout depart_linear, return_linear,city1,city2;
//    private int mMonth, mYear, mDay;
//    Button searchBtn;
//    TextView textView1,textView2;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        View view=inflater.inflate(R.layout.fragment_one_round, container, false);
//        searchBtn = view.findViewById(R.id.searchBtn);
//        textView1=view.findViewById(R.id.oneWay_Txt);
//        textView2=view.findViewById(R.id.trip_Txt);
//
//        searchBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(textView1.getCurrentTextColor()==Color.parseColor("#ffffff")){
//                    Intent intent = new Intent(getActivity(),onewaybooking.class);
//                    startActivity(intent);
//                }
//                else if(textView2.getCurrentTextColor()==Color.parseColor("#ffffff")){
//                Intent intent = new Intent(getActivity(),twowaybooking.class);
//                startActivity(intent);
//                }
//            }
//        });
//city1=view.findViewById(R.id.fromcity);
//city1.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(),Search_from_city.class);
//              startActivity(intent);
//    }
//});
//        city2=view.findViewById(R.id.tocity);
//        city2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),to_city.class);
//                startActivity(intent);
//            }
//        });
//        imageView = view.findViewById(R.id.imgback);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        textView = view.findViewById(R.id.txtmobepay);
//        textView.setText("Flight Search");
//
//        oneWay_Txt = view.findViewById(R.id.oneWay_Txt);
//        trip_Txt = view.findViewById(R.id.trip_Txt);
//        oneWay_Txt.setOnClickListener(this);
//        trip_Txt.setOnClickListener(this);
//
//        /*spinner code*/
//        spinner_travellers = view.findViewById(R.id.spinner_travellers);
//        spinner_class = view.findViewById(R.id.spinner_class);
//
//        List<String> list = new ArrayList<String>();
//        list.add("1 Traveller");
//        list.add("2 Traveller");
//        list.add("3 Traveller");
//        list.add("4 Traveller");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_spinnerdatatravellum,R.id.spinner_text1, list);
//        spinner_travellers.setAdapter(dataAdapter);
//
//        List<String> list1 = new ArrayList<String>();
//        list1.add("Business");
//        list1.add("Normal");
//        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), R.layout.item_spinnerdatatravellum,
//                R.id.spinner_text1, list1);
//        spinner_class.setAdapter(dataAdapter1);
//
//        depart_linear = view.findViewById(R.id.depart_linear);
//        return_linear = view.findViewById(R.id.return_linear);
//
//        today1 = view.findViewById(R.id.today1);
//        today2 = view.findViewById(R.id.today2);
//
//
//
//
//        depart_linear.setOnClickListener(v -> {
//            Calendar mcurrentDate = Calendar.getInstance();
//            mYear = mcurrentDate.get(Calendar.YEAR);
//            mMonth = mcurrentDate.get(Calendar.MONTH);
//            mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
//
//            DatePickerDialog mDatePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
//                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                    Calendar myCalendar = Calendar.getInstance();
//                    myCalendar.set(Calendar.YEAR, selectedyear);
//                    myCalendar.set(Calendar.MONTH, selectedmonth);
//                    myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
//                    SimpleDateFormat formatter = new SimpleDateFormat("d MMM,yyyy");
//
//                    today1.setText(formatter.format(myCalendar.getTime()));
//                    mDay = selectedday;
//                    mMonth = selectedmonth;
//                    mYear = selectedyear;
//                }
//            }, mYear, mMonth, mDay);
//            mDatePicker.show();
//        });
//
//
//
//        return_linear.setOnClickListener(v -> {
//            Calendar mcurrentDate = Calendar.getInstance();
//            mYear = mcurrentDate.get(Calendar.YEAR);
//            mMonth = mcurrentDate.get(Calendar.MONTH);
//            mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
//
//            DatePickerDialog mDatePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
//                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                    Calendar myCalendar = Calendar.getInstance();
//                    myCalendar.set(Calendar.YEAR, selectedyear);
//                    myCalendar.set(Calendar.MONTH, selectedmonth);
//                    myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
//                    SimpleDateFormat formatter = new SimpleDateFormat("d MMM,yyyy");
//
//                    today2.setText(formatter.format(myCalendar.getTime()));
//                    mDay = selectedday;
//                    mMonth = selectedmonth;
//                    mYear = selectedyear;
//                }
//            }, mYear, mMonth, mDay);
//            mDatePicker.show();
//        });
//        return view;
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.oneWay_Txt:
//                oneWay_Txt.setTextColor(Color.parseColor("#ffffff"));
//                trip_Txt.setTextColor(Color.parseColor("#adadad"));
//                oneWay_Txt.setBackgroundResource(R.drawable.rectangle_blue_leftcure);
//                trip_Txt.setBackgroundResource(R.drawable.rectangle_graywhite_rightcure);
//                break;
//            case R.id.trip_Txt:
//                oneWay_Txt.setTextColor(Color.parseColor("#adadad"));
//                trip_Txt.setTextColor(Color.parseColor("#ffffff"));
//                oneWay_Txt.setBackgroundResource(R.drawable.rectangle_graywhite_leftcure);
//                trip_Txt.setBackgroundResource(R.drawable.rectangle_blue_rightcure);
//                break;
//        }
//
//    }
//}
public class one_round extends AppCompatActivity implements View.OnClickListener{
    static public int h=1;
    ImageView imageView;
    TextView oneWay_Txt, trip_Txt, today1, today2,textView;
    Spinner spinner_travellers, spinner_class;
    LinearLayout depart_linear, return_linear,city1,city2;
    private int mMonth, mYear, mDay;
    String f_date="",d_date="";
    Button searchBtn;
    TextView textView1,textView2,textView3,textView4,textView5,textView6;
    Userdetails user;
    String flight;
    String number,classes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_one_round);
        user=(Userdetails)getIntent().getSerializableExtra("user");
         textView4=findViewById(R.id.value);
         textView3=findViewById(R.id.value2);
//        String value=getIntent().getStringExtra("value");
//        TextView textView=findViewById(R.id.value);
//        textView.setText(""+value);
        String logged=getIntent().getStringExtra("logged");
        depart_linear = findViewById(R.id.depart_linear);
        return_linear = findViewById(R.id.return_linear);
        spinner_travellers = findViewById(R.id.spinner_travellers);
        spinner_class = findViewById(R.id.spinner_class);
//        return_linear.setVisibility(View.INVISIBLE);
        CheckBox checkBox=findViewById(R.id.flight_Txt);
        searchBtn = findViewById(R.id.searchBtn);
        textView1=findViewById(R.id.oneWay_Txt);
        textView2=findViewById(R.id.trip_Txt);
        textView5=findViewById(R.id.shortf);
        textView6=findViewById(R.id.shortd);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String number=spinner_travellers.getTransitionName();
//                String classes=spinner_class.getTransitionName();
                number=spinner_travellers.getSelectedItem().toString();
                classes=spinner_class.getSelectedItem().toString();
                String type="stop";
                String way;
                String form1=textView4.getText().toString();
                String dest=textView3.getText().toString();
                if(checkBox.isChecked()){
                    type="Non stop";
                }
                if(type.equals("stop"))
                {
                    flight=form1+"_"+dest+"_s";
                }
                else{
                    flight=form1+"_"+dest+"_ns";
                }

                if(textView1.getCurrentTextColor()==Color.parseColor("#ffffff")){
                    way="oneway";
                    user.from1=form1;
                    user.dest=dest;
                    user.f_date=f_date;
                    user.d_date=d_date;
                    user.way=way;
                    user.classes=classes;
                    user.Number=number;
                    user.type=type;
                    Intent intent = new Intent(one_round.this,onewaybooking.class);
                    intent.putExtra("details",user);
                    intent.putExtra("logged",logged);
                    intent.putExtra("flight",flight);
                    startActivity(intent);
                }
                else if(textView2.getCurrentTextColor()==Color.parseColor("#ffffff")){
                    way="twoway";
                    user.from1=form1;
                    user.dest=dest;
                    user.f_date=f_date;
                    user.d_date=d_date;
                    user.way=way;
                    user.classes=classes;
                    user.Number=number;
                    user.type=type;
                Intent intent = new Intent(one_round.this,twowaybooking.class);
                intent.putExtra("details",user);
                intent.putExtra("logged",logged);
                intent.putExtra("flight",flight);
                startActivity(intent);
                }
            }
        });

        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
city1=findViewById(R.id.fromcity);
city1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(one_round.this,Search_from_city.class);
              startActivity(intent);
    }
});
        city2=findViewById(R.id.tocity);
        city2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(one_round.this,to_city.class);
                startActivity(intent);
            }
        });
        textView = findViewById(R.id.txtmobepay);
        textView.setText("Flight Search");

        oneWay_Txt = findViewById(R.id.oneWay_Txt);
        trip_Txt = findViewById(R.id.trip_Txt);
        oneWay_Txt.setOnClickListener(this);
        trip_Txt.setOnClickListener(this);

        List<String> list = new ArrayList<String>();
        list.add("1 Traveller");
        list.add("2 Traveller");
        list.add("3 Traveller");
        list.add("4 Traveller");
        list.add("5 Traveller");
        list.add("6 Traveller");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(one_round.this, R.layout.item_spinnerdatatravellum,
                R.id.spinner_text1, list);
        spinner_travellers.setAdapter(dataAdapter);
//        spinner_travellers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                number = list.get(position);
//            }
//        });
        List<String> list1 = new ArrayList<String>();
        list1.add("Business");
        list1.add("General");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(one_round
                .this, R.layout.item_spinnerdatatravellum,
                R.id.spinner_text1, list1);
        spinner_class.setAdapter(dataAdapter1);
//        spinner_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                number = list1.get(position);
//            }
//        });
        classes=spinner_class.getSelectedItem().toString();

        today1 = findViewById(R.id.today1);
        today2 = findViewById(R.id.today2);




        depart_linear.setOnClickListener(v -> {
            Calendar mcurrentDate = Calendar.getInstance();
            mYear = mcurrentDate.get(Calendar.YEAR);
            mMonth = mcurrentDate.get(Calendar.MONTH);
            mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker = new DatePickerDialog(one_round.this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                    Calendar myCalendar = Calendar.getInstance();
                    myCalendar.set(Calendar.YEAR, selectedyear);
                    myCalendar.set(Calendar.MONTH, selectedmonth);
                    myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("d MMM,yyyy");

                    today1.setText(formatter.format(myCalendar.getTime()));
                    mDay = selectedday;
                    mMonth = selectedmonth;
                    mYear = selectedyear;
                    f_date=""+formatter.format(myCalendar.getTime().getDate());
                }
            }, mYear, mMonth, mDay);
            mDatePicker.show();
        });



        return_linear.setOnClickListener(v -> {
            Calendar mcurrentDate = Calendar.getInstance();
            mYear = mcurrentDate.get(Calendar.YEAR);
            mMonth = mcurrentDate.get(Calendar.MONTH);
            mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker = new DatePickerDialog(one_round.this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                    Calendar myCalendar = Calendar.getInstance();
                    myCalendar.set(Calendar.YEAR, selectedyear);
                    myCalendar.set(Calendar.MONTH, selectedmonth);
                    myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                    SimpleDateFormat formatter = new SimpleDateFormat("d MMM,yyyy");

                    today2.setText(formatter.format(myCalendar.getTime()));
                    mDay = selectedday;
                    mMonth = selectedmonth;
                    mYear = selectedyear;
                    d_date=""+formatter.format(myCalendar.getTime().getDate());
                }
            }, mYear, mMonth, mDay);
            mDatePicker.show();
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));
    }
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String qty = intent.getStringExtra("city");
            if(h==1){
                textView4.setText(""+qty);
                textView5.setText(""+qty.substring(0,3).toUpperCase());
                h=2;
            }
            else if(h==2){
                textView3.setText(""+qty);
                textView6.setText(""+qty.substring(0,3).toUpperCase());
                h=1;
            }

            Toast.makeText(one_round.this, " "+qty ,Toast.LENGTH_SHORT).show();
//            Intent intent1=new Intent(to_city.this,one_round.class);
//            intent1.putExtra("value",qty);
//            startActivity(intent1);
        }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oneWay_Txt:

                if(return_linear.getVisibility()==View.VISIBLE)
                {
                    return_linear.setVisibility(View.INVISIBLE);

                }
//                depart_linear.setVisibility(View.VISIBLE);
                oneWay_Txt.setTextColor(Color.parseColor("#ffffff"));
                trip_Txt.setTextColor(Color.parseColor("#adadad"));
                oneWay_Txt.setBackgroundResource(R.drawable.rectangle_blue_leftcure);
                trip_Txt.setBackgroundResource(R.drawable.rectangle_graywhite_rightcure);
                break;
            case R.id.trip_Txt:
                if(return_linear.getVisibility()==View.INVISIBLE)
                {
                    return_linear.setVisibility(View.VISIBLE);

                }
                oneWay_Txt.setTextColor(Color.parseColor("#adadad"));
                trip_Txt.setTextColor(Color.parseColor("#ffffff"));
                oneWay_Txt.setBackgroundResource(R.drawable.rectangle_graywhite_leftcure);
                trip_Txt.setBackgroundResource(R.drawable.rectangle_blue_rightcure);
                break;
        }

    }
}