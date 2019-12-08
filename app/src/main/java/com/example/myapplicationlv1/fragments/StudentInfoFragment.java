package com.example.myapplicationlv1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myapplicationlv1.R;
import com.example.myapplicationlv1.activities.CreateNewRecordActivity;
import com.example.myapplicationlv1.models.ApiManager;
import com.example.myapplicationlv1.models.Course;
import com.example.myapplicationlv1.models.CourseResponse;
import com.example.myapplicationlv1.models.Instructor;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment  implements Callback<CourseResponse>, AdapterView.OnItemSelectedListener{
    private static final String TAG = "MyActivity";
    private TextInputEditText inputAkademskaGodina, inputSatiPredavanja, inputSatiLV;
    private Button button;
    private String predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV;
    private StudentInfoListener studentInfoListener;
    private CourseResponse courseResponse = new CourseResponse();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<String> predmeti = new ArrayList<>();
    private ArrayList<Instructor> instruktori = new ArrayList<>();
    private ArrayList<String> nazivi_instruktora = new ArrayList<>();
    private Spinner spinnerPredmet, spinnerProfesor;

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
        if (response.isSuccessful() && response.body() != null){
            courseResponse = response.body();
            courses = courseResponse.getCourses();

            for(Course course : courses){
                if(course.getTitle() != null && !course.getTitle().matches("")){
                    predmeti.add(course.getTitle());
                }
            }

            ArrayAdapter<String> adapterPredmet = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, predmeti);
            spinnerPredmet.setAdapter(adapterPredmet);
            spinnerPredmet.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.spinnerPredmet)
        {
            Log.d(TAG, "onItemSelected: " + spinnerPredmet.getSelectedItem());

            for(Course course : courses){
                if(spinnerPredmet.getSelectedItem() == course.getTitle()){
                    instruktori = course.getInstructors();

                    if(instruktori != null){
                        nazivi_instruktora.clear();

                        for(Instructor instructor : instruktori){
                            nazivi_instruktora.add(instructor.getName());

                            Log.d(TAG, "onResponse: " + instructor.getName());
                        }
                    }
                }
            }

            ArrayAdapter<String> adapterProfesor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, nazivi_instruktora);
            spinnerProfesor.setAdapter(adapterProfesor);
            spinnerProfesor.setOnItemSelectedListener(this);

            predmet = spinnerPredmet.getSelectedItem().toString();
            studentInfoListener.onStudentInfoSent(predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV);
        }
        else if(adapterView.getId() == R.id.spinnerProfesor)
        {
            imeProfesora = spinnerProfesor.getSelectedItem().toString();
            studentInfoListener.onStudentInfoSent(predmet, imeProfesora, akademskaGodina, satiPredavanja, satiLV);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

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

        spinnerPredmet = view.findViewById(R.id.spinnerPredmet);
        spinnerProfesor = view.findViewById(R.id.spinnerProfesor);
        inputAkademskaGodina=view.findViewById(R.id.textAkademskaGodina);
        inputSatiPredavanja=view.findViewById(R.id.textSatiPredavanja);
        inputSatiLV=view.findViewById(R.id.textSatiLV);


        inputAkademskaGodina.addTextChangedListener(personalInfoWatcher);
        inputSatiPredavanja.addTextChangedListener(personalInfoWatcher);
        inputSatiLV.addTextChangedListener(personalInfoWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewRecordActivity.setCurrentItem (2, true);
            }
        });

        ApiManager.getInstance().service().getCourses().enqueue(this);

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
