package com.keyi.zimushipinzhizuo.model;

import com.huopaolan.lib_core.Http.MResponseManager;
import com.huopaolan.lib_core.Mvp.Model.BaseModel;
import com.keyi.zimushipinzhizuo.api.api;
import com.keyi.zimushipinzhizuo.bean.LoginEntity;
import com.keyi.zimushipinzhizuo.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public class LoginModel extends BaseModel implements LoginContract.LoginIModel {
    @Inject
    public LoginModel() {
    }

    @Override
    public Observable<LoginEntity> login_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).login_request(body);
    }

    @Override
    public void destroy() {

    }
}
