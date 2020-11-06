package com.edu.fragmentlayout.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.fragmentlayout.BeanClass.PictureBean;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntentFragment extends android.support.v4.app.Fragment {
    private Context context;
    private List list;
    private View lntentLayout;

    private com.edu.fragmentlayout.Adapter.pictureAdapter pictureAdapter;
    private RecyclerView picrecyclerView;
//    private List<PictureBean.DataBean> dataBean = new ArrayList<>();
    private String url ="http://wallpaper.apc.360.cn/index.php?c=WallPaperAndroid&a=getAppsByCategory&cid=1&start=0&count=99";


    public IntentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initview();
//        lntentLayout = inflater.inflate(R.layout.fragment_intent, container, false);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Contant_two.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        PictureRetrofitService pictureRetrofitService = retrofit.create(PictureRetrofitService.class);
//        Call<PictureBean> call = pictureRetrofitService.getUrl(url);
//        call.enqueue(new Callback<PictureBean>() {
//            @Override
//            public void onResponse(Call<PictureBean> call, Response<PictureBean> response) {
//                PictureBean bean = response.body();
//                dataBean.addAll(bean.getData());
//                pictureAdapter.refrest(dataBean);
//            }
//            @Override
//            public void onFailure(Call<PictureBean> call, Throwable t) {
//                Log.d(TAG, "onFailure: "+t);
//            }
//        });
        return lntentLayout;
    }

    private void initview() {
//        picrecyclerView = lntentLayout.findViewById(R.id.pictureRecycleview);
//        GridLayoutManager manager = new GridLayoutManager(this.getActivity(),2);
//        manager.setOrientation(GridLayoutManager.DEFAULT_SPAN_COUNT);
//        picrecyclerView.setLayoutManager(manager);
//
//        pictureAdapter = new pictureAdapter(getActivity(),dataBean);
//        picrecyclerView.setAdapter(pictureAdapter);
    }


}
