package com.keyi.zimushipinzhizuo.presenter;

import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.bean.LoginEntity;
import com.keyi.zimushipinzhizuo.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContract.LoginIView, LoginContract.LoginIModel> {
    @Inject
    public LoginPresenter(LoginContract.LoginIView loginIView, LoginContract.LoginIModel loginIModel) {
        super(loginIView, loginIModel);
    }

    public void loginRequest(String appName, String mobile) {
        m.login_request(appName, mobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        if (loginEntity == null) {
                            return;
                        } else {
                            v.loginSuccess(loginEntity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.loginError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
