package com.dw.mvvmpractoce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycle;
    List<ProductModel> productModels;
    MainViewModel mainViewModel;
    MyAdapter myAdapter;
   // TextView text;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=findViewById(R.id.recycle);
        btn=findViewById(R.id.btn);
        //text=findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,NextActivity.class));
            }
        });

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);

     myAdapter = new MyAdapter(productModels,this);
     recycle.setAdapter(myAdapter);


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getProductlist().observe(this, new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> list) {

                if (list!=null){
                    productModels=list;
                   myAdapter.newUpdate(list);
                  //  text.setVisibility(View.GONE);
                }
                if (list==null){

                   // recycle.setVisibility(View.GONE);
                    //text.setVisibility(View.VISIBLE);
                }

            }
        });
        mainViewModel.makeApicall();
    }



}