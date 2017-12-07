package com.codekul.sonal.retrofit.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sonal on 6/12/17.
 */

public class RetrofitClient {
    private static Retrofit retrofit;

    public RetrofitClient() {
    }

    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
