package com.bidding.client.service;

import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import java.util.List;

public interface FormService extends RestService {
    @POST
    @Path("http://localhost:8081/save")
    void save(UserForm request,
              MethodCallback<Integer> callback);

    @GET
    @Path("http://localhost:8081/all")
    void getAll(MethodCallback<List<UserForm>> callback);

    @GET
    @Path("http://localhost:8081/get")
    void getById(@QueryParam("id") Integer id, MethodCallback<UserForm> callback);

    @DELETE
    @Path("http://localhost:8081")
    void delete(Integer id, MethodCallback<Boolean> callback);

    static FormService execute() {
        return GWT.create(FormService.class);
    }
}