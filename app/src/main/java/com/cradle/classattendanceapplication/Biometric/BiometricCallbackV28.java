package com.cradle.classattendanceapplication.Biometric;

import android.hardware.biometrics.BiometricPrompt;

public class BiometricCallbackV28 extends BiometricPrompt.AuthenticationCallback {

    private BiometricCallBack biometricCallBack;
    public BiometricCallbackV28(BiometricCallBack biometricCallback) {
        this.biometricCallBack = biometricCallback;
    }

    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        biometricCallBack.onAuthenticationSuccessful();
    }


    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
        biometricCallBack.onAuthenticationHelp(helpCode, helpString);
    }


    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        biometricCallBack.onAuthenticationError(errorCode, errString);
    }


    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        biometricCallBack.onAuthenticationFailed();
    }

}
