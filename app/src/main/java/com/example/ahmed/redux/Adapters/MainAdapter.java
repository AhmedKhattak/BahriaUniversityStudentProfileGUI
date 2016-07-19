package com.example.ahmed.redux.Adapters;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ahmed.redux.Jugarr.JugarFrameLayout;
import com.example.ahmed.redux.Providers.SampleDataProviderExtendable;
import com.example.ahmed.redux.R;
import com.example.ahmed.redux.widget.ExpandableItemIndicator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;


/**
 * Created by Ahmed on 6/30/2016.
 */
public class MainAdapter extends AbstractExpandableItemAdapter<MainAdapter.ParentView, MainAdapter.ChildView> {

    //region initializers
    private static final String TAG = "MainAdapter";
    private SampleDataProviderExtendable mProvider;

    //endregion


    //region constructor

    public MainAdapter(SampleDataProviderExtendable dataProvider) {
        mProvider = dataProvider;
        // ExpandableItemAdapter requires stable ID, and also
        // have to implement the getGroupItemId()/getChildItemId() methods appropriately.
        setHasStableIds(true);
    }
    //endregion


    //region ovveridden methods
    @Override
    public int getGroupCount() {

        return mProvider.getGroupCount();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return mProvider.getChildCount(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return mProvider.getGroupItem(groupPosition).getGroupId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return mProvider.getChildItem(groupPosition, childPosition).getChildId();
    }

    @Override
    public MainAdapter.ParentView onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.parentitem, parent, false);
        return new ParentView(v);
    }

    @Override
    public MainAdapter.ChildView onCreateChildViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.childitem, parent, false);
        return new ChildView(v);
    }

    @Override
    public void onBindGroupViewHolder(MainAdapter.ParentView holder, int groupPosition, int viewType) {
        final SampleDataProviderExtendable.GroupData item = mProvider.getGroupItem(groupPosition);
        holder.semester.setText(item.getSemester());
        holder.gpa.setText(item.getCgpa());
        holder.cgpa.setText(item.getGpa());
        holder.itemView.setClickable(true);
        if(groupPosition==mProvider.getGroupCount())
        {

        }
        // set expand state animations are done else where
        final int expandState = holder.getExpandStateFlags();
        if ((expandState & ExpandableItemConstants.STATE_FLAG_IS_UPDATED) != 0) {
            boolean isExpanded;
            boolean animateIndicator = ((expandState & Expandable.STATE_FLAG_HAS_EXPANDED_STATE_CHANGED) != 0);

            if ((expandState & Expandable.STATE_FLAG_IS_EXPANDED) != 0) {
                isExpanded = true;
            } else {
                isExpanded = false;
            }

            holder.mIndicator.setExpandedState(isExpanded, animateIndicator);
        }

    }

    @Override
    public void onBindChildViewHolder( MainAdapter.ChildView holder, int groupPosition, int childPosition, int viewType) {
        final SampleDataProviderExtendable.ChildData childData = mProvider.getChildItem(groupPosition, childPosition);
        holder.grade.setText(childData.getGrade());
        holder.course.setText(childData.getCourse());
    }



    @Override
    public boolean onCheckCanExpandOrCollapseGroup(MainAdapter.ParentView holder, int groupPosition, int x, int y, boolean expand) {
        // check the item is *not* pinned
        if (mProvider.getGroupItem(groupPosition).isPinned()) {
            // return false to raise View.OnClickListener#onClick() event
            return false;
        }

        // check is enabled
        if (!(holder.itemView.isEnabled() && holder.itemView.isClickable())) {
            return false;
        }

        return true;
    }
    //endregion


    //region view holders

    public class ParentView extends AbstractExpandableItemViewHolder {

        public ExpandableItemIndicator mIndicator; //the indicator !!!
        public TextView semester;
        public TextView gpa;
        public TextView cgpa;
        public CardView cardView;

        public ParentView(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card_view);
            semester = (TextView) itemView.findViewById(R.id.semesterval);
            gpa = (TextView) itemView.findViewById(R.id.gpaval);
            cgpa = (TextView) itemView.findViewById(R.id.cgpaval);
            mIndicator = (ExpandableItemIndicator) itemView.findViewById(R.id.indicator);
        }
    }


    public class ChildView extends AbstractExpandableItemViewHolder {
        public TextView course;
        public TextView grade;

        public ChildView(View itemView) {
            super(itemView);
            //frameLayout= (JugarFrameLayout) itemView.findViewById(R.id.frame_child);
            course = (TextView) itemView.findViewById(R.id.coursevalc);
            grade = (TextView) itemView.findViewById(R.id.gradeval);
        }


    }
    //endregion

    // NOTE: Make accessible with short name
    private interface Expandable extends ExpandableItemConstants {
    }

}
