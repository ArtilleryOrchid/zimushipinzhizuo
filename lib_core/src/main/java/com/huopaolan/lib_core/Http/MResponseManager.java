package com.huopaolan.lib_core.Http;

import android.util.Log;

/**
 * 网络请求入口:根据请求配置不同RxJava中的被观察者
 * msg:调用APIService类下的retrofit对象发起网络请求
 */
public class MResponseManager {
    //发起网络请求入口
    public static <T> T obtainRetrofit(Class<T> clazz) {
        Log.d("HTTP", "网络请求");
        return APIService.getInstance().getRetrofit().create(clazz);
    }
}
