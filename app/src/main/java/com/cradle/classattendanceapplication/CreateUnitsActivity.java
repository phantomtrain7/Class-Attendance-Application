package com.cradle.classattendanceapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateUnitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_units);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("First Activity");

        final EditText mCreateUnitUnitCodeET = findViewById(R.id.ncreateunitunitcodeET);
        final Button mCreateUnitSaveBTN = findViewById(R.id.ncreateunitsaveBTN);

        mCreateUnitSaveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unitcode = mCreateUnitUnitCodeET.getText().toString();


                Intent intent = new Intent(CreateUnitsActivity.this, NewClassesActivity.class);
                intent.putExtra("UNITCODE", unitcode);
                startActivity(intent);

            }
        });

    }
}
