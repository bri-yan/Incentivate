package com.example.incentivate.activity;

import java.util.ArrayList;
import java.util.List;

public abstract class Activity {
    private String name;

    public Activity(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static List<Activity> createActivityList(int n){
        List<Activity> activies= new ArrayList<>();
        for (int i = 0; i< n ; i++){
            activies.add(new walk(Integer.toString(i)));
        }
        return activies;
    }
}
