package com.example.realestateassignmentinternship.Interface;

import com.example.realestateassignmentinternship.Model.M_Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users.json")
    Call<M_Model> getData();

}
