package com.example.ahmed.redux.Providers;

import com.example.ahmed.redux.Models.Exam_Seating_Plan;
import com.example.ahmed.redux.Models.Note_Model;
import com.example.ahmed.redux.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KhattaK on 7/15/2016.
 */
public class ExamSeatingPlanProvider {

    public static String[] subject = {"Operating System Lab", "Computer Organization and Assembly Language Lab", "Compiler Construction Lab", "Advanced Databases Lab", "Design and Analysis of Algorithms", "Advanced Databases", "Numerical Methods", "Computer Organization and Assembly Language", "Compiler Construction", "Operating System"};
    public static String[] date = {" ", " ", " ", " ", "30-MAY-2016", "31-MAY-2016", "01-JUN-2016", "03-JUN-2016", "04-JUN-2016", "05-JUN-2016"};
    public static String time_ = "17:30-19:30";
    public static String[] room = {" ", " ", " ", " ", "XC-8", "XC-20", "XC-24", "HL-13", "XC-21", "HL-7"};
    public static String[] row = {" ", " ", " ", " ", "4", "2", "2", "5", "5", "2"};
    public static String[] col = {" ", " ", " ", " ", "1", "5", "6", "3", "6", "4"};

    private static List<Object> examSeatingPlanList = new ArrayList<>();

    public static List<Object> getExamSeatingPlanData() {

        examSeatingPlanList.clear();
        examSeatingPlanList.add(new Note_Model("0"));
        for(int x=0;x<10;x++)
        {

            if(x<=3)
            {
                examSeatingPlanList.add(new Exam_Seating_Plan(subject[x],"n/a","n/a","n/a","n/a","n/a"));
            }
            else
            {

                examSeatingPlanList.add(new Exam_Seating_Plan(subject[x],date[x],time_,room[x],row[x],col[x]));
            }


        }
        return examSeatingPlanList;

    }
}
