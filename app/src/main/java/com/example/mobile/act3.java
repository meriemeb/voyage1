package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act3 extends AppCompatActivity {

    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        but2= findViewById(R.id.monum3);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act3.this, monum3.class);
                startActivity(intent);

            }
        });
        but3= findViewById(R.id.food3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act3.this,food3.class);
                startActivity(intent);

            }
        });
        but4= findViewById(R.id.activity);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act3.this,activp.class);
                startActivity(intent);
            }
        });
        but5= findViewById(R.id.shop3);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act3.this,shop3.class);
                startActivity(intent);

            }
        });
        but0= findViewById(R.id.Raccp);
        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act3.this, acceuil.class);
                startActivity(intent);

            }
        });

    }
}
