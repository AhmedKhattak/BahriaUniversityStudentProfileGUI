package com.example.ahmed.redux.Providers;

import com.example.ahmed.redux.Models.NavItems_Header_Model;
import com.example.ahmed.redux.Models.NavItems_Model;
import com.example.ahmed.redux.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Khattak on 05/08/2016.
 */
public class NavDrawerItemProvider {
    public static String[] navitems = {"Profile", "Notifications", "Evaluation", "Registration", "Change Password", "Settings", "Feedback", "Rate Us !", "Privacy Policy","Logout"};
    private static List<Object> navItemsModelList = new ArrayList<>();

    public static List<Object> getExamSeatingPlanData() {

        navItemsModelList.clear();
        navItemsModelList.add(new NavItems_Header_Model("Ahmed Khattak","01-134132-016", R.drawable.test_account_pic));
        for (int x = 0; x < navitems.length; x++) {
            navItemsModelList.add(new NavItems_Model(navitems[x]));
        }
        return navItemsModelList;

    }
}
