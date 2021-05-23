package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TransaksiDetail extends Fragment {

    Button btn_ttp_transaksi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_transaksi_detail, container, false);
        View v = inflater.inflate(R.layout.fragment_transaksi_detail, container, false);

        btn_ttp_transaksi = v.findViewById(R.id.btn_ttp_transaksi);

        btn_ttp_transaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardTransaksi dashboardTransaksi = new DashboardTransaksi();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardTransaksi).commit();

            }
        });

        return v;
    }
}