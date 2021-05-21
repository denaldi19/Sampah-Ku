package com.example.sampah_ku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    EditText nama, email, sandi, sandi2;
    Button login;
    TextView daftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        daftar = findViewById(R.id.daftar_login);

        daftar.setOnClickListener(v -> {
            Toast.makeText(Login.this, "Cek", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Register.class));
        });

    }
}
