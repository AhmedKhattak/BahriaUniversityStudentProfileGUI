package com.example.ahmed.redux.Providers;

import android.support.v4.util.Pair;

import com.example.ahmed.redux.Extendables.AbstractExpandableDataProvider_Extendable;
import com.example.ahmed.redux.Models.ChildData_Model;
import com.example.ahmed.redux.Models.ParentData_Model;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ahmed on 6/29/2016.
 */
public class SampleDataProviderExtendable extends AbstractExpandableDataProvider_Extendable {

    //region initializations

    private static final String TAG = "SampleDataProviderExtendable";
    static String[] Fuck = {"Fall-2015 Semester", "3", "2.99"};
    //child data sample
    static String[] Duck = {"Visual Programming Lab", "Web-Engineering", "Visual Programming", "Theory of Automata", "Linear Algebra", "Data Communication & Networking Lab", "Data Communication & Networking"
            , "Web-Engineering Lab", "Computer Architecture",};
    static String[] Luck = {"A", "B+", "A", "C", "C+", "B", "B", "A", "C+"};

    private List<Pair<ParentData_Model, List<ChildData_Model>>> mData;

    // for undo group item
    private Pair<ParentData_Model, List<ChildData_Model>> mLastRemovedGroup;
    private int mLastRemovedGroupPosition = -1;

    // for undo child item
    private ChildData_Model mLastRemovedChild;
    private long mLastRemovedChildParentGroupId = -1;
    private int mLastRemovedChildPosition = -1;


    public SampleDataProviderExtendable() {


        mData = new LinkedList<>();
        for (int x = 0; x < 10; x++) //how many cards will be controlled by sql data somehow just for demo 10 cards will be made
        {
            final long parentId = x; //make parent id
            final String semester = Fuck[0];
            final String gpa = Fuck[1];
            final String cgpa = Fuck[2];
            final ParentData_Model parentData_model = new ParentData_Model(parentId, semester, gpa, cgpa);
            final List<ChildData_Model> children = new ArrayList<>();
            for (int y = 0; y < Duck.length; y++) //increase length to increase children count loop is redundant but its here anyways fuck you here there is only one child of each parent
            {
                final long childId = parentData_model.generateNewChildId();

                    final String course = Duck[y];
                    final String grade = Luck[y];
                children.add(new ChildData_Model(childId,course,grade));
            }
            mData.add(new Pair<>(parentData_model,children));
        }
    }

    //endregion


    //region own methods


    //endregion


    //region overriden methods
    @Override
    public int getGroupCount() {
        return mData.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return mData.get(groupPosition).second.size();
    }

    @Override
    public GroupData getGroupItem(int groupPosition) {
        if (groupPosition < 0 || groupPosition >= getGroupCount()) {
            throw new IndexOutOfBoundsException("groupPosition = " + groupPosition);
        }

        return mData.get(groupPosition).first;
    }

    @Override
    public ChildData getChildItem(int groupPosition, int childPosition) {
        if (groupPosition < 0 || groupPosition >= getGroupCount()) {
            throw new IndexOutOfBoundsException("groupPosition = " + groupPosition);
        }

        final List<ChildData_Model> children = mData.get(groupPosition).second;

        if (childPosition < 0 || childPosition >= children.size()) {
            throw new IndexOutOfBoundsException("childPosition = " + childPosition);
        }

        return children.get(childPosition);
    }

    @Override
    public void moveGroupItem(int fromGroupPosition, int toGroupPosition) {
        if (fromGroupPosition == toGroupPosition) {
            return;
        }

        final Pair<ParentData_Model, List<ChildData_Model>> item = mData.remove(fromGroupPosition);
        mData.add(toGroupPosition, item);
    }

    @Override
    public void moveChildItem(int fromGroupPosition, int fromChildPosition, int toGroupPosition, int toChildPosition) {
        if ((fromGroupPosition == toGroupPosition) && (fromChildPosition == toChildPosition)) {
            return;
        }

        final Pair<ParentData_Model, List<ChildData_Model>> fromGroup = mData.get(fromGroupPosition);
        final Pair<ParentData_Model, List<ChildData_Model>> toGroup = mData.get(toGroupPosition);

        final ChildData_Model item =  fromGroup.second.remove(fromChildPosition);

        if (toGroupPosition != fromGroupPosition) {
            // assign a new ID
            final long newId = (toGroup.first).generateNewChildId();
            item.setChildId(newId);
        }

        toGroup.second.add(toChildPosition, item);
    }

    @Override
    public void removeGroupItem(int groupPosition) {
        mLastRemovedGroup = mData.remove(groupPosition);
        mLastRemovedGroupPosition = groupPosition;

        mLastRemovedChild = null;
        mLastRemovedChildParentGroupId = -1;
        mLastRemovedChildPosition = -1;
    }

    @Override
    public void removeChildItem(int groupPosition, int childPosition) {
        mLastRemovedChild = mData.get(groupPosition).second.remove(childPosition);
        mLastRemovedChildParentGroupId = mData.get(groupPosition).first.getGroupId();
        mLastRemovedChildPosition = childPosition;

        mLastRemovedGroup = null;
        mLastRemovedGroupPosition = -1;
    }

    @Override
    public long undoLastRemoval() {
        if (mLastRemovedGroup != null) {
            return undoGroupRemoval();
        } else if (mLastRemovedChild != null) {
            return undoChildRemoval();
        } else {
            return RecyclerViewExpandableItemManager.NO_EXPANDABLE_POSITION;
        }
    }

    private long undoGroupRemoval() {
        int insertedPosition;
        if (mLastRemovedGroupPosition >= 0 && mLastRemovedGroupPosition < mData.size()) {
            insertedPosition = mLastRemovedGroupPosition;
        } else {
            insertedPosition = mData.size();
        }

        mData.add(insertedPosition, mLastRemovedGroup);

        mLastRemovedGroup = null;
        mLastRemovedGroupPosition = -1;

        return RecyclerViewExpandableItemManager.getPackedPositionForGroup(insertedPosition);
    }



    private long undoChildRemoval() {
        Pair<ParentData_Model, List<ChildData_Model>> group = null;
        int groupPosition = -1;

        // find the group
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).first.getGroupId() == mLastRemovedChildParentGroupId) {
                group = mData.get(i);
                groupPosition = i;
                break;
            }
        }

        if (group == null) {
            return RecyclerViewExpandableItemManager.NO_EXPANDABLE_POSITION;
        }

        int insertedPosition;
        if (mLastRemovedChildPosition >= 0 && mLastRemovedChildPosition < group.second.size()) {
            insertedPosition = mLastRemovedChildPosition;
        } else {
            insertedPosition = group.second.size();
        }

        group.second.add(insertedPosition, mLastRemovedChild);

        mLastRemovedChildParentGroupId = -1;
        mLastRemovedChildPosition = -1;
        mLastRemovedChild = null;

        return RecyclerViewExpandableItemManager.getPackedPositionForChild(groupPosition, insertedPosition);
    }
    //endregion
}
