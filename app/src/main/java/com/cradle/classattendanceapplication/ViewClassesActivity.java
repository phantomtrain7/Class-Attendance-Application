package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewClassesActivity extends AppCompatActivity {

    private ImageView mViewClassesLogoIV;
    private TextView mViewClassesSloganIV;
    private Button mViewClassesBackBTN, mViewClassesHomeBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_classes);

        mViewClassesLogoIV = findViewById(R.id.viewclasseslogoIV);
        mViewClassesSloganIV = findViewById(R.id.viewclassessloganTV);
        mViewClassesBackBTN = findViewById(R.id.viewclassesbackbtn);
        mViewClassesHomeBTN = findViewById(R.id.viewclasseshomeBTN);

        mViewClassesBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewClassesActivity.this, ClassesActivity.class);
                startActivity(intent);
            }
        });

        mViewClassesHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewClassesActivity.this, ClassesActivity.class);
                startActivity(intent);
            }
        });

    }
}
