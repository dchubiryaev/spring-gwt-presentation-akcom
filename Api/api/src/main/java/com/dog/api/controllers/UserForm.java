package com.dog.api.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserForm {
    @JsonProperty("fname")
    public String fname;
    @JsonProperty("lname")
    public String lname;
    @JsonProperty("isHuman")
    public boolean isHuman;

    @Override
    public String toString() {
        return "UserForm{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", isHuman=" + isHuman +
                '}';
    }
}

