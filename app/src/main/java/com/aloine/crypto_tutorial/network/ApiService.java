package com.aloine.crypto_tutorial.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("ticker")
    Call<List<CoinProperty>> getCoins(@Query("limit") int limit);
}
