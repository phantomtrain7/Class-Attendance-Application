package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewAttendanceActivity extends AppCompatActivity {

    private ImageView mViewAttendanceLogoIV;
    private TextView mViewAttendanceDateTV, mViewAttendanceSloganTV;
    private Button mViewAttendanceHomeBTN, mViewAttendanceBackBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        mViewAttendanceDateTV = findViewById(R.id.nviewattendancedateTV);
        mViewAttendanceHomeBTN = findViewById(R.id.viewattendancehomeBTN);
        mViewAttendanceLogoIV = findViewById(R.id.viewattendancelogoIV);
        mViewAttendanceSloganTV = findViewById(R.id.viewattendancesloganTV);
        mViewAttendanceBackBTN = findViewById(R.id.viewattendancebackBTN);

        mViewAttendanceBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewAttendanceActivity.this, AttendanceActivity.class);
                startActivity(intent);
            }
        });

        mViewAttendanceHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewattendanehomebtnintent = new Intent(ViewAttendanceActivity.this, MainActivity.class);
                startActivity(viewattendanehomebtnintent);
            }
        });

    }
}
