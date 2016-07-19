package com.example.ahmed.redux.Models;

/**
 * Created by Ahmed on 6/29/2016.
 */
public class ActualChildData_Model {

    private String course;
    private String grade;

    public ActualChildData_Model(String course, String grade) {
        this.course = course;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
