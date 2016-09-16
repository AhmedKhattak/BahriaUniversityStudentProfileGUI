package com.example.ahmed.redux.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.redux.Models.Exam_Seating_Plan;
import com.example.ahmed.redux.Models.Note_Model;
import com.example.ahmed.redux.R;

import java.util.List;

/**
 * Created by Ahmed on 7/10/2016.
 */
public class ExamSeatingPlanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int ExamObject = 0;
    private final int NoteObject = 1;
    private List<Object> objectList;


    public ExamSeatingPlanAdapter(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ExamObject:
                View v1 = inflater.inflate(R.layout.examseatingplan, parent, false);
                viewHolder = new ExamHolder(v1);
                break;
            case NoteObject:
                View v2 = inflater.inflate(R.layout.note_header, parent, false);
                viewHolder = new NoteHolder(v2);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case ExamObject:
                ExamHolder examHolder=(ExamHolder)holder;
                Exam_Seating_Plan exam_seating_plan = (Exam_Seating_Plan) objectList.get(position);
                examHolder.date.setText(exam_seating_plan.getDate());
                examHolder.room.setText(exam_seating_plan.getRoom());
                examHolder.time_.setText(exam_seating_plan.getTime());
                examHolder.course_.setText(exam_seating_plan.getCourse());
                examHolder.col.setText(exam_seating_plan.getColumn());
                examHolder.row.setText(exam_seating_plan.getRow());
                break;
            case NoteObject:
                NoteHolder noteHolder=(NoteHolder)holder;
                noteHolder.note.setText(R.string.note_);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof Exam_Seating_Plan) {
            return ExamObject;
        } else if (objectList.get(position) instanceof Note_Model) {
            return NoteObject;
        }
        return -1; //should not return -1 under any circumstance aslong as exam and note objects exist
    }


    /*@Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.examseatingalternate, parent, false);
                break;

            case 1:
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.examseatingalternate, parent, false);
                break;

        }
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.examseatingalternate, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return NoteObject;
        } else {
            return ExamObject;
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Exam_Seating_Plan exam_seating_plan = examSeatingPlanList.get(position);
        holder.date.setText(exam_seating_plan.getDate());
        holder.room.setText(exam_seating_plan.getRoom());
        holder.time_.setText(exam_seating_plan.getTime());
        holder.course_.setText(exam_seating_plan.getCourse());
        holder.col.setText(exam_seating_plan.getColumn());
        holder.row.setText(exam_seating_plan.getRow());
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }*/

    public static class ExamHolder extends RecyclerView.ViewHolder {
        public TextView course_, date, time_, room, row, col;

        public ExamHolder(View itemView) {
            super(itemView);
            course_ = (TextView) itemView.findViewById(R.id.course);
            date = (TextView) itemView.findViewById(R.id.dateval);
            time_ = (TextView) itemView.findViewById(R.id.timeval);
            room = (TextView) itemView.findViewById(R.id.roomval);
            row = (TextView) itemView.findViewById(R.id.rowval);
            col = (TextView) itemView.findViewById(R.id.columnval);
        }
    }


    public static class NoteHolder extends RecyclerView.ViewHolder {

        public TextView note;

        public NoteHolder(View itemView) {
            super(itemView);
            note = (TextView) itemView.findViewById(R.id.note);
        }
    }
}
