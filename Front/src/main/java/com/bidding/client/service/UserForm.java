package com.bidding.client.service;

public class UserForm {
    public String fname;
    public String lname;
    public boolean isHuman;

    public UserForm(String fname, String lname, boolean isHuman) {
        this.fname = fname;
        this.lname = lname;
        this.isHuman = isHuman;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", isHuman=" + isHuman +
                '}';
    }
}

