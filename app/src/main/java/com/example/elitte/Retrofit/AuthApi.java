package com.example.elitte.Retrofit;

import com.example.elitte.Models.LoginRequest;
import com.example.elitte.Models.LoginResponse;
import com.example.elitte.Models.RegisterRequest;
import com.example.elitte.Models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("/auth/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("/auth/register")
    Call<RegisterResponse> register(@Body RegisterRequest request);




}
