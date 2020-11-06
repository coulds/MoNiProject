package com.edu.fragmentlayout.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.fragmentlayout.BeanClass.FoodBean;
import com.edu.fragmentlayout.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private Context context;
    private List<FoodBean.DataBean> data = new ArrayList<>();


    public FoodAdapter(Context context , List<FoodBean.DataBean> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_one,viewGroup,false);
        FoodAdapter.FoodViewHolder foodViewHolder = new FoodAdapter.FoodViewHolder(inflate);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.food_title.setText(data.get(i).getTitle());
        foodViewHolder.food_id.setText(data.get(i).getId());
        foodViewHolder.food_number.setText(data.get(i).getCollect_num());
        foodViewHolder.food_str.setText(data.get(i).getFood_str());
        Picasso.with(context).load(data.get(i).getPic()).into(foodViewHolder.foodpic);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void refrest(List<FoodBean.DataBean> list){
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView food_title,food_str,food_id,food_number;
        ImageView foodpic;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            food_id = itemView.findViewById(R.id.food_id);
            food_str = itemView.findViewById(R.id.food_str);
            food_title = itemView.findViewById(R.id.food_title);
            foodpic = itemView.findViewById(R.id.food_img);
            food_number = itemView.findViewById(R.id.food_number);
        }
    }
}
