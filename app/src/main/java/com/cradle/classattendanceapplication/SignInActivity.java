package com.cradle.classattendanceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cradle.classattendanceapplication.Model.Users;
import com.cradle.classattendanceapplication.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class SignInActivity extends AppCompatActivity {

    private ImageView SignInLogoIV;
    private EditText SignInPhoneNumberET, SignInPasswordET;
    private Button SignInBTN, SignInHomeBTN;
    private TextView SignInCreateAccTV;
    private ProgressDialog loadingBar;

    private String parentDbName = "Users";
    private CheckBox chkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        SignInLogoIV = findViewById(R.id.activitysigninIV);
        SignInPhoneNumberET = findViewById(R.id.activityphonenumberET);
        SignInPasswordET = findViewById(R.id.activitypasswordET);
        SignInBTN = findViewById(R.id.activitysigninBTN);
        SignInHomeBTN = findViewById(R.id.nsigninhomeBTN);
        SignInCreateAccTV = findViewById(R.id.activitycreateaccountTV);
        loadingBar = new ProgressDialog(this);
        chkBoxRememberMe = (CheckBox) findViewById(R.id.activitysigninremembermeChkBx);

        SignInHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signinhomebtnintent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(signinhomebtnintent);
            }
        });

        SignInBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LoginUser();
                }catch (Exception e){
                    Log.e("SignIn", e.getMessage(), e );
//                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        SignInCreateAccTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void LoginUser() {
        String phone = SignInPhoneNumberET.getText().toString();
        String password = SignInPasswordET.getText().toString();

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please Write your Phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Write your password...", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking your credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccesToAccount(phone, password);
        }
    }

    private void AllowAccesToAccount(final String phone, final String password) {

        try{
            if (chkBoxRememberMe.isChecked()){
                Paper.book().write(Prevalent.UserPhoneKey, phone);
                Paper.book().write(Prevalent.UserPasswordKey, password);
            }

            final DatabaseReference RootRef;
            RootRef = FirebaseDatabase.getInstance().getReference();

            RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(parentDbName).child(phone).exists()){
                        Users usersData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);

                        if (usersData.getPhone().equals(phone)){
            //                if (usersData.getPassword().equals(password)){
                                Toast.makeText(SignInActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                                startActivity(intent);
           //                 }
             //               else {
               //                 loadingBar.dismiss();
                 //               Toast.makeText(SignInActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                   //         }
                        }
                    }
                    else {
                        Toast.makeText(SignInActivity.this, "Account with this" + phone + "do not exists", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                        Toast.makeText(SignInActivity.this, "You need to create a new account", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch (Exception e){
            Log.e("SignIn", e.getMessage(), e );
        }

    }
}
