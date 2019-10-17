package com.cradle.classattendanceapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt.CryptoObject;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt.AuthenticationCallback;
import android.hardware.biometrics.BiometricPrompt.AuthenticationResult;
import android.hardware.biometrics.BiometricPrompt.Builder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Signature;
import java.util.HashMap;

public class NewStudentActivity extends AppCompatActivity {

    private EditText mNewStudentFirstNameET, mNewStudentMiddleNameET, mNewStudentRegistrationNumberET, mNewStudentPhoneNumberET, mNewStudentClassCodeET;
    private ImageView mNewStudentFingerPrintIdIV;
    private Button mSubmitBTN;
    private ProgressDialog loadingBar;
    BiometricPrompt.CryptoObject mCryptoObject;
    public BiometricManager mnBiometricManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        mNewStudentFirstNameET = findViewById(R.id.nnewstudentfirstnameET);
        mNewStudentMiddleNameET = findViewById(R.id.nnewstudentmiddlenameET);
        mNewStudentRegistrationNumberET = findViewById(R.id.nnewstudentregistrationnumberET);
        mNewStudentClassCodeET = findViewById(R.id.nnewstudentclasscodeET);
        mNewStudentPhoneNumberET = findViewById(R.id.nnewstudentphonenumberET);
        mNewStudentFingerPrintIdIV = findViewById(R.id.nnewstudentfingerprintidIV);
        mSubmitBTN = findViewById(R.id.nsubmitBTN);

        mNewStudentFingerPrintIdIV.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Toast.makeText(NewStudentActivity.this, "Place finger on scanner", Toast.LENGTH_SHORT).show();

                String signature = mCryptoObject.getSignature().toString();


            }
        });

        mSubmitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitStudentDetails();
            }
        });

    }


    private void SubmitStudentDetails() {
        String newstudentfirstname = mNewStudentFirstNameET.getText().toString();
        String newstudentmiddlename = mNewStudentMiddleNameET.getText().toString();
        String newstudentregistrationnumber = mNewStudentRegistrationNumberET.getText().toString();
        String newstudentclasscode = mNewStudentClassCodeET.getText().toString();
        String newstudentphonenumber = mNewStudentPhoneNumberET.getText().toString();
        String newstudentfingerprintid = mNewStudentFingerPrintIdIV.getImageMatrix().toString();

        if (TextUtils.isEmpty(newstudentfirstname))
            Toast.makeText(this, "Please write your First name...", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(newstudentmiddlename))
            Toast.makeText(this, "Please write your Middle Name...", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(newstudentregistrationnumber))
            Toast.makeText(this, "Please write your Student Registration Number...", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(newstudentclasscode))
            Toast.makeText(this, "Please write your Class Code...", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(newstudentphonenumber))
            Toast.makeText(this, "Please write your Phone Number...", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(newstudentfingerprintid))
            Toast.makeText(this, "Please add your fingerprint...", Toast.LENGTH_SHORT).show();
        else {
            loadingBar.setTitle("Saving Information");
            loadingBar.setMessage("Please wait, while we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            validatefingerPrint(newstudentfirstname, newstudentmiddlename, newstudentregistrationnumber, newstudentclasscode, newstudentphonenumber, newstudentfingerprintid);
    }
}

    private void validatefingerPrint(final String newstudentfirstname, final String newstudentmiddlename, final String newstudentregistrationnumber, final String newstudentclasscode, final String newstudentphonenumber, final String newstudentfingerprintid) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(newstudentfingerprintid).exists())){
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("fisrt name", newstudentfirstname);
                    userdataMap.put("middle name", newstudentmiddlename);
                    userdataMap.put("student registration number", newstudentregistrationnumber);
                    userdataMap.put("student class code", newstudentclasscode);
                    userdataMap.put("student phone number", newstudentphonenumber);
                    userdataMap.put("student fingerprint", newstudentfingerprintid);


                    RootRef.child("Users").child(newstudentfingerprintid).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(NewStudentActivity.this, "Congratulations, your details have been saved.", Toast.LENGTH_LONG).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(NewStudentActivity.this, NewClassesActivity.class);
                                startActivity(intent);
                            }
                            else {
                                loadingBar.dismiss();
                                Toast.makeText(NewStudentActivity.this, "Network Error: Please try again after some time...", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(NewStudentActivity.this, "This" + newstudentfingerprintid + " already exists.", Toast.LENGTH_LONG).show();
                    loadingBar.dismiss();
                    Toast.makeText(NewStudentActivity.this, "Please try again using another fingerprint.", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(NewStudentActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
