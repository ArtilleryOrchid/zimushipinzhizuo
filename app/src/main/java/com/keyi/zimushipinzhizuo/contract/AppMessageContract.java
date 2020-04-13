package com.keyi.zimushipinzhizuo.contract;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Model.IModel;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.keyi.zimushipinzhizuo.bean.AppEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface AppMessageContract {
    interface AppMessageIView extends IView {
        void AppMessageSuccess(BaseEntity<AppEntity> entity);

        void AppMessageError(String error);
    }

    interface AppMessageIModel extends IModel {
        Observable<BaseEntity<AppEntity>> app_message_request(RequestBody body);
    }
}
