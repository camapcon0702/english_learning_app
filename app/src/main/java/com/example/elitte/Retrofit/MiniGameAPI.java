package com.example.elitte.Retrofit;

import com.example.elitte.Models.ListMiniGame;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MiniGameAPI {


    @GET("/api/minigames")
    Call<ListMiniGame> getListMinigamme();

}
