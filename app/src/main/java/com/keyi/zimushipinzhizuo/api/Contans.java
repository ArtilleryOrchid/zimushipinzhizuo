package com.keyi.zimushipinzhizuo.api;

import com.keyi.zimushipinzhizuo.bean.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 测试公共地址
 */
public interface Contans {
    public static String API = "https://test99.rhinox.cn/standard/account/bindEmail";

    /**
     * 登录注册发送验证码
     */
    @FormUrlEncoded
    @POST("standard/account/sendVerifyCode")
    Observable<LoginEntity> login_request(@Field("appName") String appName, @Field("mobile") String mobile);
}
