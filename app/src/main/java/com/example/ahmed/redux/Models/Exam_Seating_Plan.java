package com.example.ahmed.redux.Models;

import com.example.ahmed.redux.Providers.SampleDataProviderExtendable;

/**
 * Created by KhattaK on 7/14/2016.
 */
public class Exam_Seating_Plan {

    private String course;
    private String date;
    private String time;
    private String room;
    private String row;
    private String column;


    public Exam_Seating_Plan(String course,String date,String time,String room,String row,String column)
    {
        this.course=course;
        this.date=date;
        this.time=time;
        this.room=room;
        this.row=row;
        this.column=column;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
