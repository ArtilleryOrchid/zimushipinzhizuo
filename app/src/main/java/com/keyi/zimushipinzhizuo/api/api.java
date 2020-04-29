package com.keyi.zimushipinzhizuo.api;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.keyi.zimushipinzhizuo.bean.AppEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 测试公共地址
 */
public interface api {
    public static String API = "https://test99.rhinox.cn/";
    public static int ALIPAY = 0;
    public static int WECHAT = 1;

    /**
     * 登录注册发送验证码
     *
     * @param body
     * @return
     */
    @POST("standard/account/sendVerifyCode")
    Observable<BaseEntity<AppEntity>> code_request(@Body RequestBody body);

    /**
     * 登录
     *
     * @param body
     * @return
     */
    @POST("standard/account/login")
    Observable<BaseEntity<AppEntity>> login_request(@Body RequestBody body);

    /**
     * 获取APP基础信息
     *
     * @param body
     * @return
     */
    @POST("standard/common/base")
    Observable<BaseEntity<AppEntity>> app_message_request(@Body RequestBody body);

    /**
     * 退出登录
     *
     * @param body
     * @return
     */
    @POST("/standard/account/logout")
    Observable<BaseEntity<Boolean>> logout_request(@Body RequestBody body);

    /**
     * 创建订单
     *
     * @param body
     * @return
     */
    @POST("/standard/order/create")
    Observable<BaseEntity<String>> create_pay_request(@Body RequestBody body);

    /**
     * 产品信息查询
     *
     * @param body
     * @return
     */
    @POST("/standard/product/productList")
    Observable<BaseEntity<ArrayList<AppEntity.Data>>> product_request(@Body RequestBody body);

    /**
     * 支付类型
     *
     * @param body
     * @return
     */
    @POST("/standard/product/payChannel")
    Observable<BaseEntity<ArrayList<AppEntity.Pay>>> pay_request(@Body RequestBody body);

    /**
     * 支付入口
     *
     * @param body
     * @return
     */
    @POST("/standard/order/submitOrder")
    Observable<BaseEntity<AppEntity.Submit>> submit_request(@Body RequestBody body);
}
