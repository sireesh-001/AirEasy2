package com.cuberto.AirEasy.Adapter;//package com.cuberto.liquidswipetest.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.ModelClass.CityModel;
import com.cuberto.AirEasy.R;

import java.util.ArrayList;


public class CityRecyAdapter extends RecyclerView.Adapter<CityRecyAdapter.MyViewHolder> {

    Activity context;
    private ArrayList<CityModel> cityModelArrayList;

    public CityRecyAdapter(Activity context, ArrayList<CityModel> cityModelArrayList) {
        this.context = context;
        this.cityModelArrayList = cityModelArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView txtcity;

        public MyViewHolder(View view) {

            super(view);

            txtcity = (TextView) view.findViewById(R.id.txtcity);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        CityModel lists = cityModelArrayList.get(position);

        holder.txtcity.setText(lists.getTxtcity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent();
//                intent.putExtra("city", holder.txtcity.getText());
//                context.setResult(Activity.RESULT_OK, intent);
//                context.finish();

            }
        });


    }

    @Override
    public int getItemCount() {

        return cityModelArrayList.size();

    }

}


