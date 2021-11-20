package com.cuberto.AirEasy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.ItemClickListener;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.cuberto.AirEasy.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FlightAdapter extends RecyclerView.ViewHolder {
//    FirebaseRecyclerAdapter<FlightModel, ViewHolder> firebaseRecyclerAdapter;
//    FirebaseRecyclerOptions<FlightModel> itemFirebaseRecyclerOptions;
    Context context;
    ArrayList<FlightModel> models;
//
//    public FlightAdapter(Context context, ArrayList<FlightModel> models) {
//        this.context = context;
//        this.models = models;
//    }

//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference=firebaseDatabase.getReference("login");
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight, parent, false);
//ViewHolder viewHolder=new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position,FlightModel model1) {
//
//        FlightModel model = models.get(position);
//
//
//        holder.flight_Img.setImageResource(model.getFlight_Img());
//        holder.airIndia_Txt.setText(model.getAirIndia_Txt());
//        holder.number_Txt.setText(model.getNumber_Txt());
//        holder.rupees_Txt.setText(model.getRupees_Txt());
//        holder.arrival_Txt.setText(model.getArrival_Txt());
//        holder.hour_txt.setText(model.getHour_txt());
//        holder.stop_txt.setText(model.getStop_txt());
//        holder.depart_txt.setText(model.getDepart_txt());
//
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onclick(View view, int positon) {
//                FlightModel clickmodel=model1;
//
//            }
//        });
//    }

        public ImageView flight_Img;
        public TextView airIndia_Txt,number_Txt,rupees_Txt,arrival_Txt,hour_txt,stop_txt,depart_txt;
ItemClickListener itemClickListener;
public void setItemClickListener(ItemClickListener itemClickListener){
    this.itemClickListener=itemClickListener;
}

        public FlightAdapter(View itemView) {
            super(itemView);

//            flight_Img = itemView.findViewById(R.id.flight_Img);
            airIndia_Txt = itemView.findViewById(R.id.airIndia_Txt);
            number_Txt = itemView.findViewById(R.id.number_Txt);
            rupees_Txt = itemView.findViewById(R.id.rupees_Txt);
            arrival_Txt = itemView.findViewById(R.id.arrival_Txt);
            hour_txt = itemView.findViewById(R.id.hour_txt);
            stop_txt = itemView.findViewById(R.id.stop_txt);
            depart_txt = itemView.findViewById(R.id.depart_txt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onclick(itemView,getBindingAdapterPosition());
                }
            });
        }
    }

