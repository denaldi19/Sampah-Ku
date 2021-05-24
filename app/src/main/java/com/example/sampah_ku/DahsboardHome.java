package com.example.sampah_ku;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DahsboardHome extends Fragment {

    private FirebaseUser pengguna;
    private DatabaseReference reference;
    private String userID;
    TextView txtNamaPengguna, txtPoinPengguna;
    Button btnTukarSampah;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_dahsboard_home, container, false);
        View v = inflater.inflate(R.layout.fragment_dahsboard_home, container, false);

        btnTukarSampah = v.findViewById(R.id.button2);

        pengguna = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = pengguna.getUid();

        txtNamaPengguna = v.findViewById(R.id.textView3);
        txtPoinPengguna = v.findViewById(R.id.textView11);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String namaPengguna = userProfile.namaPengguna;
                    String poinPengguna = userProfile.poinPengguna;

                    txtNamaPengguna.setText("Hai, " + namaPengguna + "!");
                    txtPoinPengguna.setText(poinPengguna);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Toast.makeText(UbahProfil.this, "Terdapat permasalahan!", Toast.LENGTH_LONG).show();
            }
        });

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