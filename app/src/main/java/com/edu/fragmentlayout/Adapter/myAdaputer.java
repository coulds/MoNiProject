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

import com.edu.fragmentlayout.BeanClass.Bean;
import com.edu.fragmentlayout.R;
import com.edu.fragmentlayout.Activity.testActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class myAdaputer extends RecyclerView.Adapter<myAdaputer.MyViewHolder>{
    private Context context;
    private String datattile,datapath,dataimg,datatime;
//    private OnItemClickListener onItemClickListener;//定义一个接口
//    private List<Bean.Datas> data = new ArrayList<>(); //食材的数据
    private List<Bean.ResultBean> datas = new ArrayList<>();

//    public interface OnItemClickListener {
//        void onItemClick(View view, int position);
//
//    }
//    public void setOnItemClickListener(OnItemClickListener ClickListener){
//        this.onItemClickListener = ClickListener;
//    }

    public myAdaputer(Context context , List<Bean.ResultBean> datas){
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int position) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {

        myViewHolder.time.setText(datas.get(position).getPasstime());
        Picasso.with(context).load(datas.get(position).getImage()).into(myViewHolder.goodsimg);
        myViewHolder.title.setText(datas.get(position).getTitle());
        myViewHolder.path.setText(datas.get(position).getPath());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,testActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("time",datas.get(position).getPasstime());
                bundle.putString("img",datas.get(position).getImage());
                bundle.putString("path",datas.get(position).getPath());
//                bundle.putParcelable("img",datas.get(position).getImage());
                bundle.putString("title",datas.get(position).getTitle());

                intent.putExtras(bundle);
//                Toast.makeText(context,"position"+position+ " ---你点击了这一行"+datas.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

//        myViewHolder.time.setText(data.get(position).getPathtime());
//        Picasso.with(context).load(data.get(position).getImage()).into(myViewHolder.goodsimg);
//        myViewHolder.title.setText(data.get(position).getTitle());
//        myViewHolder.path.setText(data.get(position).getTime());


//        myViewHolder.time.setText(data.get(position).getId());
//        Picasso.with(context).load(data.get(position).getPic()).into(myViewHolder.goodsimg);
//        myViewHolder.title.setText(data.get(position).getTitle());
//        myViewHolder.path.setText(data.get(position).getCollect_num());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    public void refrest(List<Bean.ResultBean> list){
        this.datas.addAll(list);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView time,title,path;
        ImageView goodsimg;
        ConstraintLayout constraintLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.goods_title);
            time = (TextView) itemView.findViewById(R.id.goods_time);
            goodsimg = (ImageView) itemView.findViewById(R.id.goods_img);
            path = (TextView) itemView.findViewById(R.id.goods_path);

        }
    }

}
