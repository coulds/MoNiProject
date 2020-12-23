package com.edu.fragmentlayout.Activity;

import android.app.Application;
import android.content.Context;

import com.edu.fragmentlayout.BeanClass.DataBean;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

import java.util.ArrayList;
import java.util.List;

public class AppApplication extends Application {

    private static List<DataBean> dataBeanList=new ArrayList<>();
    private static Application instance;
    private static Context context;





    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        LitePal.initialize(this);
        instance=this;
    }

    public static Application getInstance() {
        return instance;
    }

    public static List<DataBean> getDataBeanList() {
        return dataBeanList;
    }

    public static void setDataBeanList(DataBean dataBeanList1) {
        dataBeanList .add(dataBeanList1);
    }

    public static Context getContext() {
        return context;
    }


}
