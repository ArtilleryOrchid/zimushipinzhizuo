package com.keyi.zimushipinzhizuo.contract;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Model.IModel;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.keyi.zimushipinzhizuo.bean.AppEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface MineContract {
    interface MineIView extends IView {
        void logoutSuccess(BaseEntity<AppEntity> entity);

        void logoutError(String entity);
    }

    interface MineIModel extends IModel {
        Observable<BaseEntity<AppEntity>> logout_request(RequestBody body);
    }
}
