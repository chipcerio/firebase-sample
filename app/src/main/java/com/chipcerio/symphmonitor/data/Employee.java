package com.chipcerio.symphmonitor.data;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Employee {
    private String fullname;

    public Employee(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
