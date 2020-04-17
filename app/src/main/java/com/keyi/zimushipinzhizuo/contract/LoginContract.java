package com.keyi.zimushipinzhizuo.contract;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Model.IModel;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.keyi.zimushipinzhizuo.bean.AppEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface LoginContract {
    interface LoginIView extends IView {
        void codeSuccess(BaseEntity<AppEntity> entity);

        void codeError(String error);

        void loginSuccess(BaseEntity<AppEntity> entity);

        void loginError(String entity);
    }

    interface LoginIModel extends IModel {
        Observable<BaseEntity<AppEntity>> code_request(RequestBody body);

        Observable<BaseEntity<AppEntity>> login_request(RequestBody body);
    }
}
