package com.cuberto.AirEasy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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


public class SuccessAdapter extends RecyclerView.ViewHolder {
    Context context;

    public TextView name,gender,pnr;

    public SuccessAdapter(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        gender=itemView.findViewById(R.id.gender);
        pnr=itemView.findViewById(R.id.pnr);
    }
}

