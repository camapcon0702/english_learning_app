package com.example.elitte.Retrofit;


import com.example.elitte.Models.ListFlashCard;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlashCardAPI {


    @GET("/api/cards")
    Call<ListFlashCard> getAllFlashCards();

}
