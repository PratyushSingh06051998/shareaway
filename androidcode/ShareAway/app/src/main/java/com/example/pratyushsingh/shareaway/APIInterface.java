package com.example.pratyushsingh.shareaway;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/login")
    Call<LoginStructure> login(@Query("email") String email,@Query("pass") String pass);

    @GET("/signup")
    Call<LoginStructure> signup(@Query("name") String name,@Query("email") String email,@Query("pass") String pass,@Query("pnum") String pnum,@Query("sex") String sex,@Query("fcm") String fcm);

}
