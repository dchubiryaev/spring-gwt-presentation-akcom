package com.dog.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class Controller {

    @GetMapping(path = "/")
    public String hello() {
        return "Hi world!";
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserFormResponse saveUserForm(@RequestBody UserForm form) {
        System.out.println("POST DATA " + form.toString());
        return new UserFormResponse("Response!", 1);
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserForm> getUserForms() {
        return Collections.emptyList();
    }
}