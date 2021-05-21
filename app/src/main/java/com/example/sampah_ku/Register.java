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


    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");



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

        if(firebaseAuth.getCurrentUser() != null ){
            finish();
        }

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("User");

                reference.setValue("Coba coba saja");

                if (validasiEmail() | validasinamapengguna() | validasipassword() | validasipassword2()){
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("User");

//                    s_email = email.getText().toString().trim();
//                    s_nama = nama.getText().toString().trim();
//                    s_sandi = sandi.getText().toString().trim();

                    //UserHelperClass userHelperClass = new UserHelperClass(s_nama,s_email,s_sandi);

                    reference.setValue("Coba coba saja");

                    firebaseAuth.createUserWithEmailAndPassword(s_email,s_sandi).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Register.this, "Akun Berhasil Dibuat", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),Login.class));
                            }else {
                                Toast.makeText(Register.this, "Error ! " +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                //progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
    private boolean validasiEmail() {
        s_email = email.getText().toString().trim();
        if (s_email.isEmpty()) {
            email.setError("Masukkan email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(s_email).matches()) {
            email.setError("Masukkan email yang valid");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validasinamapengguna() {
        s_nama = nama.getText().toString().trim();
        if (s_nama.isEmpty()) {
            nama.setError("Masukkan nama");
            return false;
        } else {
            nama.setError(null);
            return true;
        }
    }

    private boolean validasipassword() {
        s_sandi = sandi.getText().toString().trim();
        if (s_sandi.isEmpty()) {
            sandi.setError("Masukkan password");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(s_sandi).matches()) {
            sandi.setError("Password terlalu lemah");
            return false;
        } else {
            sandi.setError(null);
            return true;
        }
    }
    private boolean validasipassword2() {
        s_sandi2 = sandi2.getText().toString().trim();
        if (s_sandi2.isEmpty()) {
            sandi2.setError("Masukkan konfirmasi password");
            return false;
        } else if (!s_sandi.equals(s_sandi2)) {
            sandi2.setError("Password terlalu lemah");
            return false;
        } else {
            sandi2.setError(null);
            return true;
        }
    }

}