package com.cuberto.AirEasy.AirEasy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.cuberto.AirEasy.Adapter.FlightBaggagesAdapter;
import com.cuberto.AirEasy.ModelClass.FlightBaggagesModel;
import com.cuberto.AirEasy.R;

public class FlightBaggagesFragment extends Fragment {

    private FlightBaggagesAdapter adapter;
    private ArrayList<FlightBaggagesModel> models;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flightbaggages_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.baggages_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        models = new ArrayList<>();

        models.add(new FlightBaggagesModel("DEL - BOM"));
        models.add(new FlightBaggagesModel("BOM - DEL"));

        adapter = new FlightBaggagesAdapter(models,getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
