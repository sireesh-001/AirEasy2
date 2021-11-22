package com.cuberto.AirEasy.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.cuberto.AirEasy.Adapter.BookFlightPagerAdapter;
import com.cuberto.AirEasy.ItemClickListener;
import com.cuberto.AirEasy.ModelClass.FlightModel;
import com.cuberto.AirEasy.ModelClass.UserModel;
import com.cuberto.AirEasy.flight_details;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;

import com.cuberto.AirEasy.Adapter.BookingFlightPagerAdapter;
import com.cuberto.AirEasy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FlightFragment extends Fragment {

    ViewPager viewpager1;
    TabLayout tablayout1;
    RecyclerView recyclerView;
    String clickeditem;
    String logged;
    FirebaseRecyclerAdapter<UserModel, BookingFlightPagerAdapter> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<UserModel> itemFirebaseRecyclerOptions;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flight, container, false);
        logged = getArguments().getString("logged");
        /* Tablayout code is here*/
//        viewpager1 = view.findViewById(R.id.viewpager_genealogy);
        tablayout1 = view.findViewById(R.id.tablayout_genealogy);
        databaseReference=firebaseDatabase.getReference("login").child("users").child(logged).child("flight_details");
        tablayout1.addTab(tablayout1.newTab().setText("Upcoming"));
        tablayout1.addTab(tablayout1.newTab().setText("Past "));
        tablayout1.addTab(tablayout1.newTab().setText("Cancelled"));


//        BookingFlightPagerAdapter adapter = new BookingFlightPagerAdapter(getChildFragmentManager(), tablayout1.getTabCount());
//        viewpager1.setAdapter(adapter);
        recyclerView=view.findViewById(R.id.flight_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        update();
//        viewpager1.setOffscreenPageLimit(2);
//        viewpager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout1));
//        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                viewpager1.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//
//            }
//        });



        return  view;
    }
    void update(){

        itemFirebaseRecyclerOptions=new FirebaseRecyclerOptions.Builder<UserModel>().setQuery(databaseReference,UserModel.class).build();
        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<UserModel, BookingFlightPagerAdapter>(itemFirebaseRecyclerOptions) {
            @Override
            public void onBindViewHolder(@NonNull final BookingFlightPagerAdapter holder, final int position, UserModel model) {


//                holder.flight_Img.setImageResource(model.getFlight_Img());

                holder.arrival_city.setText(model.model.getarrival_city());
                holder.depart_city.setText(model.model.getdepart_city());
                holder.airIndia_Txt.setText(model.model.getAirIndia_Txt());
                holder.number_Txt.setText(model.model.getNumber_Txt());
                holder.short1.setText(model.model.getdepart_city().substring(0,3).toUpperCase());
                holder.short2.setText(model.model.getarrival_city().substring(0,3).toUpperCase());
                holder.arrival_Txt.setText(model.model.getArrival_Txt());
                holder.hour_txt.setText(model.model.getHour_txt());
                holder.stop_txt.setText(model.model.getStop_txt());
                holder.depart_txt.setText(model.model.getDepart_txt());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onclick(View view, int positon) {
                        UserModel clickmodel=model;
                        clickeditem=getSnapshots().getSnapshot(positon).getKey();
                        holder.bookid.setText("Booking #"+clickeditem);
                        Toast.makeText(getActivity(), " "+clickeditem ,Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getActivity(), flight_details.class);
                        intent.putExtra("flight",clickeditem);
                        intent.putExtra("logged",logged);
                        startActivity(intent);
                    }
                });}


            @NonNull
            @Override
            public BookingFlightPagerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_layout, parent, false);
                BookingFlightPagerAdapter viewHolder=new BookingFlightPagerAdapter(view);
                return viewHolder;
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
