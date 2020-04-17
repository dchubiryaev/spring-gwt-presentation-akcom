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

    public UserForm() {
    }
}

