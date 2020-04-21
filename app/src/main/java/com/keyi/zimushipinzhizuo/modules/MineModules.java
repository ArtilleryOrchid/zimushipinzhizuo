package com.keyi.zimushipinzhizuo.modules;

import com.keyi.zimushipinzhizuo.contract.MineContract;
import com.keyi.zimushipinzhizuo.model.MineModel;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class MineModules {
    MineContract.MineIView iView;

    @Inject
    public MineModules(MineContract.MineIView iView) {
        this.iView = iView;
    }

    @Provides
    public MineContract.MineIView providerIView() {
        return iView;
    }

    @Provides
    public MineContract.MineIModel providerIModel() {
        return new MineModel();
    }
}
