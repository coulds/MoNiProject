package com.edu.fragmentlayout.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.edu.fragmentlayout.Adapter.GouWuCheAdapter;
import com.edu.fragmentlayout.BeanClass.DataBean;
import com.edu.fragmentlayout.R;

import java.util.ArrayList;
import java.util.List;

public class GouWuCheActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GouWuCheAdapter gouWuCheAdapter;
    private List<DataBean> dataBeanList = new ArrayList<>();

//    DataBean dataBean;
//    List<DataBean> dataList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che);

        Bundle bundle = this.getIntent().getExtras();

//        String time = bundle.getString("time");
//        String pid = bundle.getString("pid");
//        String cid= bundle.getString("cid");
//        String total = bundle.getString("total");
//        String img = bundle.getString("img");
//        dataBean=(DataBean) bundle.getSerializable("dataTo");

//        dataList.add(dataBean);

        List<DataBean> dataBeanList = AppApplication.getDataBeanList();

        Log.e("0000000>",dataBeanList.toString());

        initView();

    }

    private void initView() {

        recyclerView = (RecyclerView)findViewById(R.id.gwc_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        dataBeanList.addAll(AppApplication.getDataBeanList());
        gouWuCheAdapter = new GouWuCheAdapter(this,dataBeanList);
        recyclerView.setAdapter(gouWuCheAdapter);
    }
}
