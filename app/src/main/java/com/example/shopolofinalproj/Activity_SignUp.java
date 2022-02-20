package com.example.shopolofinalproj;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Activity_SignUp extends AppCompatActivity {

    private MaterialTextView signUp_LBL_EDT;
    private EditText signUp_EDT_userFirstName;
    private EditText signUp_EDT_userLastName;
    private EditText signUp_EDT_userEmail;
    private EditText signUp_EDT_userPassword;
    private MaterialButton signUp_BTN_sign;
    private String firstNameInput = "";
    private String lastNameInput = "";
    private String emailInput = "";
    private String passwordInput = "";
    private FirebaseAuth mAuth;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        findViews();
        initViews();

    }

    private void initViews() {
        signUp_BTN_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        firstNameInput = signUp_EDT_userFirstName.getText().toString().trim();
        lastNameInput = signUp_EDT_userLastName.getText().toString().trim();
        emailInput = signUp_EDT_userEmail.getText().toString().trim();
        passwordInput = signUp_EDT_userPassword.getText().toString().trim();
        if(checkErrorInputs(emailInput,passwordInput,firstNameInput,lastNameInput) == false){
            return;
        }
        else{
            mAuth.createUserWithEmailAndPassword(emailInput, passwordInput).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Activity_SignUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity_SignUp.this, Activity_Login.class));
                    } else {
                        Toast.makeText(Activity_SignUp.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });

           }
        hideSystemUI();

    }

    private boolean checkErrorInputs(String email, String password,String firstName,String lastName) {
        if (email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()){
            Toast.makeText(Activity_SignUp.this, "Please Fill Email/Password/Full Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if( isValidEmail(email) == false ){
            Toast.makeText(Activity_SignUp.this, "Please Enter A Valid EMAIL!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(isValidPassword(password) == false){
            Toast.makeText(Activity_SignUp.this, "Password Must be 6 digits!", Toast.LENGTH_SHORT).show();
            return false;

        }
        if(isValidName(firstName) == false || isValidName(lastName)== false){
            Toast.makeText(Activity_SignUp.this, "Name must be at least 2 letters / ONLY LETTERS!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean isValidName(String Name) {
        if(Name.length() <2)
            return false;
        else{
            return Name.matches("[a-zA-Z]+");
        }
    }

    private boolean isValidPassword(String password){
        return TextUtils.isDigitsOnly(password) && password.length() == 6;
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void findViews() {
        signUp_EDT_userFirstName =findViewById(R.id.signUp_EDT_userFirstName);
        signUp_EDT_userLastName = findViewById(R.id.signUp_EDT_userLastName);
        signUp_EDT_userEmail = findViewById(R.id.signUp_EDT_userEmail);
        signUp_EDT_userPassword = findViewById(R.id.signUp_EDT_userPassword);
        signUp_BTN_sign = findViewById(R.id.signUp_BTN_sign);
        signUp_LBL_EDT = findViewById(R.id.signUp_LBL_EDT);
    }

    public void hideSystemUI() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}