package com.example.sampah_ku;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    EditText nama, email, sandi, sandi2;
    Button register;
    TextView masuk;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ProgressBar progressBar;
    private String s_nama, s_email, s_sandi, s_sandi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nama = findViewById(R.id.nama_register);
        email = findViewById(R.id.email_register);
        sandi = findViewById(R.id.sandi_register);
        sandi2 = findViewById(R.id.sandi2_register);
        register = findViewById(R.id.daftar_register);
        masuk = findViewById(R.id.masuk);

        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();

            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });


    }

    private void registerUser() {
        String uNama = nama.getText().toString().trim();
        String uEmail = email.getText().toString().trim();
        String uSandi = sandi.getText().toString().trim();
        String uSandi2 = sandi2.getText().toString().trim();
        String uPoin = "50000";

        if (uNama.isEmpty()) {
            nama.setError("Isi nama lengkap Anda!");
            nama.requestFocus();
            return;
        }

        if (uEmail.isEmpty()) {
            email.setError("Isi alamat email Anda!");
            email.requestFocus();
            return;
        }

        if (uSandi.isEmpty()) {
            sandi.setError("Isi kata sandi Anda!");
            sandi.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(uEmail).matches()) {
            email.setError("Masukkan email Anda dengan benar!");
            email.requestFocus();
            return;
        }

        if (uSandi.length() < 6) {
            sandi.setError("Masukkan kata sandi Anda minimal 6 karakter!");
            sandi.requestFocus();
            return;
        }

        if (!uSandi.equals(uSandi2)) {
            sandi2.setError("Masukkan kata sandi yang sama!");
            sandi2.requestFocus();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(uEmail, uSandi)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            User user = new User(uNama, uEmail, uSandi, uPoin);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "Akun berhasil dibuat!", Toast.LENGTH_LONG).show();
                                        nama.setText("");
                                        email.setText("");
                                        sandi.setText("");
                                        sandi2.setText("");
                                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(Register.this, "Akun tidak berhasil dibuat!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}