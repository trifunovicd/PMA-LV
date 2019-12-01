package com.example.myapplicationlv1.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplicationlv1.R;
import com.example.myapplicationlv1.activities.CreateNewRecordActivity;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class PersonalInfoFragment extends Fragment {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;
    private TextInputEditText inputIme;
    private TextInputEditText inputPrezime;
    private EditText editDatum;
    private Button button;
    private String ime, prezime, datum;
    private PersonalInfoListener personalInfoListener;

    public interface PersonalInfoListener {
        void onPersonalInfoSent(String ime, String prezime, String datum);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.personal_info,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.image);
        button=view.findViewById(R.id.buttonImePrezime);
        inputIme=view.findViewById(R.id.textIme);
        inputPrezime=view.findViewById(R.id.textPrezime);
        editDatum=view.findViewById(R.id.editDatum);

        inputIme.addTextChangedListener(personalInfoWatcher);
        inputPrezime.addTextChangedListener(personalInfoWatcher);
        editDatum.addTextChangedListener(personalInfoWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewRecordActivity.setCurrentItem (1, true);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
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
            ime = inputIme.getText().toString();
            prezime = inputPrezime.getText().toString();
            datum = editDatum.getText().toString();

            personalInfoListener.onPersonalInfoSent(ime, prezime, datum);
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof  PersonalInfoListener) {
            personalInfoListener = (PersonalInfoListener) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        personalInfoListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
