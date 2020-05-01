package com.example.android.samisapi.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://www.googleapis.com/";
    private static Retrofit tsoonamiRetrofit = null;


    public static Retrofit getClient() {
        if (tsoonamiRetrofit==null) {
            tsoonamiRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return tsoonamiRetrofit;
    }
}
