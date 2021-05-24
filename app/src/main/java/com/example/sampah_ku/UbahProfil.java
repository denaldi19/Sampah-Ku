package com.example.sampah_ku;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class UbahProfil extends Fragment {

    Button btnKembali, btnSimpan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ubah_profil, container, false);
        View v = inflater.inflate(R.layout.fragment_ubah_profil, container, false);

        btnKembali = v.findViewById(R.id.btn_ubah_batal);
        btnSimpan = v.findViewById(R.id.btn_ttp_ubah_profil);

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