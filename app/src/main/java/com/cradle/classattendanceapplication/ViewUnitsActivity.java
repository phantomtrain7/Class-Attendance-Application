package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewUnitsActivity extends AppCompatActivity {

    private ImageView mViewUnitsLogoIV;
    private TextView mViewUnitsSloganTV;
    private Button mViewUnitsBackBTN, mViewUnitsHomeBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_units);

        mViewUnitsLogoIV = findViewById(R.id.viewunitslogoIV);
        mViewUnitsSloganTV = findViewById(R.id.viewunitssloganTV);
        mViewUnitsBackBTN = findViewById(R.id.viewunitsbackbtn);
        mViewUnitsHomeBTN = findViewById(R.id.viewunitshomeBTN);

        mViewUnitsHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewUnitsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
