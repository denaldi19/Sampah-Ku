package com.example.sampah_ku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {
    LinearLayout navBeranda, navTransaksi, navSampah, navAkun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        navBeranda = findViewById(R.id.navBeranda);
        navTransaksi = findViewById(R.id.navTransaksi);
        navSampah = findViewById(R.id.navSampah);
        navAkun = findViewById(R.id.navAkun);

        navBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager =  getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Container, new DahsboardHome());
                fragmentTransaction.commit();
            }
        });

        navTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager =  getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Container, new DashboardTransaksi());
                fragmentTransaction.commit();
            }
        });

        navSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager =  getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Container, new DashboardSampah());
                fragmentTransaction.commit();
            }
        });

        navAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager =  getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Container, new DashboardAkun());
                fragmentTransaction.commit();
            }
        });
    }
}