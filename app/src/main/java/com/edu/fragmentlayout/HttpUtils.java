package com.edu.fragmentlayout;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    public static void get(String ip, Callback callback){
        Request request = new Request.Builder().url(ip).get().build();
    }
}
