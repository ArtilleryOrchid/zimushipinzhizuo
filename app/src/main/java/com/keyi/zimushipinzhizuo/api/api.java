package com.keyi.zimushipinzhizuo.api;

import com.keyi.zimushipinzhizuo.bean.LoginEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 测试公共地址
 */
public interface api {
    public static String API = "https://test99.rhinox.cn/";

    /**
     * 登录注册发送验证码
     */
    @POST("standard/account/sendVerifyCode")
    Observable<LoginEntity> login_request(@Body RequestBody body);
}
