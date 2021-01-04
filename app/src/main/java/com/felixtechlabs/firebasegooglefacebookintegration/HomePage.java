package com.felixtechlabs.firebasegooglefacebookintegration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    ImageView imageView;
    Button btn;
    TextView textView;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        imageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        firebaseAuth  = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();


        if(user != null){
            user.getPhotoUrl();
            Glide.with(this).load(user.getPhotoUrl()).into(imageView);
            textView.setText(user.getEmail());
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            firebaseAuth.signOut();
            startActivity(new Intent(HomePage.this,MainActivity.class));
            finish();
            }
        });


    }
}
