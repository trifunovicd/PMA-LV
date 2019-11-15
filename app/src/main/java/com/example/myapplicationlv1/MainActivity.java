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

    private TextInputEditText input;
    private Button button;
    private String ime_prezime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonImePrezime);
        input=findViewById(R.id.textImePrezime);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ime_prezime = input.getText().toString();

                Intent intent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                intent.putExtra("imePrezime", ime_prezime);
                startActivity(intent);
            }
        });
    }
}
