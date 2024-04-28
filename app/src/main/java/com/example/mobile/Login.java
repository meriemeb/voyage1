package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button but9;
    private AutoCompleteTextView TextMail;
    private AutoCompleteTextView Textpswd;

    private DatabaseHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbhelper = new DatabaseHelper(this);

        TextMail=(AutoCompleteTextView) findViewById(R.id.email);
        Textpswd=(AutoCompleteTextView) findViewById(R.id.pswd);

        but9=findViewById(R.id.login);
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {loginUser();}


        });
    }
    private void loginUser() {
        String email = TextMail.getText().toString().trim();
        String password = Textpswd.getText().toString().trim();

        SQLiteDatabase db = dbhelper.getReadableDatabase();

        String selection = DatabaseHelper.COLUMN_EMAIL + "=? AND" + DatabaseHelper.COLUMN_PASSWORD;
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(
                DatabaseHelper.TABLE_USERS,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null

        );
        if (cursor != null && cursor.getCount()>0) {
            Toast.makeText(this, "logged in successfully!", Toast.LENGTH_SHORT).show();
            cursor.close();
            Intent intent=new Intent(Login.this, acceuil.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Failed to log in!", Toast.LENGTH_SHORT).show();
        }

    }

}