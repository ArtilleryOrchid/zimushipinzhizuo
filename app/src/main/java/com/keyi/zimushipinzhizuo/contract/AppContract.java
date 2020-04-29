package com.keyi.zimushipinzhizuo.contract;

import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Model.IModel;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.keyi.zimushipinzhizuo.bean.AppEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface AppContract {
    /**
     * 更新页面
     */
    interface AppIView extends IView {
        void AppBooleanSuccess(BaseEntity<Boolean> entity);

        void AppSuccess(BaseEntity<AppEntity> entity);

        void AppError(String error);
    }

    interface ProductIView extends IView {
        void ProductSuccess(BaseEntity<ArrayList<AppEntity.Data>> entity);

        void ProductError(String error);

        void CreatePaySuccess(BaseEntity<String> entity);

        void CreatePayError(String error);

        void PaySuccess(BaseEntity<ArrayList<AppEntity.Pay>> entity);

        void PayError(String error);

        void SubmitSuccess(BaseEntity<AppEntity.Submit> entity);

        void SubmitError(String error);
    }

    interface AppIModel extends IModel {

        /**
         * 我的接口
         */
        Observable<BaseEntity<AppEntity>> app_message_request(RequestBody body);

        Observable<BaseEntity<AppEntity>> code_request(RequestBody body);

        Observable<BaseEntity<Boolean>> logout_request(RequestBody body);

        /**
         * 登录接口
         */
        Observable<BaseEntity<AppEntity>> login_request(RequestBody body);

        /**
         * 支付接口
         */
        Observable<BaseEntity<String>> create_pay_request(RequestBody body);

        /**
         * @param body
         * @return
         */
        Observable<BaseEntity<ArrayList<AppEntity.Data>>> product_request(RequestBody body);

        Observable<BaseEntity<ArrayList<AppEntity.Pay>>> pay_request(RequestBody body);

        Observable<BaseEntity<AppEntity.Submit>> submit_request(RequestBody body);
    }
}
