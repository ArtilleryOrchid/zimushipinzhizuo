package com.keyi.zimushipinzhizuo.model;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Http.MResponseManager;
import com.keyi.zimushipinzhizuo.api.api;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.AppMessageContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public class AppMessageModel implements AppMessageContract.AppMessageIModel {
    @Inject
    public AppMessageModel() {
    }

    @Override
    public Observable<BaseEntity<AppEntity>> app_message_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).app_message_request(body);
    }

    @Override
    public void destroy() {

    }
}
