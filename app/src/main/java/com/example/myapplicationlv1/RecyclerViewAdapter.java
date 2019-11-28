package com.example.myapplicationlv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StudentHolder> {
   private MyDataStorage storage = MyDataStorage.getInstance();
   private List<Student> studenti = storage.getStudents();

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studenti_layout, parent, false);
        StudentHolder holder = new StudentHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.studentImePrezime.setText(studenti.get(position).getIme() + " " + studenti.get(position).getPrezime());
        holder.predmet.setText(studenti.get(position).getPredmet());
    }

    @Override
    public int getItemCount() {
        return studenti.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder{

        TextView studentImePrezime;
        TextView predmet;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            studentImePrezime = itemView.findViewById(R.id.studenti_ime_prezime);
            predmet = itemView.findViewById(R.id.predmet);
        }
    }
}
