package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivityUser extends AppCompatActivity {

    private EditText etEmailLoginUser,etPasswordLoginUser;
    private Button btnLoginUser;
    private FirebaseAuth mauth;
    private FirebaseDatabase db;
    private TextView tvRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_user);
        etEmailLoginUser=findViewById(R.id.etEmailLoginUser);
        etPasswordLoginUser=findViewById(R.id.etPasswordLoginUser);
        btnLoginUser=findViewById(R.id.btnLoginUser);
        tvRegister=findViewById(R.id.tvRegister);

        mauth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivityUser.this,RegisterActivity.class));
            }
        });

        btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmailLoginUser.getText().toString().isEmpty()||
                        etPasswordLoginUser.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivityUser.this, "Enter All fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loginUser();
                }
            }
        });

    }

    private void loginUser()
    {
        mauth.signInWithEmailAndPassword(etEmailLoginUser.getText().toString(),etPasswordLoginUser.getText().toString()).
        addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivityUser.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivityUser.this,AdminPanel.class));
                LoginActivityUser.this.finish();
            }
        }).
                addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivityUser.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
