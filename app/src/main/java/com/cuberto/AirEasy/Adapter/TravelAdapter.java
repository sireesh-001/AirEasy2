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


public class TravelAdapter extends RecyclerView.ViewHolder {
    Context context;
    ArrayList<FlightModel> models;
    public ImageView flight_Img;
    public TextView name,gender;
    ItemClickListener itemClickListener;
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
    public TravelAdapter(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        gender=itemView.findViewById(R.id.gender);
        TextView button=itemView.findViewById(R.id.edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onclick(button,getBindingAdapterPosition());
            }
        });
    }
}

