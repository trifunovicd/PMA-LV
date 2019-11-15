package com.example.myapplicationlv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class StudentInfoActivity extends AppCompatActivity {

    private TextInputEditText input;
    private Button button;
    private String predmet;
    private String sImePrezime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        final Bundle oExtras = getIntent().getExtras();
        sImePrezime = oExtras.getString("imePrezime");

        button=findViewById(R.id.buttonPredmet);
        input=findViewById(R.id.textPredmet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                predmet = input.getText().toString();


                Intent intent = new Intent(getApplicationContext(), SummaryActivity.class);
                intent.putExtra("predmet", predmet);
                intent.putExtra("imePrezime", sImePrezime);
                startActivity(intent);
            }
        });
    }
}
