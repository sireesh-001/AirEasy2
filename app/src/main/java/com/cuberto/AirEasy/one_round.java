package com.cuberto.AirEasy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class one_round extends Fragment implements View.OnClickListener {
//    View view;
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        view=inflater.inflate(R.layout.fragment_one_round, container, false);
//        return view;
//    }
    ImageView imageView;
    TextView oneWay_Txt, trip_Txt, today1, today2,textView;
    Spinner spinner_travellers, spinner_class;
    LinearLayout depart_linear, return_linear,city1,city2;
    private int mMonth, mYear, mDay;
    Button searchBtn;
    TextView textView1,textView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_one_round, container, false);
        searchBtn = view.findViewById(R.id.searchBtn);
        textView1=view.findViewById(R.id.oneWay_Txt);
        textView2=view.findViewById(R.id.trip_Txt);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getCurrentTextColor()==Color.parseColor("#ffffff")){
                    Intent intent = new Intent(getActivity(),onewaybooking.class);
                    startActivity(intent);
                }
                else if(textView2.getCurrentTextColor()==Color.parseColor("#ffffff")){
                Intent intent = new Intent(getActivity(),twowaybooking.class);
                startActivity(intent);
                }
            }
        });
city1=view.findViewById(R.id.fromcity);
city1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),Search_from_city.class);
              startActivity(intent);
    }
});
        city2=view.findViewById(R.id.tocity);
        city2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),to_city.class);
                startActivity(intent);
            }
        });
        imageView = view.findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView = view.findViewById(R.id.txtmobepay);
        textView.setText("Flight Search");

        oneWay_Txt = view.findViewById(R.id.oneWay_Txt);
        trip_Txt = view.findViewById(R.id.trip_Txt);
        oneWay_Txt.setOnClickListener(this);
        trip_Txt.setOnClickListener(this);

        /*spinner code*/
        spinner_travellers = view.findViewById(R.id.spinner_travellers);
        spinner_class = view.findViewById(R.id.spinner_class);

        List<String> list = new ArrayList<String>();
        list.add("1 Traveller");
        list.add("2 Traveller");
        list.add("3 Traveller");
        list.add("4 Traveller");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_spinnerdatatravellum,R.id.spinner_text1, list);
        spinner_travellers.setAdapter(dataAdapter);

        List<String> list1 = new ArrayList<String>();
        list1.add("Business");
        list1.add("Normal");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), R.layout.item_spinnerdatatravellum,
                R.id.spinner_text1, list1);
        spinner_class.setAdapter(dataAdapter1);

        depart_linear = view.findViewById(R.id.depart_linear);
        return_linear = view.findViewById(R.id.return_linear);

        today1 = view.findViewById(R.id.today1);
        today2 = view.findViewById(R.id.today2);




        depart_linear.setOnClickListener(v -> {
            Calendar mcurrentDate = Calendar.getInstance();
            mYear = mcurrentDate.get(Calendar.YEAR);
            mMonth = mcurrentDate.get(Calendar.MONTH);
            mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                    Calendar myCalendar = Calendar.getInstance();
                    myCalendar.set(Calendar.YEAR, selectedyear);
                    myCalendar.set(Calendar.MONTH, selectedmonth);
                    myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                    SimpleDateFormat formatter = new SimpleDateFormat("d MMM,yyyy");

                    today1.setText(formatter.format(myCalendar.getTime()));
                    mDay = selectedday;
                    mMonth = selectedmonth;
                    mYear = selectedyear;
                }
            }, mYear, mMonth, mDay);
            mDatePicker.show();
        });



        return_linear.setOnClickListener(v -> {
            Calendar mcurrentDate = Calendar.getInstance();
            mYear = mcurrentDate.get(Calendar.YEAR);
            mMonth = mcurrentDate.get(Calendar.MONTH);
            mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
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
                }
            }, mYear, mMonth, mDay);
            mDatePicker.show();
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oneWay_Txt:
                oneWay_Txt.setTextColor(Color.parseColor("#ffffff"));
                trip_Txt.setTextColor(Color.parseColor("#adadad"));
                oneWay_Txt.setBackgroundResource(R.drawable.rectangle_blue_leftcure);
                trip_Txt.setBackgroundResource(R.drawable.rectangle_graywhite_rightcure);
                break;
            case R.id.trip_Txt:
                oneWay_Txt.setTextColor(Color.parseColor("#adadad"));
                trip_Txt.setTextColor(Color.parseColor("#ffffff"));
                oneWay_Txt.setBackgroundResource(R.drawable.rectangle_graywhite_leftcure);
                trip_Txt.setBackgroundResource(R.drawable.rectangle_blue_rightcure);
                break;
        }

    }
}