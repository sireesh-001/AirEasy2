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

import com.cuberto.AirEasy.Adapter.FlightCancellationAdapter;
import com.cuberto.AirEasy.ModelClass.FlightCancellationModel;
import com.cuberto.AirEasy.R;

public class FlightDataChangeFragment extends Fragment {

    private FlightCancellationAdapter adapter;
    private ArrayList<FlightCancellationModel> models;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cancellation_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.cancel_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        models = new ArrayList<>();

        models.add(new FlightCancellationModel("DEL - BOM"));
        models.add(new FlightCancellationModel("BOM - DEL"));

        adapter = new FlightCancellationAdapter(models,getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
