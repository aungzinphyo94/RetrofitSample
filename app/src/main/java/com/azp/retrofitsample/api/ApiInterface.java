package com.azp.retrofitsample.api;

import com.azp.retrofitsample.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {

    @GET("/users")
    Call<List<Users>> getAllUsers();

//    @POST
//
//    @PUT
//
//    @DELETE
}
