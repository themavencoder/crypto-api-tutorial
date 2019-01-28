package com.aloine.crypto_tutorial.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("ticker")
    Call<List<CoinProperty>> getCoins();
}
