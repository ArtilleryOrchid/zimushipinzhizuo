package com.keyi.zimushipinzhizuo.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.bean.LoginEntity;
import com.keyi.zimushipinzhizuo.contract.LoginContract;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class LoginPresenter extends BasePresenter<LoginContract.LoginIView, LoginContract.LoginIModel> {
    @Inject
    public LoginPresenter(LoginContract.LoginIView loginIView, LoginContract.LoginIModel loginIModel) {
        super(loginIView, loginIModel);
    }

    public void loginRequest(String appName, String mobile) {
        Map<String, String> map = new HashMap<>();
        map.put("appName", appName);
        map.put("mobile", mobile);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.login_request(body)
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
                            Log.d("Data", "" + loginEntity);
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
