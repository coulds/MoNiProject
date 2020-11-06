package com.edu.fragmentlayout.Interface;

import com.edu.fragmentlayout.BeanClass.FoodBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FoodRetrofitService {
    @GET()
    Call<FoodBean> getUrl(@Url String url);
}
