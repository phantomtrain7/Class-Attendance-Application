package com.cradle.classattendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt.AuthenticationCallback;
import android.hardware.biometrics.BiometricPrompt.AuthenticationResult;
import android.hardware.biometrics.BiometricPrompt.Builder;
import android.hardware.biometrics.BiometricPrompt.CryptoObject;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cradle.classattendanceapplication.Biometric.BiometricCallBack;


public class TakeAttendanceActivity extends AppCompatActivity implements BiometricCallBack {

    private Button mScanBTN, mHomeBTN, mBackBTN;
    private ImageView mTakeAttendanceLogoIV;
    private TextView mTakeAttendanceSloganTV;
    BiometricManager mBiometricManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        mScanBTN = findViewById(R.id.nscanBTN);
        mHomeBTN = findViewById(R.id.takeattendancehomeBTN);
        mTakeAttendanceLogoIV = findViewById(R.id.takeattendancelogoIV);
        mTakeAttendanceSloganTV = findViewById(R.id.takeattendancesloganTV);
        mBackBTN = findViewById(R.id.takeattendancebackBTN);

        mBackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TakeAttendanceActivity.this, AttendanceActivity.class);
                startActivity(intent);
            }
        });

        mHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nhomebtnintent = new Intent(TakeAttendanceActivity.this, MainActivity.class);
                startActivity(nhomebtnintent);
            }
        });

        mScanBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                 *
                 * */
                //mBiometricManager = new BiometricManager.BiometricBuilder(TakeAttendanceActivity.this)
                //        .setTitle("Scan")
                //        .setSubtitle("Today's Attendance")
                //        .setDescription("Place your finger on the scanner to take your attendance")
                //        .setNegativeButtonText("Cancel")
                //        .build();

                //.start authentication
                //mBiometricManager.Authenticate(TakeAttendanceActivity.this);
            }
        });
    }

    @Override
    public void onSdkVersionNotSupported() {
        Toast.makeText(getApplicationContext(), "sdk version not supported", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBiometricAuthenticationNotSupported() {
        Toast.makeText(getApplicationContext(), "Device does not support biometric authentication", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBiometricAuthenticationNotAvailable() {
        Toast.makeText(getApplicationContext(), "Fingerprint is not registered in device", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(getApplicationContext(), "Permission is not granted by user", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBiometricAuthenticationInternalError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAuthenticationFailed() {
//        Toast.makeText(getApplicationContext(), getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAuthenticationCancelled() {
        Toast.makeText(getApplicationContext(), "Authentication cancelled by user", Toast.LENGTH_LONG).show();
 //       mBiometricManager.cancelAuthenticatiom();
    }

    @Override
    public void onAuthenticationSuccessful() {
        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
//        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
//        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }
}
