package com.example.myapplicationlv1.models;

import com.example.myapplicationlv1.interfaces.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    static ApiManager instance;
    private ApiInterface service;
    private ApiManager(){
        Retrofit.Builder builder = new Retrofit.Builder();
        //postavljanje retrofit-a
        Retrofit retrofit = builder.baseUrl("https://catalog-api.udacity.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiInterface.class);
    }
    public static ApiManager getInstance(){
        if (instance == null){
            instance = new ApiManager();
        }
        return instance;
    }
    public ApiInterface service(){
        return service;
    }
}
