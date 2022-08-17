package com.dw.mvvmpractoce;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

 class NextAdapter extends RecyclerView.Adapter<NextAdapter.NextViewHolder>{

    Context context;
    List<Nextmodel> nextmodels;

    public NextAdapter(Context context, List<Nextmodel> nextmodels) {
        this.context = context;
        this.nextmodels = nextmodels;
    }

    public void newUpdate(List<Nextmodel> nextmodels) {
        // this.list.clear();
        this.nextmodels = nextmodels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recycle1,parent,false);
        return new NextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NextViewHolder holder, int position) {

        Nextmodel nextmodel = nextmodels.get(position);
        Log.d("7t4ry847ruy8ter", "ydgouyguodfhogidf"+nextmodel);
        NextAdapter.NextViewHolder vholder= (NextAdapter.NextViewHolder) holder;

        vholder.text.setText(nextmodel.getTitle());
        vholder.text1.setText(nextmodel.getBody());

    }

    @Override
    public int getItemCount() {
        if (this.nextmodels!=null)
            return this.nextmodels.size();
        else
            return 0;

    }

    class NextViewHolder extends RecyclerView.ViewHolder {
        TextView text,text1;
        public NextViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            text1=itemView.findViewById(R.id.text1);
        }
    }
}
