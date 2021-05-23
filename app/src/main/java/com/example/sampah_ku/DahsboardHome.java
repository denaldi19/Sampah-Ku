package com.example.sampah_ku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DahsboardHome extends Fragment {

    Button btnTukarSampah;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dahsboard_home, container, false);
        View v = inflater.inflate(R.layout.fragment_dahsboard_home, container, false);

        btnTukarSampah = v.findViewById(R.id.button2);

        btnTukarSampah.setOnClickListener(new View.OnClickListener() {
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