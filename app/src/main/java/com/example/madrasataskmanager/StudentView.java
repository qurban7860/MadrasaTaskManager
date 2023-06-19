package com.example.madrasataskmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentView extends RecyclerView.Adapter<StudentView.StudentViewHolder> {

    private List<Student> filteredStudentList;
    private MainActivity mainActivity;

    public StudentView(List<Student> filteredStudentList, MainActivity mainActivity) {
        this.filteredStudentList = filteredStudentList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // Bind data to the ViewHolder
        Student student = filteredStudentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return filteredStudentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Student student) {
            // Bind student data to the views in the item layout
            // Example:
            // TextView nameTextView = itemView.findViewById(R.id.nameTextView);
            // nameTextView.setText(student.getName());
        }
    }
}
