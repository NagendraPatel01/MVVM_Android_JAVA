package com.dw.mvvmpractoce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Myinterface {

    @GET("posts/1/comments")
    Call<List<ProductModel>> getdata();

    @GET("posts")
    Call<List<Nextmodel>> nextdata();
}
