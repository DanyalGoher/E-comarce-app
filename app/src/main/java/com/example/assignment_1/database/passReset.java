package com.example.assignment_1.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.assignment_1.R;
import com.example.assignment_1.databinding.ActivityPassResetBinding;
import com.example.assignment_1.databinding.ActivitySignupBinding;

public class passReset extends AppCompatActivity {
    ActivityPassResetBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPassResetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String email = binding.email.getText().toString();
        String password = binding.newPassword.getText().toString();
        if (email.equals("") || password.equals("")) {
            Toast.makeText(passReset.this, "please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean updatePassword = databaseHelper.updatePassword(email, password);
        }
    }
}