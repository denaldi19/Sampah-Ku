package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class UbahProfil extends Fragment {

    Button btnKembali;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ubah_profil, container, false);
        View v = inflater.inflate(R.layout.fragment_ubah_profil, container, false);

        btnKembali = v.findViewById(R.id.btn_ubah_batal);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardAkun dashboardAkun = new DashboardAkun();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardAkun).commit();

            }
        });

        return v;
    }
}