package com.example.elitte.Retrofit;

import com.example.elitte.Models.TypeOfExamSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExerciseAPI {

    @GET("/api/types")
    public Call<List<TypeOfExamSet>> getTypeOfExamSet();

}
