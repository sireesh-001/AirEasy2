package com.cuberto.AirEasy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.ModelClass.WardModel;
import com.cuberto.AirEasy.R;


public class WardAdapter extends RecyclerView.Adapter<WardAdapter.ViewHolder> {

    Context context;
    ArrayList<WardModel> models;
    int mypos = 0;

    public WardAdapter(Context context, ArrayList<WardModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ward, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        WardModel model = models.get(position);

        holder.time_Txt.setText(model.getTime_Txt());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView time_Txt;

        CheckBox tiCheckBox;


        public ViewHolder(View itemView) {
            super(itemView);
            time_Txt = itemView.findViewById(R.id.time_Txt);
        }
    }
}
