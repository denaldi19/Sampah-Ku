package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class Panduan extends Fragment {

    Button btnKembali;
    LinearLayout menuRegis, menuTukar, menuBeli, menuPoin, menuGabung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_panduan, container, false);
        View v = inflater.inflate(R.layout.fragment_panduan, container, false);

        btnKembali = v.findViewById(R.id.btn_panduan_kmbli);
        menuRegis = v.findViewById(R.id.menuRegis);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardAkun dashboardAkun = new DashboardAkun();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardAkun).commit();

            }
        });

        menuRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_panduan_registrasi, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

                // define your view here that found in popup_layout
                // for example let consider you have a button

                //Button btn = (Button) popupView.findViewById(R.id.button);

                // finally show up your popwindow
                popupWindow.showAsDropDown(popupView, 0, 0);

            }
        });

        return v;
    }
}