package com.edu.fragmentlayout.Fragment;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.edu.fragmentlayout.Activity.AppApplication;
import com.edu.fragmentlayout.Activity.LocalImageLoader;
import com.edu.fragmentlayout.Adapter.myAdaputer;
import com.edu.fragmentlayout.BeanClass.Bean;
import com.edu.fragmentlayout.Base_Url.Contant;
import com.edu.fragmentlayout.Interface.IRetrofitService;
import com.edu.fragmentlayout.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.lang.reflect.Method;
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
public class NewFragment extends android.support.v4.app.Fragment {
    private Banner banner;
    private LocalImageLoader mImageLoader;
   private ArrayList<String> imagepath;
    private ArrayList<String> imagetitle;



    private   String TAG = "NewFragment";
    private myAdaputer myadaputer;
//    public myAdaputer myadaputer = new myAdaputer();
    private RecyclerView recyclerView;

    private android.support.v7.widget.Toolbar toolbar;
    private Context context;
    private Bean bean;
//    private List<Bean.Datas> arrayList = new ArrayList<>();//是食材的url
    private List<Bean.ResultBean> datas = new ArrayList<>();//测试的网址
    private View NewLayout;
    private String ur="https://api.apiopen.top/getWangYiNews?page=1&count=5";


    public NewFragment() {
        // Required empty public constructor
    }
//新闻的页面，第二个fragment




    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         NewLayout = inflater.inflate(R.layout.fragment_new, container, false);
        initview();
        initDataBanner();
        initbanner();
        NetAPI();
        onClick();

        return NewLayout;
    }

    private void initDataBanner() {
        imagepath = new ArrayList<>();
        imagetitle = new ArrayList<>();

        imagepath.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        imagepath.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        imagepath.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        imagepath.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

       imagetitle.add("1");
       imagetitle.add("2");
       imagetitle.add("3");
       imagetitle.add("4");


    }

    private void initbanner() {
        banner = NewLayout.findViewById(R.id.mbanner);
        mImageLoader = new LocalImageLoader();

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(mImageLoader);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(imagetitle);
        banner.setImages(imagepath);
        banner.setDelayTime(3000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(AppApplication.getContext(),"你点击了"+position+"行",Toast.LENGTH_SHORT);
            }
        });


    }

    private void onClick() {
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_settings:
                        Toast.makeText(getActivity(),"设置功能暂时没有开通",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_sousuo:
                        Toast.makeText(getActivity(),"搜索功能暂时没有开通",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_qianbao:
                        Toast.makeText(getActivity(),"钱包暂时没有开通",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_youhui:
                        Toast.makeText(getActivity(),"优惠劵功能暂时没有开通",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

    }

    private void NetAPI() {
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
            }
            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                Log.d("TAG","看看2"+t);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initview() {
        toolbar = (android.support.v7.widget.Toolbar)NewLayout.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar);//标题
//        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.sezhi_white));//设置溢出图标滴，变成自己想要的图标

        recyclerView = (RecyclerView)NewLayout.findViewById(R.id.collect_recyclerView);//找到对应的滚动控件
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());//设置一个管理器；
        manager.setOrientation(LinearLayoutManager.VERTICAL);//设置管理方向为垂直
        recyclerView.setLayoutManager(manager);
        myadaputer=new myAdaputer(getActivity(),datas);
        recyclerView.setAdapter(myadaputer);
    }









}
