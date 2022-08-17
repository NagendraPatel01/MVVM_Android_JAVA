package com.dw.mvvmpractoce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class NextActivity extends AppCompatActivity {

    RecyclerView recycle;
    List<Nextmodel> nextmodels;
    Nextviewmodel nextviewmodel;
    NextAdapter nextAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        recycle=findViewById(R.id.recycle);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(NextActivity.this,RecyclerView.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);

        nextAdapter = new NextAdapter(this,nextmodels);
        Log.d("eutedyiuiuiyi", "yrtgyetuweyu8"+nextAdapter);
        recycle.setAdapter(nextAdapter);

        nextviewmodel = ViewModelProviders.of(this).get(Nextviewmodel.class);
        nextviewmodel.getNextmodel().observe(this, new Observer<List<Nextmodel>>() {
            @Override
            public void onChanged(List<Nextmodel> list) {

                if (list!=null){
                    nextmodels=list;
                    nextAdapter.newUpdate(list);
                    //  text.setVisibility(View.GONE);
                }
                if (list==null){

                    // recycle.setVisibility(View.GONE);
                    //text.setVisibility(View.VISIBLE);
                }

            }
        });
        nextviewmodel.nextapicall();
    }
}