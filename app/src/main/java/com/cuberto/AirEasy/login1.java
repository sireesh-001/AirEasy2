package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class login1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        EditText view1=(EditText)findViewById(R.id.lgmail);
        EditText view2=(EditText)findViewById(R.id.lpass);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("login");
        ImageView button1=(ImageView) findViewById(R.id.log);
        Button button=findViewById(R.id.signuplb);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login1.this,SignUp.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1=view1.getText().toString();
                String v2=view2.getText().toString();
//                User user=new User(v1,v2);
//               databaseReference.child("users").child("1").setValue(user);
                databaseReference.child("users").child(v1).child("login_details").child("password").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            String pass=String.valueOf(task.getResult().getValue());
                            if(pass.equals(v2)){
                                Intent intent = new Intent(login1.this,Home.class);
                                intent.putExtra("logged",v1);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(login1.this,"Please Enter the correct details",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}