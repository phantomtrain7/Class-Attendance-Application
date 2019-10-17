package com.cradle.classattendanceapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateClassesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_classes);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("First Activity");

        final EditText mCreateClassClassCodeET = findViewById(R.id.ncreateclassclasscodeET);
        final Button mCreateClassSaveBTN = findViewById(R.id.ncreateclasssaveBTN);

        mCreateClassSaveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classcode = mCreateClassClassCodeET.getText().toString();


                Intent intent = new Intent(CreateClassesActivity.this, NewClassesActivity.class);
                intent.putExtra("CLASSCODE", classcode);
                startActivity(intent);

            }
        });
    }
}
