package com.keyi.zimushipinzhizuo.presenter;

import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.contract.LoginContract;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginContract.LoginIView, LoginContract.LoginIModel> {
    @Inject
    public LoginPresenter(LoginContract.LoginIView loginIView, LoginContract.LoginIModel loginIModel) {
        super(loginIView, loginIModel);
    }

    public void loginRequest(String appName, String mobile) {

    }
}
