package com.cuberto.AirEasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("login");
        String number= getIntent().getStringExtra("logged");

        databaseReference.child("offers").child("offer1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    String pass=String.valueOf(task.getResult().getValue());
                    Log.i("getting data:", pass);
//                    StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(pass);
                    ImageView imageView=findViewById(R.id.image6);
//                    Glide.with(Home.this /* context */)
//                            .load(storageReference)
//                            .into(imageView);
                    Picasso.get().load(pass).into(imageView);
                }
            }
        });
        databaseReference.child("users").child(number).child("login_details").child("firstname").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    String pass=String.valueOf(task.getResult().getValue());
                    TextView textView6=findViewById(R.id.textView6);
                    textView6.setText(""+pass);
                }
            }
        });
        EditText editText=findViewById(R.id.rectangle_4);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,one_round.class);
                Userdetails user=new Userdetails();
                intent.putExtra("logged",number);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        ImageView imageView=findViewById(R.id.imageView5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,booking_details.class);
                intent.putExtra("logged",number);
                startActivity(intent);
            }
        });
        ImageView imageView1=findViewById((R.id.imageView6));
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,profile.class);
                intent.putExtra("logged",number);
                startActivity(intent);
            }
        });
    }
}