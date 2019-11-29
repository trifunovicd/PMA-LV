package com.example.myapplicationlv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PersonalInfoFragment extends Fragment {

    private TextInputEditText inputIme;
    private TextInputEditText inputPrezime;
    private EditText editDatum;
    private Button button;
    private String ime, prezime, datum;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button=view.findViewById(R.id.buttonImePrezime);
        inputIme=view.findViewById(R.id.textIme);
        inputPrezime=view.findViewById(R.id.textPrezime);
        editDatum=view.findViewById(R.id.editDatum);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ime = inputIme.getText().toString();
                prezime = inputPrezime.getText().toString();
                datum = editDatum.getText().toString();

                Intent intent = new Intent(getActivity(), StudentInfoActivity.class);
                intent.putExtra("ime", ime);
                intent.putExtra("prezime", prezime);
                intent.putExtra("datum", datum);
                startActivity(intent);
            }
        });

    }
}
