package com.cuberto.AirEasy.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.cuberto.AirEasy.R;
import com.cuberto.AirEasy.flight_details;


public class UpcomingFlightFragment extends Fragment {

    CardView cardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.flight_layout, container, false);

        cardView = view.findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), flight_details.class);
                startActivity(intent);
            }
        });

        return  view;
    }

}
