package com.aloine.crypto_tutorial.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aloine.crypto_tutorial.R;
import com.aloine.crypto_tutorial.network.CoinProperty;

import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinViewHolder>  {
    private OnCoinClickListener listener;
    private List<CoinProperty> coinList;

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_coins,viewGroup,false);

        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder coinViewHolder, int i) {
        CoinProperty coinProperty = coinList.get(i);
        coinViewHolder.bind(listener,coinProperty);


    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }

    class CoinViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCoin, textViewRank;

        public CoinViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCoin = itemView.findViewById(R.id.text_view_coin);
            textViewRank = itemView.findViewById(R.id.text_view_rank);

        }
        public void bind(final OnCoinClickListener listener, final CoinProperty coinProperty) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   listener.onCoinClick(coinProperty);
                }
            });
            textViewCoin.setText(coinProperty.getId());
            textViewRank.setText(coinProperty.getRank());
        }
    }

    public void setCoins(List<CoinProperty> coinList) {
        this.coinList = coinList;

    }

    public void setOnCoinClickListener(OnCoinClickListener listener) {

        this.listener = listener;
    }
}
