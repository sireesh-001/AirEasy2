package com.cuberto.AirEasy.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.ItemClickListener;
import com.cuberto.AirEasy.ModelClass.FlightSearchResultModelClass;
import com.cuberto.AirEasy.R;


public class FlightSearchResultRecyAdapter extends RecyclerView.ViewHolder {

//    Context context;
//    private ArrayList<FlightSearchResultModelClass> bonusModelArrayList;
//
//    public FlightSearchResultRecyAdapter(Context context, ArrayList<FlightSearchResultModelClass> bonusModelArrayList) {
//        this.context = context;
//        this.bonusModelArrayList = bonusModelArrayList;
//    }



    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }

        TextView tvTitle,tvPrice;
        LinearLayout llBg;
    ItemClickListener itemClickListener;
    public TextView airIndia_Txt,number_Txt,rupees_Txt,arrival_Txt,hour_txt,stop_txt,depart_txt;
        public FlightSearchResultRecyAdapter(View view){

            super(view);
            airIndia_Txt = itemView.findViewById(R.id.tvTitle);
            number_Txt = itemView.findViewById(R.id.number_Txt);
            rupees_Txt = itemView.findViewById(R.id.tvPrice);
            arrival_Txt = itemView.findViewById(R.id.arrival_Txt);
            hour_txt = itemView.findViewById(R.id.hour_txt);
            stop_txt = itemView.findViewById(R.id.stop_txt);
            depart_txt = itemView.findViewById(R.id.depart_txt);

            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            llBg = (LinearLayout) view.findViewById(R.id.llBg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onclick(itemView,getBindingAdapterPosition());
                }
            });
        }



//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_flight_search_result_list, parent, false);
//
//        return new MyViewHolder(itemView);
//
//    }

//    @Override
//    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
//
//        FlightSearchResultModelClass lists = bonusModelArrayList.get(position);
//
//
//        holder.tvTitle.setText(lists.getTvTitle());
//        holder.tvPrice.setText(lists.getTvPrice());
//
//
////        if(position==2){
////
////            holder.llBg.setBackgroundColor(Color.parseColor("#e3f5ff"));
////        }else if(position==5){
////
////            holder.llBg.setBackgroundColor(Color.parseColor("#e3f5ff"));
////        }
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return bonusModelArrayList.size();
//
//    }

}


