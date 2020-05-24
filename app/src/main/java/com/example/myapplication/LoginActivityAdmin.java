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

public class LoginActivityAdmin extends AppCompatActivity {

    private EditText etEmailLoginAdmin,etPasswordLoginAdmin,etCodeLoginAdmin;
    private Button btnLoginAdmin;

    private FirebaseAuth mauth;
    private FirebaseDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        etEmailLoginAdmin=findViewById(R.id.etEmailLoginAdmin);
        etPasswordLoginAdmin=findViewById(R.id.etPasswordLoginAdmin);
        etCodeLoginAdmin=findViewById(R.id.etCodeLoginAdmin);
        btnLoginAdmin=findViewById(R.id.btnLoginAdmin);

        mauth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmailLoginAdmin.getText().toString().isEmpty()||
                        etPasswordLoginAdmin.getText().toString().isEmpty()||
                        etCodeLoginAdmin.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivityAdmin.this, "Enter All fields", Toast.LENGTH_SHORT).show();
                }
                else if(!etCodeLoginAdmin.getText().toString().equals("00000"))
                {
                    Toast.makeText(LoginActivityAdmin.this, "InCorrect Admin Code", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    loginAdmin();
                }
            }
        });
    }
    private void loginAdmin()
    {
        mauth.signInWithEmailAndPassword(etEmailLoginAdmin.getText().toString(),etPasswordLoginAdmin.getText().toString()).
                addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivityAdmin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivityAdmin.this,AdminPanel.class));
                        LoginActivityAdmin.this.finish();
                    }
                }).
                addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivityAdmin.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
