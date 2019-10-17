package com.cradle.classattendanceapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewClassesActivity extends AppCompatActivity {

    private TextView mCreateClassTV, mAvailablaClassTV, mAddStudentToClassCodeTV, mCreateUnitsTV, mAvailableUnitsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_classes);

        mCreateClassTV = findViewById(R.id.ncreateclassTV);
        mAvailablaClassTV = findViewById(R.id.navailableclassTV);
        mAddStudentToClassCodeTV = findViewById(R.id.naddstudenttoclasscodeTV);
        mCreateUnitsTV = findViewById(R.id.ncreateunitsTV);
        mAvailableUnitsTV = findViewById(R.id.navailableunitsTV);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Second Activity");

        Intent intent = getIntent();
        String classcode = intent.getStringExtra("CLASSCODE");
        String unitcode = intent.getStringExtra("UNITCODE");
//todo store to firebase and retrieve

        mAvailablaClassTV.setText("CLASSCODE: "+classcode);
        mAvailableUnitsTV.setText("UNITCODE: "+unitcode);

        mCreateClassTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreateclass = new Intent(NewClassesActivity.this, CreateClassesActivity.class);
                startActivity(intentcreateclass);
            }
        });
        mAddStudentToClassCodeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentaddstudent = new Intent(NewClassesActivity.this, NewStudentActivity.class);
                startActivity(intentaddstudent);
            }
        });
        mCreateUnitsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewClassesActivity.this, CreateUnitsActivity.class);
                startActivity(intent);
            }
        });
    }
}
