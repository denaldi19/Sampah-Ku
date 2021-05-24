package com.example.sampah_ku;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardAkun extends Fragment {

    LinearLayout menuUbah, menuPanduan, menuKebijakan, menuKeluar;
    private FirebaseAuth mAuth;
    private FirebaseUser pengguna;
    private DatabaseReference reference;
    private String userID;
    TextView txtNamaPengguna, txtPoinPengguna;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dashboard_akun, container, false);
        View v = inflater.inflate(R.layout.fragment_dashboard_akun, container, false);

        menuUbah = v.findViewById(R.id.menuUbah);
        menuPanduan = v.findViewById(R.id.menuPanduan);
        menuKebijakan = v.findViewById(R.id.menuKebijakan);
        menuKeluar = v.findViewById(R.id.menuKeluar);

        menuUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UbahProfil ubahProfil = new UbahProfil();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, ubahProfil).commit();

            }
        });

        pengguna = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = pengguna.getUid();

        txtNamaPengguna = v.findViewById(R.id.namaPengguna1);
        txtPoinPengguna = v.findViewById(R.id.jmlhPoin);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String namaPengguna = userProfile.namaPengguna;
                    String poinPengguna = userProfile.poinPengguna;

                    txtNamaPengguna.setText(namaPengguna);
                    txtPoinPengguna.setText(poinPengguna);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(UbahProfil.this, "Terdapat permasalahan!", Toast.LENGTH_LONG).show();
            }
        });

        menuPanduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Panduan panduan = new Panduan();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, panduan).commit();

            }
        });

        menuKebijakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KebijakanPrivasi kebijakanPrivasi = new KebijakanPrivasi();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, kebijakanPrivasi).commit();

            }
        });

        menuKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)
                        getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ViewGroup popupView = (ViewGroup) inflater.inflate(R.layout.popup_keluar_akun, null);

                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.MATCH_PARENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                TextView txtYa = (TextView) popupView.findViewById(R.id.txt_keluar_akun_ya);
                TextView txtTidak = (TextView) popupView.findViewById(R.id.txt_keluar_akun_tdk);

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

                        mAuth.signOut();

                    }
                });

            }
        });
        return v;
    }
}