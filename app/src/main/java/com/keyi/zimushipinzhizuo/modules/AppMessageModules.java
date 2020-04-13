package com.keyi.zimushipinzhizuo.modules;

import com.keyi.zimushipinzhizuo.contract.AppMessageContract;
import com.keyi.zimushipinzhizuo.model.AppMessageModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class AppMessageModules {
    AppMessageContract.AppMessageIView iView;

    @Inject
    public AppMessageModules(AppMessageContract.AppMessageIView iView) {
        this.iView = iView;
    }

    @Provides
    public AppMessageContract.AppMessageIView providerIView() {
        return iView;
    }

    @Provides
    public AppMessageContract.AppMessageIModel providerIModel() {
        return new AppMessageModel();
    }
}
