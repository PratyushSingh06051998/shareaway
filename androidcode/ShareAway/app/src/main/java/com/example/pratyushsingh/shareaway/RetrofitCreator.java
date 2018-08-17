package com.example.pratyushsingh.shareaway;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {

    public static String URL = "https://neat-snail-40.localtunnel.me" +
            "/";

    public Retrofit retrofitcreate(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;

    }

}
