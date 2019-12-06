package com.example.myapplicationlv1.interfaces;

import com.example.myapplicationlv1.models.CourseResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/v1/courses")
    Call<CourseResponse> getCourses();
}
