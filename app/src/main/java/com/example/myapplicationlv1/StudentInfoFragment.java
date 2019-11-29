package com.example.myapplicationlv1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentInfoFragment extends Fragment {


    private TextInputEditText inputPredmet, inputProfesor, inputAkademskaGodina, inputSatiPredavanja, inputSatiLV;
    private Button button;
    private String predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV;
    private String sIme, sPrezime, sDatum;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_student_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button=view.findViewById(R.id.buttonPredmet);
        inputPredmet=view.findViewById(R.id.textPredmet);
        inputProfesor=view.findViewById(R.id.textImeProfesora);
        inputAkademskaGodina=view.findViewById(R.id.textAkademskaGodina);
        inputSatiPredavanja=view.findViewById(R.id.textSatiPredavanja);
        inputSatiLV=view.findViewById(R.id.textSatiLV);
    }
}
