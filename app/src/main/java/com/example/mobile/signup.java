package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class signup extends AppCompatActivity {

    private TextInputLayout firstNameLayout, lastNameLayout, emailLayout, passwordLayout, phoneNumberLayout;
    private Button signUpButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signUpButton=findViewById(R.id.sign);

        // Initialize views
        firstNameLayout = findViewById(R.id.name);
        lastNameLayout = findViewById(R.id.lastname);
        emailLayout = findViewById(R.id.mail);
        passwordLayout = findViewById(R.id.password);
        phoneNumberLayout = findViewById(R.id.phone);
        signUpButton = findViewById(R.id.sign);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Set click listener for signUpButton
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String firstName = firstNameLayout.getEditText().getText().toString();
                String lastName = lastNameLayout.getEditText().getText().toString();
                String email = emailLayout.getEditText().getText().toString();
                String password = passwordLayout.getEditText().getText().toString();
                String phoneNumber = phoneNumberLayout.getEditText().getText().toString();

                // Validate user input (optional)

                // Save user data to database
                long result = dbHelper.addUser(firstName, lastName, email, password, phoneNumber);
                if (result != -1) {
                    // User data saved successfully
                    Toast.makeText(signup.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // Failed to save user data
                    Toast.makeText(signup.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
