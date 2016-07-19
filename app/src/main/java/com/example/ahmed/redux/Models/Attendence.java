package com.example.ahmed.redux.Models;

/**
 * Created by KhattaK on 7/17/2016.
 */
public class Attendence {
    private String course;
    private String teacher;
    private String conducted;
    private String present;
    private String credit;
    private String daysoff;

    public Attendence(String course,String teacher,String conducted,String present,String credit,String daysoff)
    {
        this.course=course;
        this.teacher=teacher;
        this.conducted=conducted;
        this.present=present;
        this.credit=credit;
        this.daysoff=daysoff;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getConducted() {
        return conducted;
    }

    public void setConducted(String conducted) {
        this.conducted = conducted;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDaysoff() {
        return daysoff;
    }

    public void setDaysoff(String daysoff) {
        this.daysoff = daysoff;
    }
}
