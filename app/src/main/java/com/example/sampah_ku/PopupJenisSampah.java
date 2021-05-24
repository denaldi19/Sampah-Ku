package com.example.sampah_ku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PopupJenisSampah extends AppCompatActivity {
    LinearLayout gelasMineral, botolMineral, galon, jerigen, tutupBotol, kresek, plastikPutih, plastikSablon,
    emberWarna, emberPutih, emberHitam;
    ImageView exitdaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_jenis_sampah);

        gelasMineral = findViewById(R.id.glsMineral);
        botolMineral = findViewById(R.id.btlMineral);
        galon = findViewById(R.id.galon);
        jerigen = findViewById(R.id.jerigen);
        tutupBotol = findViewById(R.id.tutupBotol);
        kresek = findViewById(R.id.kresek);
        plastikPutih = findViewById(R.id.plastikPutih);
        plastikSablon = findViewById(R.id.plastikSablon);
        emberWarna = findViewById(R.id.emberWarna);
        emberPutih = findViewById(R.id.emberPutih);
        emberHitam = findViewById(R.id.emberHitam);
        exitdaftar = findViewById(R.id.exitDaftar);

        exitdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        gelasMineral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String text = "Gelas Mineral";
//                openactivity(text);
//                finish();
            }
        });
        botolMineral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        galon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        jerigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tutupBotol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        kresek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        plastikPutih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        plastikSablon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        emberWarna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        emberPutih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        emberHitam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void openactivity(String txt){
        Bundle bundle = new Bundle();
        bundle.putString("jenisampah", txt);
        TukarSampah tukarSampah = new TukarSampah();
        tukarSampah.setArguments(bundle);
    }
}