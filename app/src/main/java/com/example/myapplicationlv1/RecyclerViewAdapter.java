package com.example.myapplicationlv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StudentHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private MyDataStorage storage = MyDataStorage.getInstance();
    private List<Student> studenti = storage.getStudents();

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEAD){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            StudentHolder holder = new StudentHolder(view, viewType);
            return holder;
        }
        else if(viewType == TYPE_LIST){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studenti_layout, parent, false);
            StudentHolder holder = new StudentHolder(view, viewType);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {

        if(holder.view_type == TYPE_LIST){
            holder.studentImePrezime.setText(studenti.get(position-1).getIme() + " " + studenti.get(position-1).getPrezime());
            holder.predmet.setText(studenti.get(position-1).getPredmet());
        }
        else if(holder.view_type == TYPE_HEAD){
            holder.header.setText(R.string.studenti);
        }

    }

    @Override
    public int getItemCount() {
        return studenti.size() + 1;
    }

    public class StudentHolder extends RecyclerView.ViewHolder{
        int view_type;

        TextView studentImePrezime;
        TextView predmet;
        TextView header;

        public StudentHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if(viewType == TYPE_LIST){
                studentImePrezime = itemView.findViewById(R.id.studenti_ime_prezime);
                predmet = itemView.findViewById(R.id.predmet);
                view_type = 1;
            }
            else if(viewType == TYPE_HEAD){
                header = itemView.findViewById(R.id.header);
                view_type = 0;
            }

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEAD;
        }
        else{
            return TYPE_LIST;
        }
    }
}
