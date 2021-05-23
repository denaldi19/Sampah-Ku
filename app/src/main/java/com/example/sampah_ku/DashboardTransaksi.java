package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DashboardTransaksi extends Fragment {

    LinearLayout list1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dashboard_transaksi, container, false);
        View v = inflater.inflate(R.layout.fragment_dashboard_transaksi, container, false);

        list1 = v.findViewById(R.id.transaksi_list1);

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransaksiDetail transaksiDetail = new TransaksiDetail();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, transaksiDetail).commit();

            }
        });

        return v;
    }
}