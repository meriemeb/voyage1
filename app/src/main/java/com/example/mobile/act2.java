package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act2 extends AppCompatActivity {

    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        b2= findViewById(R.id.monument);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act2.this, monum2.class);
                startActivity(intent);

            }
        });
        b3= findViewById(R.id.food);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act2.this,food2.class);
                startActivity(intent);

            }
        });
        b4= findViewById(R.id.activities);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act2.this,activib.class);
                startActivity(intent);
            }
        });
        b5= findViewById(R.id.party);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act2.this,partyb.class);
                startActivity(intent);

            }
        });
        b0= findViewById(R.id.Raccb);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act2.this, acceuil.class);
                startActivity(intent);

            }
        });

    }
}
