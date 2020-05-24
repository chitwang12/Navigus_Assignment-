package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mauth;
    private FirebaseDatabase db;

    private EditText etEmailRegister,etPasswordRegister;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmailRegister=findViewById(R.id.etEmailRegister);
        etPasswordRegister=findViewById(R.id.etPasswordRegister);
        btnRegister=findViewById(R.id.btnRegister);


        mauth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmailRegister.getText().toString().isEmpty()||
                        etPasswordRegister.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Enter All fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    register();
                }
            }
        });

    }
    private void register()
    {
        mauth.createUserWithEmailAndPassword(etEmailRegister.getText().toString(),etPasswordRegister.getText().toString()).
                addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(RegisterActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,LoginActivityUser.class));
                        RegisterActivity.this.finish();
                    }
                }).
                addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
