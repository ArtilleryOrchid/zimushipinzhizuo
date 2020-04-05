package com.keyi.zimushipinzhizuo.model;

import com.huopaolan.lib_core.Http.MResponseManager;
import com.huopaolan.lib_core.Mvp.Model.BaseModel;
import com.keyi.zimushipinzhizuo.api.Contans;
import com.keyi.zimushipinzhizuo.bean.LoginEntity;
import com.keyi.zimushipinzhizuo.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LoginModel extends BaseModel implements LoginContract.LoginIModel {
    @Inject
    public LoginModel() {
    }

    @Override
    public Observable<LoginEntity> login_request(String appName, String mobile) {
        return MResponseManager.obtainRetrofit(Contans.class).login_request(appName, mobile);
    }

    @Override
    public void destroy() {

    }
}
