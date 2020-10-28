package com.edu.fragmentlayout;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends android.support.v4.app.Fragment {
    private   String TAG = "NewFragment";
    private myAdaputer myadaputer;
//    public myAdaputer myadaputer = new myAdaputer();
    private RecyclerView recyclerView;

    private Context context;
    private Bean bean;
//    private List<Bean.Datas> arrayList = new ArrayList<>();//是食材的url
    private List<Bean.ResultBean> datas = new ArrayList<>();
    private View NewLayout;
    private String ur="https://api.apiopen.top/getWangYiNews?page=1&count=5";


    public NewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         NewLayout = inflater.inflate(R.layout.fragment_new, container, false);
        initview();

 Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Contant.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        IRetrofitService iRetrofitService = retrofit.create(IRetrofitService.class);
        Call<Bean> call = iRetrofitService.getUrl(ur);
//        Call<Bean> call = iRetrofitService.getUrl(ur);
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean bean = response.body();
                datas.addAll(bean.getResult());
                myadaputer.refrest(datas);
//                Log.d(TAG,"看看"+response);
//                    Bean bean = response.body();
//                    arrayList.addAll(bean.getData());
//                Log.d(TAG,"看看1"+arrayList);
//                    Log.d(TAG,"看看2"+bean);
//                    myadaputer.refrest(arrayList);


            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                Log.d("TAG","看看2"+t);
            }
        });
        return NewLayout;
    }

    private void initview() {
        recyclerView = (RecyclerView)NewLayout.findViewById(R.id.collect_recyclerView);//找到对应的滚动控件
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());//设置一个管理器；
        manager.setOrientation(LinearLayoutManager.VERTICAL);//设置管理方向为垂直
        recyclerView.setLayoutManager(manager);
        myadaputer=new myAdaputer(getActivity(),datas);
        recyclerView.setAdapter(myadaputer);
    }

}
