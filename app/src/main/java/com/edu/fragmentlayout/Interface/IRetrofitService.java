package com.edu.fragmentlayout.Interface;

import com.edu.fragmentlayout.BeanClass.Bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IRetrofitService {
    @GET()
    Call<Bean> getUrl(@Url String url);


}
