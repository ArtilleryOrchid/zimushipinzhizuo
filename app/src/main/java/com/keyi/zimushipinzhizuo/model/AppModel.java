package com.keyi.zimushipinzhizuo.model;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Http.MResponseManager;
import com.huopaolan.lib_core.Mvp.Model.BaseModel;
import com.keyi.zimushipinzhizuo.api.api;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.AppContract;

import java.util.ArrayList;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public class AppModel extends BaseModel implements AppContract.AppIModel {
    @Override
    public Observable<BaseEntity<AppEntity>> app_message_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).app_message_request(body);
    }

    @Override
    public Observable<BaseEntity<AppEntity>> code_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).code_request(body);
    }

    @Override
    public Observable<BaseEntity<AppEntity>> login_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).login_request(body);
    }

    @Override
    public Observable<BaseEntity<Boolean>> logout_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).logout_request(body);
    }

    @Override
    public Observable<BaseEntity<String>> create_pay_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).create_pay_request(body);
    }

    @Override
    public Observable<BaseEntity<ArrayList<AppEntity.Data>>> product_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).product_request(body);
    }

    @Override
    public Observable<BaseEntity<ArrayList<AppEntity.Pay>>> pay_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).pay_request(body);
    }

    @Override
    public Observable<BaseEntity<AppEntity.Submit>> submit_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).submit_request(body);
    }

    @Override
    public void destroy() {

    }
}
