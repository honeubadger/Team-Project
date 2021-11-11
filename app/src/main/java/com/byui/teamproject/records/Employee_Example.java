package com.byui.teamproject.records;

import androidx.annotation.NonNull;

public class Employee_Example {

    String name;
    String time;
    int ID;

    public Employee_Example(String name, String time, int ID) {
        this.name = name;
        this.time = time;
        this.ID = ID;
    }

    @NonNull
    @Override
    public String toString() {
        return name + "\nID: " + ID + "\nLast login: " + time;
    }
}
