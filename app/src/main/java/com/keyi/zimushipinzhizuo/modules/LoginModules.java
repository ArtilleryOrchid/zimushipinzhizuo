package com.keyi.zimushipinzhizuo.modules;

import com.keyi.zimushipinzhizuo.contract.LoginContract;
import com.keyi.zimushipinzhizuo.model.LoginModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModules {
    LoginContract.LoginIView iView;

    @Inject
    public LoginModules(LoginContract.LoginIView iView) {
        this.iView = iView;
    }

    @Provides
    public LoginContract.LoginIView providerIView() {
        return iView;
    }

    @Provides
    public LoginContract.LoginIModel providerIModel() {
        return new LoginModel();
    }
}
