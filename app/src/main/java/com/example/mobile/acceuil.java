package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class acceuil extends AppCompatActivity {
    private Button b8;
    private Button b9;
    private Button b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        b8= findViewById(R.id.italy);
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(acceuil.this, italy.class);
                startActivity(intent);
            }
        });
        b9= findViewById(R.id.bali);
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(acceuil.this, bali1.class);
                startActivity(intent);
            }
        });
        b10= findViewById(R.id.petra);
        b10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(acceuil.this, petra.class);
                startActivity(intent);
            }
        });
    }
}