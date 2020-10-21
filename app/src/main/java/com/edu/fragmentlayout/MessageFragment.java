package com.edu.fragmentlayout;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends android.support.v4.app.Fragment {
    private RecyclerView mrecyclerView;
    private myAdaputer myadaputer;
    private Context context;
    private List list;
    private View messageLayout;
    private ArrayList<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         messageLayout = inflater.inflate(R.layout.fragment_message, container, false);
         context = this.context;
        initDate();
        initRecyclerView();
        return messageLayout;
    }

    private void initRecyclerView() {
//        recyclerView = findViewById(R.id.recycler_view);

        mrecyclerView=(RecyclerView)messageLayout.findViewById(R.id.collect_recyclerView);
        myadaputer = new myAdaputer(getActivity(),goodsEntityList);
        mrecyclerView.setAdapter(myadaputer);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        mrecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
//        LinearLayoutManager manager = new LinearLayoutManager(context);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);




    }

    private void initDate() {

        for (int i=0;i<30;i++){
            GoodsEntity goodsEntity=new GoodsEntity();
            goodsEntity.setGoodsName("模拟数据"+i);
            goodsEntity.setGoodsPrice("100"+i);
            goodsEntityList.add(goodsEntity);
        }

    }

}
