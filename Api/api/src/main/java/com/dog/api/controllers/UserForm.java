package com.dog.api.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserForm {
    @JsonProperty("fname")
    public String fname;
    @JsonProperty("lname")
    public String lname;
    @JsonProperty("isHuman")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserForm userForm = (UserForm) o;
        return isHuman == userForm.isHuman &&
                Objects.equals(fname, userForm.fname) &&
                Objects.equals(lname, userForm.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, isHuman);
    }
}

