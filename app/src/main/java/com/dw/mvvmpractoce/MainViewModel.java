package com.dw.mvvmpractoce;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<ProductModel>> productlist;

    public MainViewModel() {
        productlist=new MutableLiveData<>();

    }
    public MutableLiveData<List<ProductModel>> getProductlist(){
        return productlist;
    }


    public void makeApicall(){

        Myinterface myinterface=RetrofitClint.getRetrofit().create(Myinterface.class);
        Call<List<ProductModel>> call=myinterface.getdata();

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {

                productlist.postValue(response.body());

                Log.d("ghughughioer", "uiryry8ry9u8er"+response.body());
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

                Log.d("ghughughioer", "uiryry8ry9u8er"+t.getMessage());

            }
        });
    }



}
