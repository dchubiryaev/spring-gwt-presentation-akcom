package com.dog.api.controllers;

import com.dog.api.persistance.dao.UserFormDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class FormController {

    private UserFormDAO userFormDAO;

    @GetMapping(path = "/")
    public String hello() {
        return "Hi world!";
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserFormResponse saveUserForm(@RequestBody UserForm form) {
        System.out.println("POST DATA " + form.toString());
//        Key<UserForm> userFormKey = userFormDAO.saveAndReturnKey(form);
//        System.out.println(userFormKey.getId());
        return new UserFormResponse("Response!", 1);
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserForm> getUserForms() {
        return Collections.emptyList();
    }
}