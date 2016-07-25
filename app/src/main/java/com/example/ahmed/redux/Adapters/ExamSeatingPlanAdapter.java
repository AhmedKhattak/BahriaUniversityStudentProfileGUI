package com.example.ahmed.redux.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.redux.Models.Exam_Seating_Plan;
import com.example.ahmed.redux.R;

import java.util.List;

/**
 * Created by Ahmed on 7/10/2016.
 */
public class ExamSeatingPlanAdapter extends RecyclerView.Adapter<ExamSeatingPlanAdapter.ViewHolder> {


    private List<Exam_Seating_Plan> examSeatingPlanList;


    public ExamSeatingPlanAdapter(List<Exam_Seating_Plan> examSeatingPlanList)
    {
        this.examSeatingPlanList=examSeatingPlanList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.examseatingalternate, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Exam_Seating_Plan exam_seating_plan=examSeatingPlanList.get(position);
        holder.date.setText(exam_seating_plan.getDate());
        holder.room.setText(exam_seating_plan.getRoom());
        holder.time_.setText(exam_seating_plan.getTime());
        holder.course_.setText(exam_seating_plan.getCourse());
        holder.col.setText(exam_seating_plan.getColumn());
        holder.row.setText(exam_seating_plan.getRow());
    }

    @Override
    public int getItemCount() {
        return examSeatingPlanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView course_,date,time_,room,row,col;
        public ViewHolder(View itemView) {
            super(itemView);
            course_=(TextView) itemView.findViewById(R.id.courseval);
            date=(TextView) itemView.findViewById(R.id.dateval);
            time_=(TextView) itemView.findViewById(R.id.timeval);
            room=(TextView) itemView.findViewById(R.id.roomval);
            row=(TextView) itemView.findViewById(R.id.rowval);
            col=(TextView) itemView.findViewById(R.id.columnval);
        }
    }

   
}
