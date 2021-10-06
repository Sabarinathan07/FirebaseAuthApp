package com.sabari.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText etEmailReset;
    Button btReset;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmailReset = findViewById(R.id.etEmailReset);
        btReset = findViewById(R.id.btReset);


        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = etEmailReset.getText().toString();
                auth.sendPasswordResetEmail(userEmail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull  Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(ForgotPassword.this,"We sent an email to reset your Password",Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                finish();

            }
        });

    }
}