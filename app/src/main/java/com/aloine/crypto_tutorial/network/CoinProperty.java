package com.aloine.crypto_tutorial.network;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class CoinProperty implements Parcelable {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("rank")
        @Expose
        private String rank;
        @SerializedName("price_usd")
        @Expose
        private String priceUsd;
        @SerializedName("price_btc")
        @Expose
        private String priceBtc;
        @SerializedName("24h_volume_usd")
        @Expose
        private String _24hVolumeUsd;
        @SerializedName("market_cap_usd")
        @Expose
        private String marketCapUsd;
        @SerializedName("available_supply")
        @Expose
        private String availableSupply;
        @SerializedName("total_supply")
        @Expose
        private String totalSupply;
        @SerializedName("max_supply")
        @Expose
        private String maxSupply;
        @SerializedName("percent_change_1h")
        @Expose
        private String percentChange1h;
        @SerializedName("percent_change_24h")
        @Expose
        private String percentChange24h;
        @SerializedName("percent_change_7d")
        @Expose
        private String percentChange7d;
        @SerializedName("last_updated")
        @Expose
        private String lastUpdated;

        protected CoinProperty(Parcel in) {
            id = in.readString();
            name = in.readString();
            symbol = in.readString();
            rank = in.readString();
            priceUsd = in.readString();
            priceBtc = in.readString();
            _24hVolumeUsd = in.readString();
            marketCapUsd = in.readString();
            availableSupply = in.readString();
            totalSupply = in.readString();
            maxSupply = in.readString();
            percentChange1h = in.readString();
            percentChange24h = in.readString();
            percentChange7d = in.readString();
            lastUpdated = in.readString();
        }

        public static final Creator<CoinProperty> CREATOR = new Creator<CoinProperty>() {
            @Override
            public CoinProperty createFromParcel(Parcel in) {
                return new CoinProperty(in);
            }

            @Override
            public CoinProperty[] newArray(int size) {
                return new CoinProperty[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getPriceUsd() {
            return priceUsd;
        }

        public void setPriceUsd(String priceUsd) {
            this.priceUsd = priceUsd;
        }

        public String getPriceBtc() {
            return priceBtc;
        }

        public void setPriceBtc(String priceBtc) {
            this.priceBtc = priceBtc;
        }

        public String get24hVolumeUsd() {
            return _24hVolumeUsd;
        }

        public void set24hVolumeUsd(String _24hVolumeUsd) {
            this._24hVolumeUsd = _24hVolumeUsd;
        }

        public String getMarketCapUsd() {
            return marketCapUsd;
        }

        public void setMarketCapUsd(String marketCapUsd) {
            this.marketCapUsd = marketCapUsd;
        }

        public String getAvailableSupply() {
            return availableSupply;
        }

        public void setAvailableSupply(String availableSupply) {
            this.availableSupply = availableSupply;
        }

        public String getTotalSupply() {
            return totalSupply;
        }

        public void setTotalSupply(String totalSupply) {
            this.totalSupply = totalSupply;
        }

        public String getMaxSupply() {
            return maxSupply;
        }

        public void setMaxSupply(String maxSupply) {
            this.maxSupply = maxSupply;
        }

        public String getPercentChange1h() {
            return percentChange1h;
        }

        public void setPercentChange1h(String percentChange1h) {
            this.percentChange1h = percentChange1h;
        }

        public String getPercentChange24h() {
            return percentChange24h;
        }

        public void setPercentChange24h(String percentChange24h) {
            this.percentChange24h = percentChange24h;
        }

        public String getPercentChange7d() {
            return percentChange7d;
        }

        public void setPercentChange7d(String percentChange7d) {
            this.percentChange7d = percentChange7d;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(symbol);
            dest.writeString(rank);
            dest.writeString(priceUsd);
            dest.writeString(priceBtc);
            dest.writeString(_24hVolumeUsd);
            dest.writeString(marketCapUsd);
            dest.writeString(availableSupply);
            dest.writeString(totalSupply);
            dest.writeString(maxSupply);
            dest.writeString(percentChange1h);
            dest.writeString(percentChange24h);
            dest.writeString(percentChange7d);
            dest.writeString(lastUpdated);
        }
    }

