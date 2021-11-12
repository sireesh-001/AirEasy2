package com.cuberto.AirEasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mobile_veri extends AppCompatActivity {

    TextView tv_verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_veri);

        tv_verify = findViewById(R.id.tv_verify);
        tv_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(MobileVerificationActivity.this,LoginActivity.class);
//                startActivity(intent);
            }
        });
    }
}
