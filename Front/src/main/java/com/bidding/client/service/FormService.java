package com.bidding.client.service;

import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

public interface FormService extends RestService {
    @POST
    @Path("http://localhost:8081/save")
    void save(UserForm request,
              MethodCallback<Integer> callback);

    @GET
    @Path("http://localhost:8081/get")
    void getAll(MethodCallback<List<UserForm>> callback);

    @GET
    @Path("http://localhost:8081/get/")
    void getById(Integer id, MethodCallback<List<UserForm>> callback);

    @DELETE
    @Path("http://localhost:8081")
    void delete(Integer id, MethodCallback<Boolean> callback);

    static FormService execute() {
        return GWT.create(FormService.class);
    }
}