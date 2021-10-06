package com.sabari.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText email,password;
    Button signUp;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.etEmailAddress);
        password = findViewById(R.id.etSignPassword);
        signUp = findViewById(R.id.btSignSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUserEmail = email.getText().toString();
                String sUserPassword = password.getText().toString();
                signUpFirebase(sUserEmail,sUserPassword);

            }
        });
    }

    public void signUpFirebase(String sUserEmail,String sUserPassword){

        auth.createUserWithEmailAndPassword(sUserEmail,sUserPassword).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Your Account is Created", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(i);
                            finish();

                        }else{
                            Toast.makeText(SignUpActivity.this, "Your Account is Created", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



}