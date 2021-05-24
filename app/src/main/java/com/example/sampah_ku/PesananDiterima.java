package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PesananDiterima extends Fragment {
    Button daftarTransaksi, kembali;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pesanan_diterima, container, false);

        daftarTransaksi = v.findViewById(R.id.btnDaftarTransaksi);
        kembali = v.findViewById(R.id.btnKembali2);

        daftarTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardTransaksi dashboardTransaksi = new DashboardTransaksi();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardTransaksi).commit();
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DahsboardHome dahsboardHome = new DahsboardHome();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dahsboardHome).commit();
            }
        });

        return v;
    }
}