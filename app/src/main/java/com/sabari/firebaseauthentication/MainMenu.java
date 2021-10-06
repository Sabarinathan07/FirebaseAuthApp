package com.sabari.firebaseauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {

    TextView textView;
    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        textView = findViewById(R.id.textView);
        signOut = findViewById(R.id.SignOut);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainMenu.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}