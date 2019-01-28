package com.aloine.crypto_tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aloine.crypto_tutorial.adapter.CoinAdapter;
import com.aloine.crypto_tutorial.adapter.OnCoinClickListener;
import com.aloine.crypto_tutorial.network.ApiService;
import com.aloine.crypto_tutorial.network.Client;
import com.aloine.crypto_tutorial.network.CoinProperty;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnCoinClickListener {
    private RecyclerView recyclerView;
    private CoinAdapter adapter = new CoinAdapter();
    private List<CoinProperty> mCoinList;
    public static final String COIN_DETAILS_KEY = "com.aloine.crypto_tutorial.COIN_DETAILS_KEY";
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);
        adapter.setCoins(mCoinList);
        adapter.setOnCoinClickListener(this);
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
                    mProgressBar.setVisibility(View.GONE);
                    mCoinList = response.body();
                    adapter.setCoins(mCoinList);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<CoinProperty>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Unable to proceed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onCoinClick(CoinProperty coinProperty) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(COIN_DETAILS_KEY,coinProperty);
        startActivity(intent);


    }
}
