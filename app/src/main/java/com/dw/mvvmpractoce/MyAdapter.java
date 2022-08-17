package com.dw.mvvmpractoce;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ProductModel> list;
    Context context;

    public MyAdapter(List<ProductModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void newUpdate(List<ProductModel> list) {
       // this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recycle1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ProductModel productModel = list.get(position);
        Log.d("7t4ry847ruy8ter", "ydgouyguodfhogidf"+productModel);
        ViewHolder vholder= (ViewHolder) holder;

        vholder.text.setText(productModel.getName());
        vholder.text1.setText(productModel.getEmail());

    }


    @Override
    public int getItemCount() {
       if (this.list!=null)
           return this.list.size();
       else
           return 0;

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text,text1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            text1=itemView.findViewById(R.id.text1);
        }
    }
}
