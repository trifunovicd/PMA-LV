package com.example.myapplicationlv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SummaryFragment extends Fragment {

    private TextView sIme, sPrezime, sDatum, sPredmet, sImeProfesora, sAkademskaGodina, sSatiPredavanja, sSatiLV;
    private Button vrati_se;
    private String ime, prezime, datum, predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_summary,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sIme = view.findViewById(R.id.textViewIme);
        sPrezime = view.findViewById(R.id.textViewPrezime);
        sDatum = view.findViewById(R.id.textViewDatum);
        sPredmet = view.findViewById(R.id.textViewPredmet);
        sImeProfesora = view.findViewById(R.id.textViewImePrezimeProfesora);
        sAkademskaGodina = view.findViewById(R.id.textViewAkademskaGodina);
        sSatiPredavanja = view.findViewById(R.id.textViewSatiPredavanja);
        sSatiLV = view.findViewById(R.id.textViewSatiLV);
        vrati_se = view.findViewById(R.id.buttonHome);
    }
}
