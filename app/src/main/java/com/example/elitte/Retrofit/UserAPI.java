package com.example.elitte.Retrofit;

import com.example.elitte.Models.LoginRequest;
import com.example.elitte.Models.LoginResponse;
import com.example.elitte.Models.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {

    @GET("/api/user/profile")
    Call<UserResponse> getUserProfile();
}
