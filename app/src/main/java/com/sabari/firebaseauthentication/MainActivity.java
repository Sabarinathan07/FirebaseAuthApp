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

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button signIn,signUp;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signIn = findViewById(R.id.btSignIn);
        signUp = findViewById(R.id.btSignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                signInFirebase(sEmail,sPassword);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });



    }

    public void signInFirebase(String sEmail,String sPassword){

        auth.signInWithEmailAndPassword(sEmail,sPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(MainActivity.this,MainMenu.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),"User or Password is incorrect",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}