package com.example.elitte.Retrofit;

import com.example.elitte.Models.ListExamSet;
import com.example.elitte.Models.Questions;
import com.example.elitte.Models.TypeOfExamSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ExerciseAPI {

    @GET("/api/types")
    public Call<List<TypeOfExamSet>> getTypeOfExamSet();

    @GET("/api/types/{id}/examsets")
    public Call<List<ListExamSet>> getAllExamSetOfTypeOfExamSet(@Path("id") int id);

    @GET("/api/examsets/{id}")
    public Call<List<Questions>> getAllQuestionOfExamSet(@Path("id") int id);

    @GET("/api/examsets/nums/{id}")
    public Call<Integer> getNumberQuestionFromExamSet(@Path("id") int id);

}
