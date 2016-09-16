package com.example.ahmed.redux.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.example.ahmed.redux.Models.Attendence;
import com.example.ahmed.redux.Providers.AttendenceProvider;
import com.example.ahmed.redux.R;
import com.example.ahmed.redux.Utils.utility;
import com.mikepenz.iconics.utils.Utils;

import java.util.List;

/**
 * Created by Ahmed on 7/17/2016.
 */
public class AttendenceAdapter  extends RecyclerView.Adapter<AttendenceAdapter.Viewholder>{


    private List<Attendence> attendenceList;

    private Context context;
    private int lastAnimatedPosition = -1;
    private static  int ANIMATED_ITEMS_COUNT = 0;
    float basespeed =1.f;

    public AttendenceAdapter(List<Attendence> attendenceList,Context context)
    {
        this.attendenceList=attendenceList;
        //this.context = context;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendence, parent, false);

        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

        //runEnterAnimation(holder.itemView, position,basespeed+.5f);
        Attendence attendence = attendenceList.get(position);
        holder.course_.setText(attendence.getCourse());
        holder.teacher.setText(attendence.getTeacher());
        holder.conducted.setText(attendence.getConducted());
        holder.present.setText(attendence.getPresent());
        holder.credit.setText(attendence.getCredit());
        holder.days.setText(attendence.getDaysoff());
        Log.d("Fukc",String.valueOf(holder.getItemViewType()));

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


    private void runEnterAnimation(View view, int position,float speed) {
        if (position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(utility.getScreenHeight(context));
            view.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(speed))
                    .setDuration(700)
                    .start();
        }
    }

    public void updateItems()
    {
        attendenceList= AttendenceProvider.getAttendenceList();
        //ANIMATED_ITEMS_COUNT=attendenceList.size();
        notifyItemRangeInserted(0, attendenceList.size());
    }


    public void add(Attendence attendence, int position) {
        attendenceList.add(position,attendence);
        notifyItemInserted(position);
    }
}
