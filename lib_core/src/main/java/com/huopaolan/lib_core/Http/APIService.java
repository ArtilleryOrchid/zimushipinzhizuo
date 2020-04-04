package com.huopaolan.lib_core.Http;

import android.os.Message;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 二次封装OkHttp
 * 二次封装retrofit2
 */
public class APIService {
    private OkHttpClient client;
    private Retrofit retrofit; //基于OkHttp二次封装

    //封装OkHttp
    private void buildOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(1, TimeUnit.MINUTES);
        builder.readTimeout(1, TimeUnit.MINUTES);
        HttpLoggingInterceptor interceptor =
                new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        client = builder.build();
    }

    //封装retrofit
    private void buildRetrofit() {
        if (retrofit == null) {
            //配置
            buildOkHttp();
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.client(client); //添加OkHttpClient对象
            builder.baseUrl("http://169.254.197.176/yoho/");//所有网络请求公共地址部分
            //关联gson
            builder.addConverterFactory(GsonConverterFactory.create());
            //关联rxjava
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            retrofit = builder.build();
        }
    }

    public Retrofit getRetrofit() {
        if (retrofit == null)
            buildRetrofit();
        return retrofit;
    }
    /**
     * 单例 懒汉式
     */
    private void APIService() {

    }

    private static APIService service = null;

    public static APIService getInstance() {
        if (service == null)
            service = new APIService();
        return service;
    }
}
