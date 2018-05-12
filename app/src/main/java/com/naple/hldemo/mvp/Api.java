package com.naple.hldemo.mvp;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * created by hl at 2018/5/12
 * com.naple.hldemo.mvp
 */
public class Api {


    static OkHttpClient client = new OkHttpClient.Builder().
            retryOnConnectionFailure(true).
            connectTimeout(5, TimeUnit.SECONDS).
            readTimeout(10, TimeUnit.SECONDS).
            writeTimeout(10, TimeUnit.SECONDS).
            addNetworkInterceptor(new StethoInterceptor()).
            build();

    public static String baseUrl = "https://api.douban.com/v2/movie/";

    public static ApiService apiService;
    //单例
    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
