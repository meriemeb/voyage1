package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act1 extends AppCompatActivity {

    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        but4 = findViewById(R.id.monument);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act1.this, monum1.class);
                startActivity(intent);

            }
        });
        but5= findViewById(R.id.food);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act1.this,food1.class);
                startActivity(intent);

            }
        });
        but6= findViewById(R.id.cruises);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act1.this,cru1.class);
                startActivity(intent);
            }
        });
        but7= findViewById(R.id.food);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act1.this,food1.class);
                startActivity(intent);

            }
        });

    }
}
