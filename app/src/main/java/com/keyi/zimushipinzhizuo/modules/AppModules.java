package com.keyi.zimushipinzhizuo.modules;

import com.keyi.zimushipinzhizuo.contract.AppContract;
import com.keyi.zimushipinzhizuo.model.AppModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModules {
    private AppContract.AppIView iView;
    private AppContract.ProductIView productIView;

    @Inject
    public AppModules(AppContract.AppIView iView, AppContract.ProductIView productIView) {
        this.iView = iView;
        this.productIView = productIView;
    }

    @Provides
    public AppContract.AppIView providerIView() {
        return iView;
    }

    @Provides
    public AppContract.ProductIView providerProductIView() {
        return productIView;
    }

    @Provides
    public AppContract.AppIModel providerIModel() {
        return new AppModel();
    }
}
