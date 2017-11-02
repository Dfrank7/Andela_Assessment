package com.example.dfrank.cryptocurrency.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dfrank on 11/1/17.
 */

public class Client {
    public static final String baseUrl = "https://min-api.cryptocompare.com/data/";
    Retrofit retrofit = null;
    public Retrofit getClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
