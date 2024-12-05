package com.example.elitte.Retrofit;

import com.example.elitte.Models.TypeOfVocabulary;
import com.example.elitte.Models.Vocabulary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuestionsApi {

    @GET("/api/vocabulary")
    public Call<List<TypeOfVocabulary>> getAllTypeOfVocabulary();

    @GET("/api/vocabulary/{id}")
    public Call<List<Vocabulary>> getAllVocabularyByIdType(@Path("id") Long id);

}
