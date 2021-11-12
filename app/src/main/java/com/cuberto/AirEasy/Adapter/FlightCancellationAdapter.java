package com.cuberto.AirEasy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.ModelClass.FlightCancellationModel;
import com.cuberto.AirEasy.R;

public class FlightCancellationAdapter extends RecyclerView.Adapter<FlightCancellationAdapter.MyViewHolder> {

    private ArrayList<FlightCancellationModel> cancellationModels;
    private Context context;


    public FlightCancellationAdapter(ArrayList<FlightCancellationModel> cancellationModels, Context context) {
        this.cancellationModels = cancellationModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flight_cancellation, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FlightCancellationModel model = cancellationModels.get(position);

        holder.sourceDes.setText(model.getSourceDes());
    }

    @Override
    public int getItemCount() {
        return cancellationModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sourceDes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sourceDes = itemView.findViewById(R.id.source_des);

        }
    }
}
