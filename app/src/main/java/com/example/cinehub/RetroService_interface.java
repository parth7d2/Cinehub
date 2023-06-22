package com.example.cinehub;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RetroService_interface {

    @POST("3/movie/popular?api_key=6e63c2317fbe963d76c3bdc2b785f6d1&page=1")
    Call<JsonModel> getData();

}