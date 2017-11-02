package com.example.dfrank.cryptocurrency.api;

import com.example.dfrank.cryptocurrency.model.BTC;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dfrank on 11/1/17.
 */

public interface Service {
    @GET("price?fsym=BTC&tsyms=USD,XAF,CAD,AFN,ALL,COP,EGP,DKK,KRW,ZAR,SAR,JPY,ARS,BRL,CNY,HKD,GBP,GHS,EUR,NGN")
    Call<BTC> getCurrency();

    @GET("price?fsym=ETH&tsyms=USD,XAF,CAD,AFN,ALL,COP,EGP,DKK,KRW,ZAR,SAR,JPY,ARS,BRL,CNY,HKD,GBP,GHS,EUR,NGN")
    Call<BTC> getEtherum();

}
