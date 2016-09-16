package com.example.ahmed.redux.Providers;

import com.example.ahmed.redux.Models.Attendence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KhattaK on 7/17/2016.
 */
public class AttendenceProvider {

    private static List<Attendence> attendenceList = new ArrayList<>();

    public static String[] course_ = {"Operating System Lab", "Computer Organization and Assembly Language Lab", "Compiler Construction Lab", "Advanced Databases Lab", "Design and Analysis of Algorithms", "Advanced Databases", "Numerical Methods", "Computer Organization and Assembly Language", "Compiler Construction", "Operating System"};
    public static String[] teachers_ = {"ADNAN (CS)", "AFNAN SADDIQUE", "FARAZHALID", "RAMIS ALI", "DR MUZAMIL", "IRAM JAMSHED", "AMBRINA KANWAL", "MAHMOOD QURESHI", "DR SABINA", "MUHAMMAD UMAR KHATTAK"};
    public static String[] credits = {"2", "1", "2", "1", "2", "1", "3", "3", "3", "1"};
    public static String[] conducted = {"48.00", "48", "45", "48", "46", "30", "48", "32", "32", "45"};
    public static String[] present = {"42.00 (87.5%)", "48 (100%)", "42 (93.33%)", "45 (93.75%)", "44 (95.65%)", "28 (93.33%)", "45 (93.75%)", "30 (93.75%)", "28 (87.5%)", "39 (86.67%)"};
    private static String[] days={"4", "8", "6", "6", "6", "6", "6", "6", "6", "2"};

    public static List<Attendence> getAttendenceList() {
        attendenceList.clear();

        for(int x=0;x<10;x++)
        {
            attendenceList.add(new Attendence(course_[x],teachers_[x],conducted[x],present[x],credits[x],days[x]));
        }

        return attendenceList;
    }

    public static Attendence getAttendenceAtPostion(int position)
    {
     return    attendenceList.get(position);
    }
}
