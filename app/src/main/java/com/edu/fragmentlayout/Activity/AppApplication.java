package com.edu.fragmentlayout.Activity;

import android.app.Application;

import com.edu.fragmentlayout.BeanClass.DataBean;

import java.util.ArrayList;
import java.util.List;

public class AppApplication extends Application {

    private static List<DataBean> dataBeanList=new ArrayList<>();
    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
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
}
