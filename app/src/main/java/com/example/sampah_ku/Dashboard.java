package com.example.sampah_ku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {

    LinearLayout navTransac, navHome, navSampah, navAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        navTransac = (LinearLayout) findViewById(R.id.navTransac);
        navHome = (LinearLayout) findViewById(R.id.navHome);
        navSampah = (LinearLayout) findViewById(R.id.navSampah);
        navAkun = (LinearLayout) findViewById(R.id.navAkun);

        DahsboardHome dashboardhome = new DahsboardHome();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().add(R.id.mainLayout, dashboardhome).commit();

        navTransac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardTransaksi dashboardTransaksi = new DashboardTransaksi();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardTransaksi).commit();

            }
        });

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DahsboardHome dahsboardHome = new DahsboardHome();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dahsboardHome).commit();

            }
        });

        navSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardSampah dashboardSampah = new DashboardSampah();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardSampah).commit();

            }
        });

        navAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DashboardAkun dashboardAkun = new DashboardAkun();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, dashboardAkun).commit();

            }
        });
    }
}