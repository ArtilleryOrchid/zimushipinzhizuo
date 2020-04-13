package com.keyi.zimushipinzhizuo.api;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.keyi.zimushipinzhizuo.bean.AppEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 测试公共地址
 */
public interface api {
    public static String API = "https://test99.rhinox.cn/";

    /**
     * 登录注册发送验证码
     *
     * @param body
     * @return
     */
    @POST("standard/account/sendVerifyCode")
    Observable<BaseEntity<AppEntity>> login_request(@Body RequestBody body);

    /**
     * 获取APP基础信息
     *
     * @param body
     * @return
     */
    @POST("standard/common/base")
    Observable<BaseEntity<AppEntity>> app_message_request(@Body RequestBody body);
}
