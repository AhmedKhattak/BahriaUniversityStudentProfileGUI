package com.example.ahmed.redux.Providers;

import com.example.ahmed.redux.BuildConfig;
import com.example.ahmed.redux.Models.Settings_Model_Checkbox;
import com.example.ahmed.redux.Models.Settings_Model_Default;
import com.example.ahmed.redux.Models.Settings_Model_Switch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khattak on 7/26/2016.
 */
public class Settings_Provider {

    public static List<Object> objectList=new ArrayList<>();

    public static List<Object> getSettingsData()
    {
        objectList.clear();
        objectList.add(new Settings_Model_Default("Background Sync","Never"));
        objectList.add(new Settings_Model_Switch("Notifications","Disabled"));
        objectList.add(new Settings_Model_Default("Change Log","View recent changes to the App"));
        objectList.add(new Settings_Model_Default("Privacy Policy","View Our Privacy Policy"));
        objectList.add(new Settings_Model_Default("Open Source","View Open Source Licenses"));
        objectList.add(new Settings_Model_Default("About","About this App"));
        objectList.add(new Settings_Model_Default("Build Version","Version "+BuildConfig.VERSION_NAME));
        return objectList;
    }
}
