package com.example.ahmed.redux.Models;

import com.example.ahmed.redux.Extendables.AbstractExpandableDataProviderExtendable;

/**
 * Created by Ahmed on 6/29/2016.
 */
public class ChildData_Model extends AbstractExpandableDataProviderExtendable.ChildData {

    private static final String TAG = "ChildData_Model";
    private long Id;
    private String course;
    private String grade;
    private boolean isPinned;

    public ChildData_Model(long id, String course, String grade) {
        Id = id;
        this.setCourse(course);
        this.setGrade(grade);
    }


    //region overriden methods
    @Override
    public long getChildId() {
        return Id;
    }

    @Override
    public String getText() {
        return "NotForOfficialUse_XML";
    }

    @Override
    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    @Override
    public boolean isPinned() {
        return isPinned;
    }

    @Override
    public String getCourse() {
        return course;
    }

    @Override
    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String getGrade() {
        return grade;
    }

    @Override
    public void setGrade(String grade) {
        this.grade = grade;
    }

    //endregion


    //region own methods
    public void setChildId(long id) {
        Id = id;
    }
    //endregion
}
