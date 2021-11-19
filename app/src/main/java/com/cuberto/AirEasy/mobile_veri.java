package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class mobile_veri extends AppCompatActivity {
    FirebaseAuth auth;
    TextView tv_verify;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference("login");
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    User user;
    private String verificationCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_veri);
        OtpTextView otpView;
        otpView = findViewById(R.id.otp_view);
        StartFirebaseLogin();
        user = (User) getIntent().getSerializableExtra("key");
        TextView textView1=findViewById(R.id.number);
        textView1.setText(""+user.mnumber);
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91"+user.mnumber)// Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(mobile_veri.this)                 // Activity (for callback binding)
                        .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        TextView textView=findViewById(R.id.edit);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_verify = findViewById(R.id.tv_verify);
        tv_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp= otpView.getOTP();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
                SigninWithPhone(credential);
            }
        });
    }
    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(mobile_veri.this,"verification completed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(mobile_veri.this,"verification fialed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(mobile_veri.this,"Code sent",Toast.LENGTH_SHORT).show();
            }
        };
    }
    private void SigninWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            databaseReference.child("users").child(user.mnumber).child("login_details").setValue(user);
                            startActivity(new Intent(mobile_veri.this,login1.class));
                            finish();
                        } else {
                            Toast.makeText(mobile_veri.this,"Incorrect OTP",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
