package com.edu.fragmentlayout.Fragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.fragmentlayout.Adapter.FoodAdapter;
import com.edu.fragmentlayout.BeanClass.FoodBean;
import com.edu.fragmentlayout.Base_Url.Contant_one;
import com.edu.fragmentlayout.Interface.FoodRetrofitService;
import com.edu.fragmentlayout.R;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

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
public class MessageFragment extends android.support.v4.app.Fragment {

    private Context context;
    private List list;
    private View messageLayout;

    private FoodAdapter foodAdapter;
    private RecyclerView recyclerView;
    private List<FoodBean.DataBean> arrayList=new ArrayList<>();
    private String ur="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";





//食材的fragment，第一个fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         messageLayout = inflater.inflate(R.layout.fragment_message, container, false);
         context = this.context;
        initRecyclerView();

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Contant_one.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            FoodRetrofitService foodRetrofitService = retrofit.create(FoodRetrofitService.class);
            Call<FoodBean> call = foodRetrofitService.getUrl(ur);
            call.enqueue(new Callback<FoodBean>() {
                @Override
                public void onResponse(Call<FoodBean> call, Response<FoodBean> response) {
                    FoodBean bean = response.body();
                    arrayList.addAll(bean.getData());
                    foodAdapter.refrest(arrayList);
                    //数据库保存
//                    SQLiteDatabase db = Connector.getDatabase();
//                    DataSupport.deleteAll(FoodBean.class);
//                    DataSupport.saveAll(arrayList);
//                    arrayList.add(new FoodBean.DataBean(1,"123","hahaha","hajaa1","hahah1","ahahha"));
//                    bean.save();
////                    Log.d(TAG, "数据库："+arrayList);
                }

                @Override
                public void onFailure(Call<FoodBean> call, Throwable t) {
                    Log.d(TAG, "看看: "+t);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return messageLayout;
    }

    public void initRecyclerView() {
        recyclerView = (RecyclerView)messageLayout.findViewById(R.id.foodRecycleview);
        LinearLayoutManager manager =new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        foodAdapter=new FoodAdapter(getActivity(),arrayList);
        recyclerView.setAdapter(foodAdapter);

    }



}
