package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private ImageView nMainActivityLogoIV;
    private TextView nMainActivitySloganTV;
    private Button nMainActivityAttendanceBTN, nMainActivityClassesBTN, nMainactivityHomeBackBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nMainActivityLogoIV = findViewById(R.id.homeLogoIV);
        nMainActivitySloganTV = findViewById(R.id.homeSloganTV);
        nMainActivityAttendanceBTN = findViewById(R.id.homeattendanceBTN);
        nMainActivityClassesBTN = findViewById(R.id.homeclassesBTN);
        nMainactivityHomeBackBTN = findViewById(R.id.homebackbtn);

        nMainactivityHomeBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nMainActivityAttendanceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AttendanceActivity.class);
                startActivity(intent);
            }
        });
        nMainActivityClassesBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ClassesActivity.class);
                startActivity(intent);
            }
        });
    }
}
