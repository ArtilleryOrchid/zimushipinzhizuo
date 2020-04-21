package com.keyi.zimushipinzhizuo.model;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Http.MResponseManager;
import com.huopaolan.lib_core.Mvp.Model.BaseModel;
import com.keyi.zimushipinzhizuo.api.api;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.MineContract;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public class MineModel extends BaseModel implements MineContract.MineIModel {
    @Inject
    public MineModel() {
    }

    @Override
    public Observable<BaseEntity<AppEntity>> logout_request(RequestBody body) {
        return MResponseManager.obtainRetrofit(api.class).logout_request(body);
    }

    @Override
    public void destroy() {

    }
}
