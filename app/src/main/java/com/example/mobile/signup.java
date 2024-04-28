package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class signup extends AppCompatActivity {

    private AutoCompleteTextView Textname;
    private AutoCompleteTextView Textlast;
    private AutoCompleteTextView Textphone;
    private AutoCompleteTextView Textmail;
    private AutoCompleteTextView Textpassword;
    private Button buttontnsignup;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dbHelper = new DatabaseHelper(this);

        Textname=findViewById(R.id.name1);
        Textlast=findViewById(R.id.last1);
        Textphone=findViewById(R.id.ph1);
        Textmail=findViewById(R.id.mail1);
        Textpassword=findViewById(R.id.pswd1);
        buttontnsignup=findViewById(R.id.sign);

        buttontnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){registerUser();}

        });
    }
    private void registerUser(){
        String name = Textname.getText().toString().trim();
        String last = Textlast.getText().toString().trim();
        String phone = Textphone.getText().toString().trim();
        String email = Textmail.getText().toString().trim();
        String password = Textpassword.getText().toString().trim();

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(DatabaseHelper.COLUMN_FIRST_NAME, name);
        values.put(DatabaseHelper.COLUMN_LAST_NAME, last);
        values.put(DatabaseHelper.COLUMN_PHONE_NUMBER, phone);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);

        long newRowId=db.insert(DatabaseHelper.TABLE_USERS, null, values);

        if(newRowId != -1){
            Toast.makeText(this,"User Registered Successefully!",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(signup.this, acceuil.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Failed to Register!",Toast.LENGTH_SHORT).show();
        }
    }
}
