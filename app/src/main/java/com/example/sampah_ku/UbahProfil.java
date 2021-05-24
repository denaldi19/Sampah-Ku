package com.example.sampah_ku;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UbahProfil extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseUser pengguna;
    private DatabaseReference reference;

    private String userID;
    EditText ubahNama, ubahEmail, ubahSandi, ubahSandi2;
    Button btnKembali, btnSimpan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ubah_profil, container, false);
        View v = inflater.inflate(R.layout.fragment_ubah_profil, container, false);

        btnKembali = v.findViewById(R.id.btn_ubah_batal);
        btnSimpan = v.findViewById(R.id.btn_ttp_ubah_profil);

        pengguna = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = pengguna.getUid();

        ubahNama = v.findViewById(R.id.ubah_nama);
        ubahEmail = v.findViewById(R.id.ubah_email);
        ubahSandi = v.findViewById(R.id.ubah_password);
        ubahSandi2 = v.findViewById(R.id.ubah_reTypePass);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String namaPengguna = userProfile.namaPengguna;
                    String emailPengguna = userProfile.emailPengguna;
                    String sandiPengguna = userProfile.sandiPengguna;
                    String sandiPengguna2 = userProfile.sandiPengguna;

                    ubahNama.setText(namaPengguna);
                    ubahEmail.setText(emailPengguna);
                    ubahSandi.setText(sandiPengguna);
                    ubahSandi2.setText(sandiPengguna2);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(UbahProfil.this, "Terdapat permasalahan!", Toast.LENGTH_LONG).show();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardAkun dashboardAkun = new DashboardAkun();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardAkun).commit();

            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)
                        getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ViewGroup popupView = (ViewGroup) inflater.inflate(R.layout.popup_ubah_profil, null);

                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.MATCH_PARENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                TextView txtYa = (TextView) popupView.findViewById(R.id.txt_ubah_profil_ya);
                TextView txtTidak = (TextView) popupView.findViewById(R.id.txt_ubah_profil_tdk);

                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

                txtTidak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        popupWindow.dismiss();

                    }
                });

                txtYa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DashboardAkun dashboardAkun = new DashboardAkun();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        popupWindow.dismiss();
                        transaction.replace(R.id.mainLayout, dashboardAkun).commit();


                    }
                });
            }
        });

        return v;
    }
}