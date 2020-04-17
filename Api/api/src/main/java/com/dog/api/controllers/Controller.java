package com.dog.api.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserFormResponse hello(@RequestBody UserForm form) {
        return new UserFormResponse("Response!");
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserFormResponse helloPost(@RequestBody UserForm form) {
        System.out.println("Reach POST");
        System.out.println("POST DATA " + form.toString());
        return new UserFormResponse("Response!");
    }
}