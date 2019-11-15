package com.example.myapplicationlv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputIme;
    private TextInputEditText inputPrezime;
    private EditText editDatum;
    private Button button;
    private String ime, prezime, datum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonImePrezime);
        inputIme=findViewById(R.id.textIme);
        inputPrezime=findViewById(R.id.textPrezime);
        editDatum=findViewById(R.id.editDatum);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ime = inputIme.getText().toString();
                prezime = inputPrezime.getText().toString();
                datum = editDatum.getText().toString();

                Intent intent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                intent.putExtra("ime", ime);
                intent.putExtra("prezime", prezime);
                intent.putExtra("datum", datum);
                startActivity(intent);
            }
        });
    }
}
