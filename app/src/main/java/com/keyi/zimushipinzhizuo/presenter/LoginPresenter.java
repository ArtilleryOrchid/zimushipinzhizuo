package com.keyi.zimushipinzhizuo.presenter;

import com.google.gson.Gson;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.LoginContract;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginPresenter extends BasePresenter<LoginContract.LoginIView, LoginContract.LoginIModel> {
    @Inject
    public LoginPresenter(LoginContract.LoginIView loginIView, LoginContract.LoginIModel loginIModel) {
        super(loginIView, loginIModel);
    }

    public void codeRequest(String appName, String mobile) {
        Map<String, String> map = new HashMap<>();
        map.put("appName", appName);
        map.put("mobile", mobile);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.code_request(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<AppEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<AppEntity> Entity) {
                        if (Entity == null) {
                            return;
                        } else {
                            v.codeSuccess(Entity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.codeError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void loginRequest(String accountId, String appName, String brand, String channel, String deviceModel, String deviceType, String headImg, String mobile, String uuid, String verifyCode, String version) {
        Map<String, String> map = new HashMap<>();
        if (accountId.equals("")) {
            map.put("accountId", "");
        } else {
            map.put("accountId", accountId);
        }
        map.put("appName", appName);
        map.put("brand", brand);
        map.put("channel", channel);
        map.put("deviceModel", deviceModel);
        map.put("deviceType", deviceType);
        map.put("headImg", headImg);
        map.put("mobile", mobile);
        map.put("uuid", uuid);
        map.put("verifyCode", verifyCode);
        map.put("version", version);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.login_request(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<AppEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<AppEntity> entity) {
                        if (entity == null) {
                            return;
                        } else {
                            v.loginSuccess(entity);
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
