package com.edu.fragmentlayout.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.edu.fragmentlayout.BeanClass.DataBean;

import com.edu.fragmentlayout.Activity.FengjingActivity;
import com.edu.fragmentlayout.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class pictureAdapter extends RecyclerView.Adapter<pictureAdapter.picViewHolder> {

    private Context context;
    private List<DataBean> data = new ArrayList<>();

    public pictureAdapter(Context context , List<DataBean> data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public pictureAdapter.picViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_two,viewGroup,false);
        pictureAdapter.picViewHolder picviewHolder = new pictureAdapter.picViewHolder(inflate);
        return picviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull pictureAdapter.picViewHolder picViewHolder, final int i) {
        picViewHolder.pic_total.setText(data.get(i).getPid());
//        Picasso.with(context).load(data.get(i).getUrl()).into(picViewHolder.pic_img);
        Glide.with(context)
                .load(data.get(i).getUrl())
                .animate(android.R.anim.slide_in_left)
                .placeholder(R.drawable.loading)
                .error(R.drawable.nodata)
                .into(picViewHolder.pic_img);
        picViewHolder.pic_data.setText(data.get(i).getFav_total());
        picViewHolder.pic_cid.setText(data.get(i).getCid());
        picViewHolder.pic_number.setText(data.get(i).getC_t());

        picViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FengjingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data",data.get(i));
//                bundle.putString("pid",data.get(i).getPid());
//                bundle.putString("total",data.get(i).getFav_total());
//                bundle.putString("cid",data.get(i).getCid());
//                bundle.putString("time",data.get(i).getC_t());
//                bundle.putString("img",data.get(i).getUrl());
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void refrest(List<DataBean> list){
        this.data.addAll(list);
        notifyDataSetChanged();
    }
    class picViewHolder extends RecyclerView.ViewHolder{
        TextView pic_data,pic_cid,pic_number,pic_total;
        ImageView pic_img;
        ConstraintLayout constraintLayout;
        public picViewHolder(View itemView) {
            super(itemView);
            pic_total = (TextView) itemView.findViewById(R.id.pic_total);
            pic_cid= (TextView) itemView.findViewById(R.id.pic_cid);
            pic_img = (ImageView) itemView.findViewById(R.id.pic_img);
            pic_number = (TextView) itemView.findViewById(R.id.pic_number);
            pic_data = itemView.findViewById(R.id.pic_data);

        }
    }


}
