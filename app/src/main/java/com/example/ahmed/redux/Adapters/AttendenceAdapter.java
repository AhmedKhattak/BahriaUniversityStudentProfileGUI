package com.example.ahmed.redux.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmed.redux.Models.Attendence;
import com.example.ahmed.redux.R;

import java.util.List;

/**
 * Created by Ahmed on 7/17/2016.
 */
public class AttendenceAdapter  extends RecyclerView.Adapter<AttendenceAdapter.Viewholder>{


    private List<Attendence> attendenceList;

    public AttendenceAdapter(List<Attendence> attendenceList)
    {
        this.attendenceList=attendenceList;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendence, parent, false);

        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

        Attendence attendence = attendenceList.get(position);
        holder.course_.setText(attendence.getCourse());
        holder.teacher.setText(attendence.getTeacher());
        holder.conducted.setText(attendence.getConducted());
        holder.present.setText(attendence.getPresent());
        holder.credit.setText(attendence.getCredit());
        holder.days.setText(attendence.getDaysoff());

    }

    @Override
    public int getItemCount() {
        return attendenceList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView course_,teacher,conducted,present,credit,days;

        public Viewholder(View itemView) {
            super(itemView);
            course_=(TextView) itemView.findViewById(R.id.coursevala);
            teacher=(TextView) itemView.findViewById(R.id.teacherval);
            conducted=(TextView)itemView.findViewById(R.id.conductedval);
            present=(TextView) itemView.findViewById(R.id.presentval);
            credit=(TextView) itemView.findViewById(R.id.creditval);
            days=(TextView) itemView.findViewById(R.id.days);
        }
    }
}
