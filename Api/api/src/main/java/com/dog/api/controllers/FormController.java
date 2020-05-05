package com.dog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    DataUtils dataBase;

    @GetMapping(path = "/")
    public String hello() {
        return "Hi world!";
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public int saveUserForm(@RequestBody UserForm form) {
        return dataBase.save(form);
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserForm> getUserForms() {
        return dataBase.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserForm getUserForms(@PathVariable Long id) {
        return dataBase.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean delete(@PathVariable Long id){
        return dataBase.deleteById(id);
    }
}