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


public class TravelAdapter extends RecyclerView.ViewHolder {
    Context context;
    ArrayList<FlightModel> models;
    public TextView name,gender;
    public CheckBox button1;
    public int n=0;
    ItemClickListener itemClickListener,itemClickListener1;
    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
    public void setItemClickListener1(ItemClickListener itemClickListener1){
        this.itemClickListener1=itemClickListener1;
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
        button1=itemView.findViewById(R.id.check_join);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=1;
                itemClickListener1.onclick(button1,getBindingAdapterPosition());
            }
        });
    }
}

