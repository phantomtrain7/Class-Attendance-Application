package com.cradle.classattendanceapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class SignUpActivity extends AppCompatActivity {

    private ImageView ActivitySignUpLogoIV;
    private EditText SignUpRawUsernameET, SignUpSirnameET, SignUpFirstnameET, SignUpMiddlenameET, SignUpLecturerRegistrationNumberET,
            SignUpNationalIdET, SignUpPhoneNumberET, SignUpRawEmailAddressET, SignUpRawPasswordET, SignUpConfirmPasswordET;
    private Button ActivitySignUpBTN, ActivitySignUpHomeBTN;
    private TextView ActivityAlreadySignedUpTV;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActivitySignUpLogoIV = findViewById(R.id.activitysignupIV);
        SignUpRawUsernameET = findViewById(R.id.rawusernameET);
        SignUpSirnameET = findViewById(R.id.sirnameET);
        SignUpFirstnameET = findViewById(R.id.firstnameET);
        SignUpMiddlenameET = findViewById(R.id.middlenameET);
        SignUpLecturerRegistrationNumberET = findViewById(R.id.lecturerregistrationnumberET);
        SignUpNationalIdET = findViewById(R.id.nationalidET);
        SignUpPhoneNumberET = findViewById(R.id.phonenumberET);
        SignUpRawEmailAddressET = findViewById(R.id.rawemailaddressET);
        SignUpRawPasswordET = findViewById(R.id.rawpasswordET);
        SignUpConfirmPasswordET = findViewById(R.id.confirmpasswordET);
        ActivitySignUpBTN = findViewById(R.id.signupBTN);
        ActivitySignUpHomeBTN = findViewById(R.id.nsignuphomeBTN);
        ActivityAlreadySignedUpTV = findViewById(R.id.alreadysignedupTV);
        loadingBar = new ProgressDialog(this);

        ActivitySignUpHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signuphomebtnintent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(signuphomebtnintent);
            }
        });

        ActivityAlreadySignedUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentalr = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intentalr);
            }
        });


        ActivitySignUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }


    private void CreateAccount() {

        String signupusername = SignUpRawUsernameET.getText().toString();
        String signupsirname = SignUpSirnameET.getText().toString();
        String signupfirstname = SignUpFirstnameET.getText().toString();
        String signupmiddlename = SignUpMiddlenameET.getText().toString();
        String signuplecturerregistrationnumber = SignUpLecturerRegistrationNumberET.getText().toString();
        String signupnationalid = SignUpNationalIdET.getText().toString();
        String signupphonenumber = SignUpPhoneNumberET.getText().toString();
        String signuprawemailaddress = SignUpRawEmailAddressET.getText().toString();
        String signuppassword = SignUpRawPasswordET.getText().toString();
        String signupconfirmpassword = SignUpConfirmPasswordET.getText().toString();

        if (TextUtils.isEmpty(signupusername)){
            Toast.makeText(this, "Please write your username...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signupsirname)){
            Toast.makeText(this, "Please write your Sir Name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signupfirstname)){
            Toast.makeText(this, "Please write your First Name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signupmiddlename)){
            Toast.makeText(this, "Please write your Middle Name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signuplecturerregistrationnumber)){
            Toast.makeText(this, "Please write your Registration Number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signupnationalid)){
            Toast.makeText(this, "Please write your National Identity Number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signupphonenumber)){
            Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signuprawemailaddress)){
            Toast.makeText(this, "Please write your Email Address...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signuppassword)){
            Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(signupconfirmpassword)){
            Toast.makeText(this, "Please repeat your password...", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            ValidatephoneNumber(signupusername, signupsirname, signupfirstname, signupmiddlename,signuplecturerregistrationnumber,
                    signupnationalid, signupphonenumber, signuprawemailaddress, signuppassword, signupconfirmpassword);
        }
    }

    private void ValidatephoneNumber(final String signupusername, final String signupsirname, final String signupfirstname,
                                     final String signupmiddlename, final String signuplecturerregistrationnumber,
                                     final String signupnationalid,
                                     final String signupphonenumber, final String signuprawemailaddress, final String signuppassword, final String signupconfirmpassword) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(signupphonenumber).exists())){
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("phone", signupphonenumber);
                    userdataMap.put("sirname", signupsirname);
                    userdataMap.put("firstname", signupfirstname);
                    userdataMap.put("middlename", signupmiddlename);
                    userdataMap.put("lecturerregistationnumber", signuplecturerregistrationnumber);
                    userdataMap.put("nationid", signupnationalid);
                    userdataMap.put("Password", signuppassword);
                    userdataMap.put("emailaddress", signuprawemailaddress);
                    userdataMap.put("Username", signupusername);
                    userdataMap.put("confirmpassword", signupconfirmpassword);

                    RootRef.child("Users").child(signupphonenumber).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Congratulations, your Account has been created.", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                startActivity(intent);
                            }
                            else {
                                loadingBar.dismiss();
                                Toast.makeText(SignUpActivity.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(SignUpActivity.this, "This" + signupphonenumber + " already exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(SignUpActivity.this, "Please try again using another phone number.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
