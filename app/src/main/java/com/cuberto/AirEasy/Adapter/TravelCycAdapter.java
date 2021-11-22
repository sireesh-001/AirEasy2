package com.cuberto.AirEasy.Adapter;//package com.cuberto.liquidswipetest.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.ModelClass.CityModel;
import com.cuberto.AirEasy.ModelClass.TravelModel;
import com.cuberto.AirEasy.R;
import com.cuberto.AirEasy.one_round;
import com.cuberto.AirEasy.onewaybooking;
import com.cuberto.AirEasy.to_city;

import java.util.ArrayList;


public class TravelCycAdapter extends RecyclerView.Adapter<TravelCycAdapter.MyViewHolder> {

    Activity context;
    private ArrayList<TravelModel> cityModelArrayList;

    public TravelCycAdapter(Activity context, ArrayList<TravelModel> cityModelArrayList) {
        this.context = context;
        this.cityModelArrayList = cityModelArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView name,gender,pnr;

        public MyViewHolder(View view) {

            super(view);

            name=itemView.findViewById(R.id.name);
            gender=itemView.findViewById(R.id.gender);
            pnr=itemView.findViewById(R.id.pnr);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pnrdetails, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        TravelModel lists = cityModelArrayList.get(position);

        holder.name.setText(""+lists.getname());
        holder.gender.setText(""+lists.getGender());
        holder.pnr.setText(""+lists.pnr);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(flight_details., " "+lists.name ,Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {

        return cityModelArrayList.size();

    }

}


