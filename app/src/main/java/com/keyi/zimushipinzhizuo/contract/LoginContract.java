package com.keyi.zimushipinzhizuo.contract;

import com.huopaolan.lib_core.Mvp.Model.IModel;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.keyi.zimushipinzhizuo.bean.LoginEntity;

import io.reactivex.Observable;

public interface LoginContract {
    interface LoginIView extends IView {
        void loginSuccess(LoginEntity entity);

        void loginError(String error);
    }

    interface LoginIModel extends IModel {
        Observable<LoginEntity> login_request(String appName, String mobile);
    }
}
