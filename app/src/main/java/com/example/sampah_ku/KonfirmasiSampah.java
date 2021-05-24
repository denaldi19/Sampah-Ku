package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class KonfirmasiSampah extends Fragment {
    Button konfirmasi, kembali;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_konfirmasi_sampah, container, false);

        konfirmasi = v.findViewById(R.id.btnKonfirmasiTkrSampah);
        kembali = v.findViewById(R.id.btnKembali);

        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PesananDiterima pesananDiterima = new PesananDiterima();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, pesananDiterima).commit();
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TukarSampah tukarSampah = new TukarSampah();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, tukarSampah).commit();
            }
        });
        return v;

    }
}