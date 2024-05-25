package com.example.mob2041_ph28509.Activity;

import android.os.Bundle;

import com.example.mob2041_ph28509.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private TextInputEditText editTextPassword;
    private EditText edt_Email;
    private Button btnLoginEmail;
    private TextView tv_SignUp,tv_Forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(MainActivity.this.getWindow(), false);
        setContentView(R.layout.activity_main);
        edt_Email = findViewById(R.id.edt_Email);
        editTextPassword = findViewById(R.id.edt_Password);
        tv_Forgot = findViewById(R.id.tv_ForgotPassword);
        tv_SignUp = findViewById(R.id.tv_SignUp);
        btnLoginEmail = findViewById(R.id.btn_Login);
        textInputLayout = findViewById(R.id.textInputLayoutPass);
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // Nếu có focus, đặt hint trên EditText thành null để nó biến mất
                if (hasFocus) {
                    textInputLayout.setHintEnabled(false);
                }else if (!hasFocus && !editTextPassword.getText().toString().isEmpty()) {
                    textInputLayout.setHintEnabled(false);
                }else {
                    textInputLayout.setHintEnabled(true);
                    textInputLayout.setHint("Enter your password...");
                }
            }
        });
        btnLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv_Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}