package com.edu.fragmentlayout.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.fragmentlayout.BeanClass.DataBean;
import com.edu.fragmentlayout.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class GouWuCheAdapter extends RecyclerView.Adapter<GouWuCheAdapter.GwcViewHolder> {

    private List<DataBean> dataBeanList;
    private Context context;



    public GouWuCheAdapter(Context context,List<DataBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }




    @NonNull
    @Override
    public GwcViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_gou_wuche_item,viewGroup,false);
        GwcViewHolder gwcViewHolder = new GwcViewHolder(inflate);
        return gwcViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GwcViewHolder gwcViewHolder, int i) {
       gwcViewHolder.price.setText(dataBeanList.get(i).getPid());
       gwcViewHolder.total.setText(dataBeanList.get(i).getCid());
       gwcViewHolder.time.setText(dataBeanList.get(i).getC_t());
        Picasso.with(context).load(dataBeanList.get(i).getUrl()).into(gwcViewHolder.img);


    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public class GwcViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView price,total,time;

        public GwcViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_pic);
            price=itemView.findViewById(R.id.item_price);
            total = itemView.findViewById(R.id.item_spec);
            time = itemView.findViewById(R.id.item_name);
        }
    }


}
