package com.example.myapplicationlv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    private TextInputEditText inputPredmet, inputProfesor, inputAkademskaGodina, inputSatiPredavanja, inputSatiLV;
    private Button button;
    private String predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV;
    private String sIme, sPrezime, sDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatum = oExtras.getString("datum");

        button=findViewById(R.id.buttonPredmet);
        inputPredmet=findViewById(R.id.textPredmet);
        inputProfesor=findViewById(R.id.textImeProfesora);
        inputAkademskaGodina=findViewById(R.id.textAkademskaGodina);
        inputSatiPredavanja=findViewById(R.id.textSatiPredavanja);
        inputSatiLV=findViewById(R.id.textSatiLV);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                predmet = inputPredmet.getText().toString();
                imeProfesora = inputProfesor.getText().toString();
                akademskaGodina = inputAkademskaGodina.getText().toString();
                satiPredavanja = inputSatiPredavanja.getText().toString();
                satiLV = inputSatiLV.getText().toString();


                Intent intent = new Intent(getApplicationContext(), SummaryActivity.class);
                intent.putExtra("predmet", predmet);
                intent.putExtra("imeProfesora", imeProfesora);
                intent.putExtra("akademskaGodina", akademskaGodina);
                intent.putExtra("satiPredavanja", satiPredavanja);
                intent.putExtra("satiLV", satiLV);
                intent.putExtra("ime", sIme);
                intent.putExtra("prezime", sPrezime);
                intent.putExtra("datum", sDatum);
                startActivity(intent);
            }
        });
    }
}
