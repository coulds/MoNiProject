package com.edu.fragmentlayout.Interface;

import com.edu.fragmentlayout.BeanClass.PictureBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PictureRetrofitService {
    @GET()
    Call<PictureBean> getUrl(@Url String url);
}
