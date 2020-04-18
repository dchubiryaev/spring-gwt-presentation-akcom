package com.bidding.client.service;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface FormService extends RestService {
    @POST
    @Path("http://localhost:8081/save")
    void order(UserForm request,
               MethodCallback<UserFormResponse> callback);
}