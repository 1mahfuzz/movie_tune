package com.mahfuz.movietune;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mahfuz on 7/1/18.
 */

public class ApiClient{

    public Retrofit getClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
