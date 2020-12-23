package com.edu.fragmentlayout.Fragment;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edu.fragmentlayout.Activity.AppApplication;
import com.edu.fragmentlayout.Activity.GouWuCheActivity;
import com.edu.fragmentlayout.Activity.LocalImageLoader;
import com.edu.fragmentlayout.Activity.MainActivity;
import com.edu.fragmentlayout.Adapter.pictureAdapter;
import com.edu.fragmentlayout.BeanClass.DataBean;
import com.edu.fragmentlayout.BeanClass.PictureBean;
import com.edu.fragmentlayout.Base_Url.Contant_two;
import com.edu.fragmentlayout.Interface.PictureRetrofitService;
import com.edu.fragmentlayout.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import android.support.v7.app.ActionBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.nostra13.universalimageloader.core.ImageLoader.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private Banner fjbanner;
    private LocalImageLoader mImageLoader;
    private ArrayList<String> imagepath;
    private ArrayList<String> imagetitle;


    private ImageView menu,tongzhi_img;
    private NavigationView navigationView;
    private Toolbar fengjingtoolbar;
    private DrawerLayout mdrawerLayout;
    private SwipeRefreshLayout swipeRefreshLayout;


    private View SetLayout;
    private Boolean isrefresh = false;
    private com.edu.fragmentlayout.Adapter.pictureAdapter pictureAdapter;
    private RecyclerView recyclerView;
    private PictureBean bean;
    private List<DataBean> dataBean = new ArrayList<>();
    private String url ="http://wallpaper.apc.360.cn/index.php?c=WallPaperAndroid&a=getAppsByCategory&cid=1&start=0&count=99";


    public SetFragment() {
        // Required empty public constructor
    }

    //风景的fragment，第三个页面
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SetLayout = inflater.inflate(R.layout.fragment_set, container, false);
//       Toolbar toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar=getActivity().getSupportActionBar();
//        if(actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.t4);
//        }

        initview();//初始化
        setSwipeRefreshLayout();//下拉刷新
        onpeNavigationView();//控制侧边菜单
        menuItemonClick();//标题栏溢出菜单item点击事件
        initDatafengjingBanner();
        initfengjingbanner();
        NetData();//获取网络数据

        return SetLayout;

    }

    private void initfengjingbanner() {
        fjbanner = SetLayout.findViewById(R.id.fengjingbanner);
        mImageLoader = new LocalImageLoader();

        fjbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        fjbanner.setImageLoader(mImageLoader);
        fjbanner.setBannerAnimation(Transformer.Default);
        fjbanner.setBannerTitles(imagetitle);
        fjbanner.setImages(imagepath);
        fjbanner.setDelayTime(3000);
        fjbanner.isAutoPlay(true);
        fjbanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        fjbanner.start();
        fjbanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(AppApplication.getContext(),"你点击了"+position+"行",Toast.LENGTH_SHORT);
            }
        });


    }

    private void initDatafengjingBanner() {
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


    private void menuItemonClick() {
        fengjingtoolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void onpeNavigationView() {
        fengjingtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdrawerLayout.openDrawer(GravityCompat.START);
                if (mdrawerLayout.isDrawerOpen(navigationView)){
                    mdrawerLayout.closeDrawer(navigationView);
                }else {
                    mdrawerLayout.openDrawer(navigationView);
                }
            }
        });
    }

    private void initview() {
            recyclerView =(RecyclerView)SetLayout.findViewById(R.id.pic_recycleview);
        fengjingtoolbar = (android.support.v7.widget.Toolbar)SetLayout.findViewById(R.id.toolbar);
        fengjingtoolbar.inflateMenu(R.menu.toolbar);//标题

            GridLayoutManager manager = new GridLayoutManager(this.getActivity(),2);
            manager.setOrientation(GridLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(manager);
            pictureAdapter = new pictureAdapter(getActivity(),dataBean);
            recyclerView.setAdapter(pictureAdapter);

        navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);//侧边栏
//        menu = (ImageView)SetLayout.findViewById(R.id.caidan);
        mdrawerLayout = (DrawerLayout)getActivity().findViewById(R.id.dl_drawerlayout);
//        tongzhi_img = (ImageView)SetLayout.findViewById(R.id.tongzhi);
//        tongzhi_img.setOnClickListener(this);
//        menu.setOnClickListener(this);
        }
        private void setSwipeRefreshLayout(){
        swipeRefreshLayout = (SwipeRefreshLayout) SetLayout.findViewById(R.id.sw_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataBean.clear();
                        NetData();
                        pictureAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);

            }
        });
        }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.caidan:
//                mdrawerLayout.openDrawer(GravityCompat.START);
//                if (mdrawerLayout.isDrawerOpen(navigationView)){
//                    mdrawerLayout.closeDrawer(navigationView);
//                }else {
//                    mdrawerLayout.openDrawer(navigationView);
//                }
//                break;
//            case R.id.tongzhi:
//                Toast.makeText(getActivity(),"暂时还没有事情通知哦！！！",Toast.LENGTH_LONG).show();
//        }

    }
    private void NetData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contant_two.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PictureRetrofitService pictureRetrofitService = retrofit.create(PictureRetrofitService.class);
        Call<PictureBean> call = pictureRetrofitService.getUrl(url);
        call.enqueue(new Callback<PictureBean>() {
            @Override
            public void onResponse(Call<PictureBean> call, Response<PictureBean> response) {
                PictureBean bean = response.body();
                Log.d(TAG, "看看"+bean);
                dataBean.addAll(bean.getData());
                pictureAdapter.refrest(dataBean);
            }
            @Override
            public void onFailure(Call<PictureBean> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });
    }


}


