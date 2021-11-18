package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.cuberto.AirEasy.User;
import java.util.concurrent.TimeUnit;

import de.blox.graphview.Edge;

public class SignUp extends AppCompatActivity {
    LinearLayout ll_register;
    FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sign_up);
        EditText editText1=findViewById(R.id.firstname);
        EditText editText2=findViewById(R.id.lastname);
        EditText editText3=findViewById(R.id.email);
        EditText editText4=findViewById(R.id.mnumber);
        EditText editText5=findViewById(R.id.dob);
        EditText editText6=findViewById(R.id.pass);
        EditText editText7=findViewById(R.id.pin);
        CheckBox checkBox=findViewById(R.id.check1);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("login");
        imageView = findViewById(R.id.imgback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });


        ll_register = findViewById(R.id.ll_register);
        ll_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber=editText4.getText().toString();
                String firstname=editText1.getText().toString();
                String lastname=editText2.getText().toString();
                String email=editText3.getText().toString();
                String dob=editText5.getText().toString();
                String password=editText6.getText().toString();
                String pin=editText7.getText().toString();
                User user=new User(firstname,lastname,email,phoneNumber,dob,password,pin);
                if(checkBox.isChecked()){
//                databaseReference.child("users").child(phoneNumber).setValue(user);
                Intent intent = new Intent(SignUp.this,mobile_veri.class);
                intent.putExtra("key",user);
                startActivity(intent);}
                else{
                    Toast.makeText(SignUp.this,"Please ACCPECT the conditions",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}