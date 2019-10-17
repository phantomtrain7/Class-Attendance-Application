package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AttendanceActivity extends AppCompatActivity {

    private ImageView ActivityAttendanceLogoIV;
    private TextView ActivityAttendanceSloganTV, ActivityAttendanceViewAttendanceTV, ActivityAttendanceTakeAttendanceTV;
    private Button ActivityAttendancehomeBTN, ActivityAttendanceBackBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        ActivityAttendanceLogoIV = findViewById(R.id.attendancelogoIV);
        ActivityAttendanceSloganTV = findViewById(R.id.attendancesloganTV);
        ActivityAttendanceViewAttendanceTV = findViewById(R.id.viewattendanceTV);
        ActivityAttendanceTakeAttendanceTV = findViewById(R.id.takeattendanceTV);
        ActivityAttendancehomeBTN = findViewById(R.id.attendancehomeBTN);
        ActivityAttendanceBackBTN = findViewById(R.id.attendancebackbtn);

        ActivityAttendanceBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AttendanceActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        ActivityAttendancehomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actatthomeintent = new Intent(AttendanceActivity.this, HomeActivity.class);
                startActivity(actatthomeintent);
            }
        });

        ActivityAttendanceViewAttendanceTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendanceActivity.this, ViewAttendanceActivity.class);
                startActivity(intent);
            }
        });
        ActivityAttendanceTakeAttendanceTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AttendanceActivity.this, TakeAttendanceActivity.class);
                startActivity(intent);
            }
        });
    }
}
