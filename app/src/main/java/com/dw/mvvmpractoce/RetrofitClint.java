package com.dw.mvvmpractoce;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

    private  static Retrofit retrofit;

    static Context context;

    public static Retrofit getRetrofit(){

        if (retrofit==null){

            return retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }

        else {

            return retrofit;
        }
    }
}
