package com.edu.fragmentlayout;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends android.support.v4.app.Fragment {
//    private RecyclerView mrecyclerView;
//    private myAdaputer myadaputer;
    private Context context;
    private List list;
    private View messageLayout;

//    private myAdaputer myadaputer;
//    private RecyclerView recyclerView;
//    private List<Bean.Datas> arrayList=new ArrayList<>();
//    private String ur="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         messageLayout = inflater.inflate(R.layout.fragment_message, container, false);
         context = this.context;
        initRecyclerView();

        return messageLayout;
    }

    public void initRecyclerView() {




    }



}
