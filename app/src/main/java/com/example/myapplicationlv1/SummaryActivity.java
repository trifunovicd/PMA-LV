package com.example.myapplicationlv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private TextView sIme, sPrezime, sDatum, sPredmet, sImeProfesora, sAkademskaGodina, sSatiPredavanja, sSatiLV;
    private Button vrati_se;
    private String ime, prezime, datum, predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        ime = oExtras.getString("ime");
        prezime = oExtras.getString("prezime");
        datum = oExtras.getString("datum");
        predmet = oExtras.getString("predmet");
        imeProfesora = oExtras.getString("imeProfesora");
        akademskaGodina = oExtras.getString("akademskaGodina");
        satiPredavanja = oExtras.getString("satiPredavanja");
        satiLV = oExtras.getString("satiLV");


        sIme = findViewById(R.id.textViewIme);
        sPrezime = findViewById(R.id.textViewPrezime);
        sDatum = findViewById(R.id.textViewDatum);
        sPredmet = findViewById(R.id.textViewPredmet);
        sImeProfesora = findViewById(R.id.textViewImePrezimeProfesora);
        sAkademskaGodina = findViewById(R.id.textViewAkademskaGodina);
        sSatiPredavanja = findViewById(R.id.textViewSatiPredavanja);
        sSatiLV = findViewById(R.id.textViewSatiLV);
        vrati_se = findViewById(R.id.buttonHome);

        sIme.setText(ime);
        sPrezime.setText(prezime);
        sDatum.setText(datum);
        sPredmet.setText(predmet);
        sImeProfesora.setText(imeProfesora);
        sAkademskaGodina.setText(akademskaGodina);
        sSatiPredavanja.setText(satiPredavanja);
        sSatiLV.setText(satiLV);

        vrati_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDataStorage myDataStorage = MyDataStorage.getInstance();
                Student student = new Student(ime,prezime,predmet);
                myDataStorage.setStudents(student);
                Intent intent = new Intent(getApplicationContext(), PocetniActivity.class);
               // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
