package com.example.myapplicationlv1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationlv1.models.MyDataStorage;
import com.example.myapplicationlv1.R;
import com.example.myapplicationlv1.models.Student;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private MyDataStorage storage = MyDataStorage.getInstance();
    private List<Student> studenti = storage.getStudents();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEAD){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            HeaderHolder headerHolder = new HeaderHolder(view);
            return headerHolder;
        }
        else if(viewType == TYPE_LIST){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studenti_layout, parent, false);
            StudentHolder studentHolder = new StudentHolder(view);
            return studentHolder;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_HEAD){
            ((HeaderHolder) holder).header.setText(R.string.studenti);

        }
        else {
            ((StudentHolder) holder).studentImePrezime.setText(studenti.get(position-1).getIme() + " " + studenti.get(position-1).getPrezime());
            ((StudentHolder) holder).predmet.setText(studenti.get(position-1).getPredmet());
        }
    }


    @Override
    public int getItemCount() {
        return studenti.size() + 1;
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


    public class HeaderHolder extends RecyclerView.ViewHolder{

        TextView header;

        public HeaderHolder(@NonNull View itemView) {
            super(itemView);

                header = itemView.findViewById(R.id.header);

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
