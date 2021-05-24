package com.example.sampah_ku;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class TukarPoinSaldoGopay extends Fragment {

    Button btnKembali, btnTukar;
    private FirebaseUser pengguna;
    private DatabaseReference reference;

    private String userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tukar_poin_saldo_gopay, container, false);
        View v = inflater.inflate(R.layout.fragment_tukar_poin_saldo_gopay, container, false);

        btnKembali = v.findViewById(R.id.btn_gopay_btl);
        btnTukar = v.findViewById(R.id.btn_gopay_tkrPoin);
        pengguna = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = pengguna.getUid();

        btnTukar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        User userProfile = snapshot.getValue(User.class);

                        if (userProfile != null) {
                            String poinC = userProfile.poinPengguna;

                            Integer poinD = Integer.parseInt(poinC);

                            poinD = poinD - 10000;

                            String poinB = poinD.toString();

                            HashMap hashMap = new HashMap();
                            hashMap.put("poinPengguna", poinB);

                            reference.child(userID).updateChildren(hashMap);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        //Toast.makeText(UbahProfil.this, "Terdapat permasalahan!", Toast.LENGTH_LONG).show();
                    }
                });

                TukarPoinBerhasil tukarPoinBerhasil = new TukarPoinBerhasil();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, tukarPoinBerhasil).commit();

            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
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