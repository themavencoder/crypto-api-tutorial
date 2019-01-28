
package com.aloine.crypto_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.aloine.crypto_tutorial.network.CoinProperty;

public class DetailsActivity extends AppCompatActivity {
    private TextView mTextName, mTextSymbol, mTextPriceInUsd,
            mTextPriceInBtc, mTextVolumeUsed, mTextMarketCap,
            mTextAvailableSupply, mTextTotalSupply, mTextMaximumSupply, mTextLastUpdated;
    private CoinProperty mCoinProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        mCoinProperty = getIntent().getParcelableExtra(MainActivity.COIN_DETAILS_KEY);
        if (mCoinProperty != null) {
            getData();
        }
    }



    private void init() {
        mTextName = findViewById(R.id.text_coin_name);
        mTextSymbol = findViewById(R.id.text_coin_symbol);
        mTextPriceInUsd  = findViewById(R.id.text_coin_price_usd);
        mTextPriceInBtc = findViewById(R.id.text_coin_price_btc);
        mTextVolumeUsed = findViewById(R.id.text_coin_volume_24);
        mTextMarketCap = findViewById(R.id.text_coin_market_cap);
        mTextAvailableSupply = findViewById(R.id.text_coin_available_supply);
        mTextTotalSupply = findViewById(R.id.text_coin_total_supply);
        mTextMaximumSupply = findViewById(R.id.coin_maximum_supply);
        mTextLastUpdated = findViewById(R.id.text_coin_last_updated);
    }
    private void getData() {
        mTextName.setText(mCoinProperty.getId());
        mTextSymbol.setText(mCoinProperty.getSymbol());
        mTextPriceInUsd.setText(mCoinProperty.getPriceUsd());
        mTextPriceInBtc.setText(mCoinProperty.getPriceBtc());
        mTextVolumeUsed.setText(mCoinProperty.get24hVolumeUsd());
        mTextMarketCap.setText(mCoinProperty.getMarketCapUsd());
        mTextAvailableSupply.setText(mCoinProperty.getAvailableSupply());
        mTextTotalSupply.setText(mCoinProperty.getTotalSupply());
        mTextMaximumSupply.setText(mCoinProperty.getMaxSupply());
        mTextLastUpdated.setText(mCoinProperty.getLastUpdated());


    }
}
