package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NewUnitsActivity extends AppCompatActivity {

    private ImageView mNewUnitsLogoIV;
    private TextView mNewUnitsSloganTV;
    private Button mNewUnitsBackBTN, mNewUnitsHomeBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_units);

        mNewUnitsLogoIV = findViewById(R.id.newunitslogoIV);
        mNewUnitsSloganTV = findViewById(R.id.newunitssloganTV);
        mNewUnitsBackBTN = findViewById(R.id.newunitsbackbtn);
        mNewUnitsHomeBTN = findViewById(R.id.newunitshomeBTN);

        mNewUnitsHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewUnitsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
