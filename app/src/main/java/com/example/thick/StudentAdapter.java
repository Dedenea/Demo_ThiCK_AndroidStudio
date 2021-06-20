package com.example.thick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.UserViewHolder>{
    private List<Student> list;
    private Context context;

    public StudentAdapter(List<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Student student = list.get(position);
        if(student==null){
            return;
        }
        holder.edtName.setText(list.get(position).getName());
        holder.edtAge.setText(list.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView edtName,edtAge;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            edtName=itemView.findViewById(R.id.txtTen);
            edtAge=itemView.findViewById(R.id.txtTuoi);

        }
    }
}
