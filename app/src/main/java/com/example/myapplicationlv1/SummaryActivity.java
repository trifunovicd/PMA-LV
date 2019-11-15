package com.example.myapplicationlv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private TextView sImePrezime;
    private TextView sPredmet;
    private Button vrati_se;
    private String imePrezime;
    private String predmet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        imePrezime = oExtras.getString("imePrezime");
        predmet = oExtras.getString("predmet");

        sImePrezime = findViewById(R.id.textViewImePrezime);
        sPredmet = findViewById(R.id.textViewPredmet);
        vrati_se = findViewById(R.id.buttonHome);

        sImePrezime.setText(imePrezime);
        sPredmet.setText(predmet);

        vrati_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
