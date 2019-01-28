package com.aloine.crypto_tutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aloine.crypto_tutorial.adapter.CoinAdapter;
import com.aloine.crypto_tutorial.network.ApiService;
import com.aloine.crypto_tutorial.network.Client;
import com.aloine.crypto_tutorial.network.CoinProperty;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CoinAdapter adapter = new CoinAdapter();
    private List<CoinProperty> mCoinList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        adapter.setCoins(mCoinList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getCoins();

    }

    private void getCoins() {
        ApiService apiService = Client.getClient().create(ApiService.class);
        Call<List<CoinProperty>> call = apiService.getCoins();
        call.enqueue(new Callback<List<CoinProperty>>() {
            @Override
            public void onResponse(Call<List<CoinProperty>> call, Response<List<CoinProperty>> response) {
                if (response.isSuccessful()) {
                    mCoinList = response.body();
                    adapter.setCoins(mCoinList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CoinProperty>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to proceed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
