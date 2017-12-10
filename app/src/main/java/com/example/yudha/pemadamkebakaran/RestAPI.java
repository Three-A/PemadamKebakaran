package com.example.yudha.pemadamkebakaran;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yudha on 12/2/2017.
 */

public class RestAPI {
    final static String BASE_URL = "http://api.jakarta.go.id/";

    public static Retrofit getAPI(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiInterface getApiInterface(){
        return getAPI().create(ApiInterface.class);
    }
}
