package com.example.newsapp;

import com.example.newsapp.model.HeadlineResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {
    @GET("top-headlines?country=us&apiKey=70cfb71aa5d64e8c9db980e2799043e2")
    Call<HeadlineResponse> getHeadline();

    @GET(" sources?apiKey=70cfb71aa5d64e8c9db980e2799043e2")
    Call<CategoryResponse> getCatry();

    @GET(" sources?category=general&apiKey=70cfb71aa5d64e8c9db980e2799043e2")
    Call<GenResponse> getgen();
    @GET(" sources?category=business&apiKey=70cfb71aa5d64e8c9db980e2799043e2")
    Call<GenResponse> getbus();

    @GET(" sources?category=entertainment&apiKey=70cfb71aa5d64e8c9db980e2799043e2")
    Call<GenResponse> getenter();

    @GET(" sources?category=health&apiKey=70cfb71aa5d64e8c9db980e2799043e2")
    Call<GenResponse> gethlth();


}
