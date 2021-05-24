package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BeliProduk extends Fragment {

    Button beliKembali, beliProduk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_beli_produk, container, false);
        View v = inflater.inflate(R.layout.fragment_beli_produk, container, false);

        beliKembali = v.findViewById(R.id.btn_beli_kmbl);
        beliProduk = v.findViewById(R.id.btn_beli_psn_skrgn);

        beliKembali.setOnClickListener(new View.OnClickListener() {
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