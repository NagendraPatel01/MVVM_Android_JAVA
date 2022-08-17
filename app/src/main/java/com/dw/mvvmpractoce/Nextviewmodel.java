package com.dw.mvvmpractoce;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Nextviewmodel extends ViewModel {

    private MutableLiveData<List<Nextmodel>> nextmodel;

    public Nextviewmodel() {

        nextmodel=new MutableLiveData<>();
    }

    public MutableLiveData<List<Nextmodel>> getNextmodel(){
        return nextmodel;
    }

    public void nextapicall(){

        Myinterface myinterface=RetrofitClint.getRetrofit().create(Myinterface.class);
        Call<List<Nextmodel>> call=myinterface.nextdata();

        call.enqueue(new Callback<List<Nextmodel>>() {
            @Override
            public void onResponse(Call<List<Nextmodel>> call, Response<List<Nextmodel>> response) {

                nextmodel.postValue(response.body());
                Log.d("fhhghfgfgdg", "ytuyuutuyt"+response);

                Log.d("uieruieri", "uity7894yt8r"+response.body());
            }

            @Override
            public void onFailure(Call<List<Nextmodel>> call, Throwable t) {

                Log.d("uhtuieryitu", "udrieryh7ui"+t.getMessage());

            }
        });
    }
}
