package com.example.ahmed.redux.Extendables;
/**
 * Created by KhattaK on 6/28/2016.
 * this must be used in advanced recycler layout expandable stuff
 */

public abstract class AbstractExpandableDataProvider_Extendable {
    public static abstract class BaseData {

        public abstract String getText();
        public abstract void setPinned(boolean pinned);
        public abstract boolean isPinned();
    }

    public static abstract class GroupData extends BaseData {
        public abstract boolean isSectionHeader();
        public abstract long getGroupId();
        public abstract String getSemester();
        public abstract void setSemester(String semester);
        public abstract String getGpa();
        public abstract void setGpa(String gpa);
        public abstract String getCgpa();
        public abstract void setCgpa(String cgpa);
    }

    public static abstract class ChildData extends BaseData {
        public abstract String getCourse();
        public abstract void setCourse(String course);
        public abstract String getGrade();
        public abstract void  setGrade(String grade);
        public abstract long getChildId();
    }

    public abstract int getGroupCount();
    public abstract int getChildCount(int groupPosition);

    public abstract GroupData getGroupItem(int groupPosition);
    public abstract ChildData getChildItem(int groupPosition, int childPosition);

    public abstract void moveGroupItem(int fromGroupPosition, int toGroupPosition);
    public abstract void moveChildItem(int fromGroupPosition, int fromChildPosition, int toGroupPosition, int toChildPosition);

    public abstract void removeGroupItem(int groupPosition);
    public abstract void removeChildItem(int groupPosition, int childPosition);

    public abstract long undoLastRemoval();
}