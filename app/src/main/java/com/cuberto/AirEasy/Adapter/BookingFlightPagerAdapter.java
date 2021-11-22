//package com.cuberto.AirEasy.Adapter;
//
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//
//import com.cuberto.AirEasy.AirEasy.UpcomingFlightFragment;
//
//public class BookingFlightPagerAdapter extends FragmentStatePagerAdapter {
//
//    public BookingFlightPagerAdapter(FragmentManager fm, int tabCount) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//
//        switch (position) {
//
//            case 0:
//                UpcomingFlightFragment tab1 = new UpcomingFlightFragment();
//                return tab1;
//            case 1:
//                UpcomingFlightFragment tab2 = new UpcomingFlightFragment();
//                return tab2;
//            case 2:
//                UpcomingFlightFragment tab3 = new UpcomingFlightFragment();
//                return tab3;
//
//
//            default:
//                return null;
//
//        }
//    }
//
//        @Override
//        public int getCount () {
//
//            return 3;
//
//        }
//    }
//
//
package com.cuberto.AirEasy.Adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.cuberto.AirEasy.AirEasy.UpcomingFlightFragment;
import com.cuberto.AirEasy.ItemClickListener;
import com.cuberto.AirEasy.R;

public class BookingFlightPagerAdapter extends RecyclerView.ViewHolder {
    public ImageView flight_Img;
    public TextView short1,short2,bookid,arrival_city,depart_city,airIndia_Txt,number_Txt,rupees_Txt,arrival_Txt,hour_txt,stop_txt,depart_txt;
    ItemClickListener itemClickListener;
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }

    public BookingFlightPagerAdapter(View itemView) {

        super(itemView);

//            flight_Img = itemView.findViewById(R.id.flight_Img);
        bookid=itemView.findViewById(R.id.bookid);
        arrival_city=itemView.findViewById(R.id.arrival_city);
        depart_city=itemView.findViewById(R.id.depart_city);
        airIndia_Txt = itemView.findViewById(R.id.airIndia_Txt);
        number_Txt = itemView.findViewById(R.id.number_Txt);
        short1=itemView.findViewById(R.id.short1);
        short2=itemView.findViewById(R.id.short2);
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


