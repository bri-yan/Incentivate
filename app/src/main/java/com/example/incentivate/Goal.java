package com.example.incentivate;

import java.util.ArrayList;
import java.util.Calendar;

public class Goal {
    public String title;
    public Calendar startDate;
    public Calendar startTime;
    public Calendar endDate;
    public Calendar endTime;
    public int goalAmount;
    public double deposit;
    public String notes;
    public static ArrayList<Goal> goals = new ArrayList<>();

    public Goal(String title, Calendar startDate, Calendar startTime, Calendar endDate, Calendar endTime, int goalAmount, double deposit, String notes) {
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.goalAmount = goalAmount;
        this.deposit = deposit;
        this.notes = notes;
        goals.add(this);
    }
}
