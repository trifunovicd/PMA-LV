package com.example.myapplicationlv1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplicationlv1.R;
import com.example.myapplicationlv1.activities.CreateNewRecordActivity;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentInfoFragment extends Fragment {
    private TextInputEditText inputPredmet, inputProfesor, inputAkademskaGodina, inputSatiPredavanja, inputSatiLV;
    private Button button;
    private String predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV;
    private StudentInfoListener studentInfoListener;

    public interface StudentInfoListener {
        void onStudentInfoSent(String predmet, String ime_profesora, String akademska_godina, String sati_predavanja, String sati_LV);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.student_info,container,false);
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

        inputPredmet.addTextChangedListener(personalInfoWatcher);
        inputProfesor.addTextChangedListener(personalInfoWatcher);
        inputAkademskaGodina.addTextChangedListener(personalInfoWatcher);
        inputSatiPredavanja.addTextChangedListener(personalInfoWatcher);
        inputSatiLV.addTextChangedListener(personalInfoWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewRecordActivity.setCurrentItem (2, true);
            }
        });
    }

    private TextWatcher personalInfoWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            predmet = inputPredmet.getText().toString();
            imeProfesora = inputProfesor.getText().toString();
            akademskaGodina = inputAkademskaGodina.getText().toString();
            satiPredavanja = inputSatiPredavanja.getText().toString();
            satiLV = inputSatiLV.getText().toString();

            studentInfoListener.onStudentInfoSent(predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV);
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  StudentInfoListener) {
            studentInfoListener = (StudentInfoListener) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        studentInfoListener = null;
    }
}
