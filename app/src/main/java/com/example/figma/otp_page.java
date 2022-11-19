package com.example.figma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;


public class otp_page<mCallback> extends AppCompatActivity {
    public static String prefs_name="myprefsfiles";

    Button proceed, resend;
    EditText digit1, digit2, digit3, digit4, digit5, digit6;
    String verification;
    String number;
    FirebaseAuth mAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        verification = getIntent().getStringExtra("code");
        number = getIntent().getStringExtra("number");
        proceed = (Button) findViewById(R.id.proceed);
        resend = (Button) findViewById(R.id.resentbtn);
        digit1 = findViewById(R.id.digit1);
        digit2 = findViewById(R.id.digit2);
        digit3 = findViewById(R.id.digit3);
        digit4 = findViewById(R.id.digit4);
        digit5 = findViewById(R.id.digit5);
        digit6 = findViewById(R.id.digit6);
        mAuth = FirebaseAuth.getInstance();
        proceedAction();
        resendAction();
        Otpmove();
        // resend();
    }

    private void resendAction() {
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOtp(number);
            }
        });
    }
  private void sendOtp(String number) {
        PhoneAuthOptions options= PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber("+91"+number)
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                    }

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        verification=s;
                    }
                })

                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }




    private void Otpmove() {
        digit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!digit1.getText().toString().isEmpty()){
                    digit2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        digit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!digit2.getText().toString().isEmpty()){
                    digit3.requestFocus();
                }else{
                    digit1.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        digit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!digit3.getText().toString().isEmpty()){
                    digit4.requestFocus();
                }else{
                    digit2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        digit4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!digit4.getText().toString().isEmpty()){
                    digit5.requestFocus();
                }else{
                    digit3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        digit5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!digit5.getText().toString().isEmpty()){
                    digit6.requestFocus();
                }else{
                    digit4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        digit6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(digit6.getText().toString().isEmpty()){
                    digit5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }





    void proceedAction(){
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(digit1.getText().toString().isEmpty() ||
                   digit2.getText().toString().isEmpty() ||
                   digit3.getText().toString().isEmpty() ||
                   digit4.getText().toString().isEmpty() ||
                   digit5.getText().toString().isEmpty() ||
                   digit6.getText().toString().isEmpty()
                        ){
                    Toast.makeText(otp_page.this, "enter the full otp", Toast.LENGTH_SHORT).show();

                }else{
                    String otp=digit1.getText().toString()+
                            digit2.getText().toString()+
                            digit3.getText().toString()+
                            digit4.getText().toString()+
                            digit5.getText().toString()+
                            digit6.getText().toString();

                    if(verification!=null){
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(
                                verification,otp
                        );
                        FirebaseAuth.getInstance().signInWithCredential(credential).
                                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            SharedPreferences sharedPreferences=getSharedPreferences(otp_page.prefs_name,0);
                                            SharedPreferences.Editor editor=sharedPreferences.edit();
                                            editor.putBoolean("hasLoggined",true);
                                            editor.commit();
                                            Intent details = new Intent(otp_page.this, details_page.class);
                                            startActivity(details);
                                        }else{
                                            Toast.makeText(getApplicationContext(),"enter the correct otp",Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });

                    }


                }

            }
        });
    }

}