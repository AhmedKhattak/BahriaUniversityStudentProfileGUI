package com.example.ahmed.redux.Models;

import com.example.ahmed.redux.Extendables.AbstractExpandableDataProviderExtendable;

/**
 * Created by Ahmed on 6/29/2016.
 */
public class ParentData_Model extends AbstractExpandableDataProviderExtendable.GroupData {
    private static final String TAG = "ParentData_Model";
    private String semester;
    private String gpa;
    private String cgpa;
    private long Id;
    private long nextChild;
    private boolean isPinned;

    public ParentData_Model(long id, String semester, String gpa, String cgpa) {
        Id = id;
        nextChild = 0;
        this.setSemester(semester);
        this.setGpa(gpa);
        this.setCgpa(cgpa);
    }

    //region overriden methods
    @Override
    public boolean isSectionHeader() {
        return false;
    }

    @Override
    public long getGroupId() {
        return Id;
    }

    @Override
    public String getSemester() {
        return semester;
    }

    @Override
    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String getGpa() {
        return gpa;
    }

    @Override
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    @Override
    public String getCgpa() {
        return cgpa;
    }

    @Override
    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
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
    //endregion

    //region own methods

    public long generateNewChildId() {
        final long id = nextChild;
        nextChild += 1;
        return id;
    }


    //endregion
}
