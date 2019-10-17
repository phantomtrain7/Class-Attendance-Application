package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassesActivity extends AppCompatActivity {

    private ImageView ActivityClassesLogoIV;
    private TextView ActivityClassesViewClassesTV, ActivityClassesNewClassesTV, ActivityUnitsNewUnitTV;
    private Button ActivityClassesHomeBTN, ActivityClassesBackBTN;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        ActivityClassesLogoIV = findViewById(R.id.classeslogoIV);
        ActivityClassesViewClassesTV = findViewById(R.id.viewclassesTV);
        ActivityClassesNewClassesTV = findViewById(R.id.newclassTV);
        ActivityUnitsNewUnitTV = findViewById(R.id.newunitTV);
        ActivityClassesHomeBTN = findViewById(R.id.classeshomeBTN);
        ActivityClassesBackBTN = findViewById(R.id.classesbackbtn);
        loadingBar = new ProgressDialog(this);

        ActivityClassesBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassesActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        ActivityClassesViewClassesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassesActivity.this, ViewClassesActivity.class);
                startActivity(intent);
            }
        });
        ActivityClassesNewClassesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ClassesActivity.this, NewClassesActivity.class);
                    startActivity(intent);
                }catch (Exception e){
                    Log.e("ActivityClassesViewClassesTV", e.getMessage(), e);
                }
            }
        });
        ActivityClassesHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassesActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        ActivityUnitsNewUnitTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassesActivity.this, NewClassesActivity.class);
                startActivity(intent);
            }
        });
    }
}
