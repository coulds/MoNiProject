package com.edu.fragmentlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class myAdaputer extends RecyclerView.Adapter<myAdaputer.MyViewHolder> {
    private Context context;
//    private View itemView,inflate;
    private List<String> list;

    private ArrayList<GoodsEntity> goodsEntityList;


    public myAdaputer(Context context , ArrayList<GoodsEntity> goodsEntityList){
        this.context = context;
        this.goodsEntityList = goodsEntityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        inflate = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

//        View itemView = View.inflate(context, R.layout.item, null);
        View itemView = View.inflate(context, R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
//        myViewHolder.textView.setText(list.get(position));
        GoodsEntity data = goodsEntityList.get(position);
    }

    @Override
    public int getItemCount() {
        return goodsEntityList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
                ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.test_view);
            imageView = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }

}
