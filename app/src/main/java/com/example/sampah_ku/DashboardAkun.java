package com.example.sampah_ku;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DashboardAkun extends Fragment {

    LinearLayout menuUbah, menuPanduan, menuKebijakan, menuKeluar;

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

        return v;
    }
}