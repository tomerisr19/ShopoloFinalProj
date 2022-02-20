package com.example.shopolofinalproj;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Activity_Login extends AppCompatActivity {

    private MaterialTextView login_LBL_EDT;
    private EditText login_useremail_EDT;
    private EditText login_userpassword_EDT;
    private MaterialButton login_BTN_connect;
    private MaterialButton login_BTN_signup;
    private String emailInput = "";
    private String passwordInput = "";
    private FirebaseAuth mAuth;
    private DatabaseReference db;
    boolean signout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance().getReference();
        findViews();
        initViews();
        login_BTN_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        signout = getIntent().getBooleanExtra("signout", false);
        if(signout)
            signOut();

    }

    private void connectClicked() {
        emailInput = login_useremail_EDT.getText().toString().trim();
        passwordInput = login_userpassword_EDT.getText().toString().trim();
        if(!checkErrorInputs(emailInput, passwordInput)){
            Log.d("pttt","Error details -->Password or Email");
        }
        else{
            login();
        }

    }

    private boolean checkErrorInputs(String email, String password) {
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(Activity_Login.this, "Please Fill Email/Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!isValidEmail(email)){
            Toast.makeText(Activity_Login.this, "Please Enter A Valid EMAIL!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!isValidPassword(password)){
            Toast.makeText(Activity_Login.this, "Password Must be 6 digits!", Toast.LENGTH_SHORT).show();
            return false;

        }

        return true;
    }

    private boolean isValidPassword(String password){
        return TextUtils.isDigitsOnly(password) && password.length() == 6;
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void login() {
        emailInput = login_useremail_EDT.getText().toString().trim();
        passwordInput = login_userpassword_EDT.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(emailInput, passwordInput).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Activity_Login.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_Login.this, MainActivity.class));


                } else {
                    Toast.makeText(Activity_Login.this, "The password or email is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        login_BTN_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectClicked();
            }
        });
        login_BTN_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Login.this, Activity_SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        hideSystemUI();
    }

    private void signOut() {
        // Firebase sign out
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();

        // Google sign out
        GoogleSignIn.getClient(
                Activity_Login.this,
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        ).signOut();

        Toast.makeText(Activity_Login.this, "Signed out successfully", Toast.LENGTH_SHORT).show();
        signout = false;
    }

    private void findViews() {
        login_LBL_EDT=findViewById(R.id.login_LBL_EDT);
        login_useremail_EDT=findViewById(R.id.login_useremail_EDT);
        login_userpassword_EDT=findViewById(R.id.login_userpassword_EDT);
        login_BTN_connect=findViewById(R.id.login_BTN_connect);
        login_BTN_signup = findViewById(R.id.login_BTN_signup);

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

