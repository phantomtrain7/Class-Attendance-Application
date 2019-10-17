package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageView mainactivitylogoIV;
    private TextView mainactivitysloganTV;
    private Button mainactivitysigninBTN, mainactivitysignupBTN, mainactivityskipBTN;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainactivitylogoIV = findViewById(R.id.appLogoIV);
        mainactivitysloganTV = findViewById(R.id.appSloganTV);
        mainactivitysigninBTN = findViewById(R.id.appLoginBTN);
        mainactivitysignupBTN = findViewById(R.id.appRegisterBTN);
        mainactivityskipBTN = findViewById(R.id.directBTN);
        loadingBar = new ProgressDialog(this);

        mainactivitysigninBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        mainactivitysignupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        mainactivityskipBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skipintent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(skipintent);
            }
        });

    }
}
