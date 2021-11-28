package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

import in.aabhasjindal.otptextview.OtpTextView;

public class change_email extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("login");
    String logged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_email);
        logged=getIntent().getStringExtra("logged");
        TextView textView=findViewById(R.id.em);
        TextView textView1=findViewById(R.id.place);
        Button button=findViewById(R.id.upemail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("users").child(logged).child("login_details").child("email").setValue(textView.getText().toString());
                Toast.makeText(change_email.this,"changed email",Toast.LENGTH_SHORT).show();
            }
        });
        Button button1=findViewById(R.id.uppass);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("users").child(logged).child("login_details").child("password").setValue(textView1.getText().toString());
                Toast.makeText(change_email.this,"changed password",Toast.LENGTH_SHORT).show();
            }
        });
        ImageView textView3=findViewById(R.id.imgback);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(change_email.this,profile.class);
                intent.putExtra("logged",logged);
                startActivity(intent);
            }
        });


    }


}
