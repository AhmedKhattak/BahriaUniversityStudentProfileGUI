package com.example.ahmed.redux.Models;

/**
 * Created by Ahmed Khattak on 05/08/2016.
 */
public class NavItems_Header_Model {
    public String name;
    public String enroll;
    int profile;

    public NavItems_Header_Model(String name, String enroll, int profile) {
        this.name = name;
        this.enroll = enroll;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
