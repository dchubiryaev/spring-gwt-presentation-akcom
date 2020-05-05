package com.dog.api.controllers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataUtils {
    List<UserForm> userForms = new ArrayList<>();

    {
        userForms.add(new UserForm("Иван", "Иванов", true));
        userForms.add(new UserForm("Petr", "Petrov", true));
        userForms.add(new UserForm("Муська", "Маруська", false));
        userForms.add(new UserForm("Улитка", "", false));
    }

    public int save(UserForm form) {
        if (!userForms.contains(form)) {
            userForms.add(form);
        }
        return userForms.indexOf(form);
    }

    public UserForm getById(Long id) {
        return userForms.get(Math.toIntExact(id));
    }

    public List<UserForm> getAll(){
        return userForms;
    }

    public boolean delete(UserForm form){
        return userForms.remove(form);
    }

    public boolean deleteById(Long id){
        return userForms.remove(id);
    }
}

